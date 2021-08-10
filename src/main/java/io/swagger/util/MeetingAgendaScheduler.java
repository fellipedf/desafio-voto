package io.swagger.util;


import io.swagger.entity.MeetingAgendaItemsEntity;
import io.swagger.model.Status;
import io.swagger.repository.MeetingAgendaRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@EnableScheduling
public class MeetingAgendaScheduler {

    private final MeetingAgendaRepository repository;

    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;

    public MeetingAgendaScheduler(MeetingAgendaRepository repository) {
        this.repository = repository;
    }


    @Scheduled(fixedDelay = MINUTO)
    public void verificaPorHora() {
        Optional<List<MeetingAgendaItemsEntity>> byStatus = repository.findByStatus(Status.ON);
        if (byStatus.isPresent()) {
            for (MeetingAgendaItemsEntity meet : byStatus.get()) {
                if (meet.getFinishTime().isBefore(LocalDateTime.now())) {
                    meet.setStatus(Status.OFF);
                    repository.save(meet);
                }
            }
        }
    }
}
