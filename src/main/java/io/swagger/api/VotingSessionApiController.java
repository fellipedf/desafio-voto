package io.swagger.api;

import io.swagger.model.MeetingAgendaItems;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.PatchStatus;
import io.swagger.service.VotingSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T16:28:41.873Z[GMT]")
@RestController
public class VotingSessionApiController implements VotingSessionApi {

    private static final Logger log = LoggerFactory.getLogger(VotingSessionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final VotingSessionService service;

    @org.springframework.beans.factory.annotation.Autowired
    public VotingSessionApiController(ObjectMapper objectMapper, HttpServletRequest request, VotingSessionService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = service;
    }

    @Override
    public ResponseEntity<List<MeetingAgendaItems>> findVotingSession(String description) {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<MeetingAgendaItems> findVotingSessionById(String id) throws NotFoundException {
        return ResponseEntity.ok(service.findVotingSessionById(id));
    }

    @Override
    public ResponseEntity<Void> insertVotingSession(MeetingAgendaItems body) throws ApiException {
        service.create(body);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<MeetingAgendaItems> updateVotingSession(String id, PatchStatus body) throws ApiException {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, body));
    }
}
