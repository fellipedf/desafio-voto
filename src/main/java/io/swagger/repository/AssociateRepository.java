package io.swagger.repository;

import io.swagger.entity.AssociateEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateRepository extends CrudRepository<AssociateEntity, Long>, JpaSpecificationExecutor<AssociateEntity> {
}
