package io.swagger.repository;

import io.swagger.entity.MeetingAgendaItemsEntity;
import io.swagger.model.Status;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingAgendaRepository extends CrudRepository<MeetingAgendaItemsEntity, Long>, JpaSpecificationExecutor<MeetingAgendaItemsEntity> {


    Optional<List<MeetingAgendaItemsEntity>> findByStatus(Status status);
}
