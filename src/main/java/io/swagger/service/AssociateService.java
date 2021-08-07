package io.swagger.service;

import io.swagger.mapper.AssociateMapper;
import io.swagger.model.Associate;
import io.swagger.repository.AssociateRepository;
import org.springframework.stereotype.Service;

@Service
public class AssociateService {
    private final AssociateRepository repository;
    private final AssociateMapper associateMapper;

    public AssociateService(AssociateRepository repository, AssociateMapper associateMapper) {
        this.repository = repository;
        this.associateMapper = associateMapper;
    }

    public void save(Associate associate) {
        repository.save(associateMapper.toEntity(associate));
    }

    public void delete(String id) {
        repository.deleteById(Long.valueOf(id));
    }

    public Associate findAssociateById(String id) {
        repository.findById(Long.valueOf(id));
        return associateMapper.map(repository.findById(Long.valueOf(id)));
    }
}
