package io.swagger.service;

import io.swagger.api.ApiException;
import io.swagger.entity.AssociateEntity;
import io.swagger.exception.ApplicationException;
import io.swagger.exception.ExceptionType;
import io.swagger.mapper.AssociateMapper;
import io.swagger.model.Associate;
import io.swagger.repository.AssociateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
        Optional<AssociateEntity> associateEntity = repository.findById(Long.valueOf(id));
        if (associateEntity.isPresent()) {
            return associateMapper.map(associateEntity.get());
        }
        throw new ApplicationException("Usuario não encontado", ExceptionType.OTHER);
    }


    public List<Associate> findAll() {
        Iterable<AssociateEntity> all = repository.findAll();
        List<Associate> listReturn = new ArrayList<>();
        for (AssociateEntity a : all) {
            listReturn.add(associateMapper.map(a));
        }
        return listReturn;
    }
}
