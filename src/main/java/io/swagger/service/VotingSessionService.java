package io.swagger.service;

import io.swagger.api.ApiException;
import io.swagger.api.NotFoundException;
import io.swagger.entity.ItemEntity;
import io.swagger.entity.MeetingAgendaItemsEntity;
import io.swagger.mapper.ItemMapper;
import io.swagger.mapper.MeetingAgendaMapper;
import io.swagger.model.Item;
import io.swagger.model.MeetingAgendaItems;
import io.swagger.model.PatchStatus;
import io.swagger.model.Status;
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

    public void create(MeetingAgendaItems item) throws ApiException {
        Optional<List<MeetingAgendaItemsEntity>> meetingAgenda = repository.findByStatus(Status.ON);
        if (meetingAgenda.isPresent()) {
            throw new ApiException(5, "Existe uma sessão de votação em andamento");
        }
        repository.save(meetingAgendaMapper.toEntity(item));
    }


    public List<MeetingAgendaItems> findAll() {
        Iterable<MeetingAgendaItemsEntity> all = repository.findAll();
        List<MeetingAgendaItems> listReturn = new ArrayList<>();
        for (MeetingAgendaItemsEntity i : all) {
            listReturn.add(meetingAgendaMapper.map(i));
        }
        return listReturn;
    }

    public MeetingAgendaItems update(String id, PatchStatus body) throws ApiException {

        Optional<MeetingAgendaItemsEntity> meetAgenda = repository.findById(Long.valueOf(id));
        if (meetAgenda.isPresent()) {
            meetAgenda.get().setStatus(body.getStatus());
            return meetingAgendaMapper.map(repository.save(meetAgenda.get()));
        } else {
            throw new ApiException(6, "Não foi possível atualizar a sessão de votação");
        }

    }

    public MeetingAgendaItems findVotingSessionById(String id) throws NotFoundException {

        Optional<MeetingAgendaItemsEntity> byId = repository.findById(Long.valueOf(id));
        if (byId.isPresent()) {
            return meetingAgendaMapper.map(byId.get());
        } else {
            throw new NotFoundException(7, "Sessão de votação não encontrada");
        }
    }
}
