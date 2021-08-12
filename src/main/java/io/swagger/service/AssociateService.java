package io.swagger.service;

import io.swagger.entity.AssociateEntity;
import io.swagger.exception.ApplicationException;
import io.swagger.exception.ExceptionType;
import io.swagger.mapper.AssociateMapper;
import io.swagger.model.Associate;
import io.swagger.repository.AssociateRepository;
import io.swagger.util.CpfValidatorIntegration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AssociateService {
    private final AssociateRepository repository;
    private final AssociateMapper associateMapper;
    private final CpfValidatorIntegration cpfValidatorIntegration;

    public AssociateService(AssociateRepository repository, AssociateMapper associateMapper, CpfValidatorIntegration cpfValidatorIntegration) {
        this.repository = repository;
        this.associateMapper = associateMapper;
        this.cpfValidatorIntegration = cpfValidatorIntegration;
    }

    public void save(Associate associate) {
        cpfValidatorIntegration.validate(associate.getCpfCnpj());
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
