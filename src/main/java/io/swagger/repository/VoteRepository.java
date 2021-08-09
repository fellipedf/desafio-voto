package io.swagger.repository;

import io.swagger.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<VoteEntity, Long>, JpaSpecificationExecutor<VoteEntity> {
}
