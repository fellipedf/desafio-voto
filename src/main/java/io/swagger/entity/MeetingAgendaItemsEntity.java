package io.swagger.entity;

import io.swagger.model.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "meeting_agenda")
public class MeetingAgendaItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ASSOCIATE_ID")
    private Long meetingAgendaId;

    @OneToMany
    private List<ItemEntity> items;

    private Status status;

}
