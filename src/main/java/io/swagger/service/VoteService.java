package io.swagger.service;

import io.swagger.api.ApiException;
import io.swagger.entity.AssociateEntity;
import io.swagger.entity.ItemEntity;
import io.swagger.entity.MeetingAgendaItemsEntity;
import io.swagger.entity.VoteEntity;
import io.swagger.mapper.ItemMapper;
import io.swagger.model.Item;
import io.swagger.model.Vote;
import io.swagger.model.VoteItem;
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


    public void save(Vote item) {
        VoteEntity.VoteEntityBuilder voteEntityBuilder = VoteEntity.builder();

        Optional<AssociateEntity> associateEntity = associateRepository.findById(item.getAssociateId());
        if (associateEntity.isPresent()) {
            voteEntityBuilder.associate(associateEntity.get());
        }
        Optional<MeetingAgendaItemsEntity> meetingAgenda = meetingAgendaRepository.findById(item.getMeetingAgendaId());
        if (meetingAgenda.isPresent()) {
            voteEntityBuilder.meetingAgenda(meetingAgenda.get());
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

    public void delete(String id) {
        itemRepository.deleteById(Long.valueOf(id));
    }

    public Item findItemById(String id) throws ApiException {
        Optional<ItemEntity> associateEntity = itemRepository.findById(Long.valueOf(id));
        if (associateEntity.isPresent()) {
            return itemMapper.map(associateEntity.get());
        }
        throw new ApiException(201, "Item não encontado");
    }


    public List<Item> findAll() {
        Iterable<ItemEntity> all = itemRepository.findAll();
        List<Item> listReturn = new ArrayList<>();
        for (ItemEntity i : all) {
            listReturn.add(itemMapper.map(i));
        }
        return listReturn;
    }

}
