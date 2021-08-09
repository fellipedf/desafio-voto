package io.swagger.entity;

import io.swagger.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "meeting_agenda")
public class MeetingAgendaItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ASSOCIATE_ID")
    private Long meetingAgendaId;

    @ManyToMany
    private List<ItemEntity> items;

    private Status status;

}
