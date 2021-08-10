package io.swagger.service;

import io.swagger.api.ApiException;
import io.swagger.entity.AssociateEntity;
import io.swagger.entity.ItemEntity;
import io.swagger.entity.MeetingAgendaItemsEntity;
import io.swagger.entity.VoteEntity;
import io.swagger.mapper.ItemMapper;
import io.swagger.model.*;
import io.swagger.repository.AssociateRepository;
import io.swagger.repository.ItemRepository;
import io.swagger.repository.MeetingAgendaRepository;
import io.swagger.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    private final AssociateRepository associateRepository;
    private final MeetingAgendaRepository meetingAgendaRepository;
    private final ItemRepository itemRepository;
    private final VoteRepository voteRepository;
    private final ItemMapper itemMapper;

    public VoteService(ItemMapper itemMapper,
                       AssociateRepository associateRepository,
                       MeetingAgendaRepository meetingAgendaRepository,
                       ItemRepository itemRepository, VoteRepository voteRepository) {
        this.associateRepository = associateRepository;
        this.meetingAgendaRepository = meetingAgendaRepository;
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.voteRepository = voteRepository;
    }


    public void save(Vote item) throws ApiException {
        VoteEntity.VoteEntityBuilder voteEntityBuilder = VoteEntity.builder();

        validateAssociate(item);

        Optional<MeetingAgendaItemsEntity> meetingAgenda = meetingAgendaRepository.findById(item.getMeetingAgendaId());
        if (meetingAgenda.isPresent() && meetingAgenda.get().getStatus() == Status.ON) {
            voteEntityBuilder.meetingAgenda(meetingAgenda.get());
        } else {
            throw new ApiException(2, "Sessão de votação não dosponível");
        }
        Optional<AssociateEntity> associateEntity = associateRepository.findById(item.getAssociateId());
        if (associateEntity.isPresent()) {
            voteEntityBuilder.associate(associateEntity.get());
        } else {
            throw new ApiException(4, "Associado não cadastrado.");
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

    private void validateAssociate(Vote item) throws ApiException {
        Optional<List<VoteEntity>> associate = voteRepository.findByAssociateId(item.getAssociateId());
        if (associate.isPresent()) {
            throw new ApiException(3, "O mesmo associado não pode votar mais de uma vez");
        }
    }


    public CountingVotes countingVotes(Long meetingAgendaId) throws ApiException {

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
            throw new ApiException(2, "Sessão de votação não dosponível");
        }

        return countingVotes;
    }
}
