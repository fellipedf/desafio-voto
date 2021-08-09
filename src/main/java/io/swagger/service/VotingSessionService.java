package io.swagger.service;

import io.swagger.api.ApiException;
import io.swagger.entity.ItemEntity;
import io.swagger.entity.MeetingAgendaItemsEntity;
import io.swagger.mapper.ItemMapper;
import io.swagger.mapper.MeetingAgendaMapper;
import io.swagger.model.Item;
import io.swagger.model.MeetingAgendaItems;
import io.swagger.repository.ItemRepository;
import io.swagger.repository.MeetingAgendaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VotingSessionService {

    private final MeetingAgendaMapper meetingAgendaMapper;
    private final MeetingAgendaRepository repository;

    public VotingSessionService(MeetingAgendaMapper meetingAgendaMapper, MeetingAgendaRepository repository) {
        this.meetingAgendaMapper = meetingAgendaMapper;
        this.repository = repository;
    }

    public void create(MeetingAgendaItems item) {
        repository.save(meetingAgendaMapper.toEntity(item));
    }

    public void delete(String id) {
        repository.deleteById(Long.valueOf(id));
    }

//    public Item findItemById(String id) throws ApiException {
//        Optional<ItemEntity> associateEntity = repository.findById(Long.valueOf(id));
//        if (associateEntity.isPresent()) {
//            return meetingAgendaMapper.map(associateEntity.get());
//        }
//        throw new ApiException(201, "Item não encontado");
//    }


    public List<MeetingAgendaItems> findAll() {
        Iterable<MeetingAgendaItemsEntity> all = repository.findAll();
        List<MeetingAgendaItems> listReturn = new ArrayList<>();
        for (MeetingAgendaItemsEntity i : all) {
            listReturn.add(meetingAgendaMapper.map(i));
        }
        return listReturn;
    }

}
