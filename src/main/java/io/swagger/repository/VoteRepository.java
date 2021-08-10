package io.swagger.repository;

import io.swagger.entity.VoteEntity;
import io.swagger.model.Vote;
import io.swagger.model.VoteEnum;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends CrudRepository<VoteEntity, Long>, JpaSpecificationExecutor<VoteEntity> {

    @Query("select v from VoteEntity v where v.associate.associateId = ?1")
    Optional<List<VoteEntity>> findByAssociateId(Long associateId);

    Integer countDistinctByItem_ItemIdAndVote(Long itemId, VoteEnum vote);


}
