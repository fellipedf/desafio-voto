package io.swagger.mapper;

import io.swagger.entity.MeetingAgendaItemsEntity;
import io.swagger.model.MeetingAgendaItems;
import io.swagger.repository.ItemRepository;
import org.springframework.stereotype.Component;

@Component
public class MeetingAgendaMapper {

    private final ItemMapper itemMapper;

    public MeetingAgendaMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public MeetingAgendaItemsEntity toEntity(MeetingAgendaItems meet) {
        return MeetingAgendaItemsEntity.builder()
                .items(itemMapper.toEntityList(meet.getItems()))
                .status(meet.getStatus())
                .build();
    }

    public MeetingAgendaItems map(MeetingAgendaItemsEntity meetingAgendaItemsEntity) {
        return  MeetingAgendaItems.builder()
                .id(meetingAgendaItemsEntity.getMeetingAgendaId())
                .items(itemMapper.toMapList(meetingAgendaItemsEntity.getItems()))
                .status(meetingAgendaItemsEntity.getStatus())
                .build();
    }

}
