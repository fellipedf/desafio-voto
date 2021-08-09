package io.swagger.api;

import io.swagger.model.Associate;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.AssociateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T16:28:41.873Z[GMT]")
@RestController
public class AssociatesApiController implements AssociatesApi {

    private static final Logger log = LoggerFactory.getLogger(AssociatesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final AssociateService associateService;

    @org.springframework.beans.factory.annotation.Autowired
    public AssociatesApiController(ObjectMapper objectMapper, HttpServletRequest request, AssociateService associateService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.associateService = associateService;
    }

    @Override
    public ResponseEntity<Associate> findAssociateById(String id) throws ApiException {
        return ResponseEntity.ok(associateService.findAssociateById(id));
    }


    @Override
    public ResponseEntity<List<Associate>> findAssociates(String name) {
        return ResponseEntity.ok().body(associateService.findAll());
    }


    @Override
    public ResponseEntity<Void> insertAssociate(Associate body) {
        associateService.save(body);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> removeAssociate(String id) {
        associateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
