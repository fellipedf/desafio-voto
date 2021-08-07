package io.swagger.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "vote")
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_VOTE_ID")
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "associate_id")
    private AssociateEntity associate;

    @OneToMany(mappedBy = "vote")
    private List<ItemEntity> items;

}
