package io.swagger.api;

import io.swagger.model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-06T16:28:41.873Z[GMT]")
@RestController
public class ItemsApiController implements ItemsApi {

    private static final Logger log = LoggerFactory.getLogger(ItemsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ItemService service;

    @org.springframework.beans.factory.annotation.Autowired
    public ItemsApiController(ObjectMapper objectMapper, HttpServletRequest request, ItemService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = service;
    }

    @Override
    public ResponseEntity<Item> findItemById(String id) throws ApiException {
        return ResponseEntity.ok(service.findItemById(id));
    }

    @Override
    public ResponseEntity<List<Item>> findItems(String name) {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<Void> insertItem(Item body) {
        service.save(body);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> removeItem(String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
