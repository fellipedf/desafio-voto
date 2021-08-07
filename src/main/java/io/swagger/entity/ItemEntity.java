package io.swagger.entity;

import io.swagger.model.VoteEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ITEM_ID")
    private Long itemId;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_id")
    private VoteEntity vote;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "meeting_agenda_id")
//    private MeetingAgendaItemsEntity agendaItem;

    private VoteEnum voteEnum;

}
