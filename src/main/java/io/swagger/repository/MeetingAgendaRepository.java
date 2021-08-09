package io.swagger.repository;

import io.swagger.entity.MeetingAgendaItemsEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingAgendaRepository extends CrudRepository<MeetingAgendaItemsEntity, Long>, JpaSpecificationExecutor<MeetingAgendaItemsEntity> {
}
