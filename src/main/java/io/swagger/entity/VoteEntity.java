package io.swagger.entity;

import io.swagger.model.VoteEnum;
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
@Table(name = "vote")
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_VOTE_ID")
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "associate_id")
    private AssociateEntity associate;

    @ManyToOne
    @JoinColumn(name = "meeting_agenda_id")
    private MeetingAgendaItemsEntity meetingAgenda;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    private VoteEnum vote;

}
