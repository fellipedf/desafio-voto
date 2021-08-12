package io.swagger.service;

import io.swagger.entity.AssociateEntity;
import io.swagger.entity.ItemEntity;
import io.swagger.entity.MeetingAgendaItemsEntity;
import io.swagger.entity.VoteEntity;
import io.swagger.exception.ApplicationException;
import io.swagger.exception.ExceptionType;
import io.swagger.mapper.ItemMapper;
import io.swagger.model.*;
import io.swagger.repository.AssociateRepository;
import io.swagger.repository.ItemRepository;
import io.swagger.repository.MeetingAgendaRepository;
import io.swagger.repository.VoteRepository;
import io.swagger.util.CpfValidatorIntegration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    private final AssociateRepository associateRepository;
    private final MeetingAgendaRepository meetingAgendaRepository;
    private final ItemRepository itemRepository;
    private final VoteRepository voteRepository;
    private final CpfValidatorIntegration cpfValidator;
    private final ItemMapper itemMapper;

    public VoteService(ItemMapper itemMapper,
                       AssociateRepository associateRepository,
                       MeetingAgendaRepository meetingAgendaRepository,
                       ItemRepository itemRepository, VoteRepository voteRepository, CpfValidatorIntegration cpfValidator) {
        this.associateRepository = associateRepository;
        this.meetingAgendaRepository = meetingAgendaRepository;
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.voteRepository = voteRepository;
        this.cpfValidator = cpfValidator;
    }


    public void save(Vote item) {
        VoteEntity.VoteEntityBuilder voteEntityBuilder = VoteEntity.builder();

        validateAssociate(item);

        Optional<MeetingAgendaItemsEntity> meetingAgenda = meetingAgendaRepository.findById(item.getMeetingAgendaId());
        if (meetingAgenda.isPresent() && meetingAgenda.get().getStatus() == Status.ON) {
            voteEntityBuilder.meetingAgenda(meetingAgenda.get());
        } else {
            throw new ApplicationException("Sessão de votação não dosponível", ExceptionType.OTHER);
        }
        Optional<AssociateEntity> associateEntity = findAssociate(item.getAssociateId());
        if (associateEntity.isPresent()) {
            cpfValidator.validateVotingAssociate(associateEntity.get().getCpfCnpj());
            voteEntityBuilder.associate(associateEntity.get());
        } else {
            throw new ApplicationException("Associado não cadastrado.", ExceptionType.OTHER);
        }

        for (VoteItem itemVote : item.getItems()) {
            voteEntityBuilder.vote(itemVote.getVote());
            Optional<ItemEntity> itemEntity = itemRepository.findById(itemVote.getItemId());
            if (itemEntity.isPresent()) {
                voteEntityBuilder.item(itemEntity.get());
            }
            voteRepository.save(voteEntityBuilder.build());
        }
    }




    private Optional<AssociateEntity> findAssociate(Long associateId) {
        return associateRepository.findById(associateId);
    }

    private void validateAssociate(Vote item) {
        Optional<List<VoteEntity>> associate = voteRepository.findByAssociateId(item.getAssociateId(), item.getMeetingAgendaId());
        if (associate.isPresent()) {
            throw new ApplicationException("O mesmo associado não pode votar mais de uma vez", ExceptionType.OTHER);
        }
    }


    public CountingVotes countingVotes(Long meetingAgendaId) {

        Optional<MeetingAgendaItemsEntity> meetings = meetingAgendaRepository.findById(meetingAgendaId);
        CountingVotes countingVotes = new CountingVotes();
        VotesTotal votesTotal;
        if (meetings.isPresent()) {
            for (ItemEntity item : meetings.get().getItems()) {
                votesTotal = new VotesTotal();
                votesTotal.setItemId(item.getItemId());
                votesTotal.setItemDescription(item.getDescription());
                votesTotal.setTotalVoteYes(voteRepository.countDistinctByItem_ItemIdAndVote(item.getItemId(), VoteEnum.YES));
                votesTotal.setTotalVoteNo(voteRepository.countDistinctByItem_ItemIdAndVote(item.getItemId(), VoteEnum.NO));
                countingVotes.getVotes().add(votesTotal);
            }
        } else {
            throw new ApplicationException("Sessão de votação não dosponível", ExceptionType.OTHER);
        }

        return countingVotes;
    }
}
