package io.swagger.api;

import io.swagger.model.Vote;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T16:28:41.873Z[GMT]")
@RestController
public class VotesApiController implements VotesApi {

    private static final Logger log = LoggerFactory.getLogger(VotesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final VoteService service;

    @org.springframework.beans.factory.annotation.Autowired
    public VotesApiController(ObjectMapper objectMapper, HttpServletRequest request, VoteService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = service;
    }

    @Override
    public ResponseEntity<Vote> findVotes() {
        return null;
    }

    @Override
    public ResponseEntity<Void> insertVote(Vote body) throws ApiException {
        service.save(body);
        return ResponseEntity.ok().build();
    }
}
