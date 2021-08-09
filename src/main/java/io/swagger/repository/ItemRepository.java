package io.swagger.repository;

import io.swagger.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long>, JpaSpecificationExecutor<ItemEntity> {
}
