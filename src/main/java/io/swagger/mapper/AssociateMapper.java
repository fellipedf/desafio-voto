package io.swagger.mapper;

import io.swagger.entity.AssociateEntity;
import io.swagger.model.Associate;
import org.springframework.stereotype.Component;

@Component
public class AssociateMapper {

    public AssociateEntity toEntity(Associate associate) {
        return AssociateEntity.builder()
                .name(associate.getName())
                .cpfCnpj(associate.getCpfCnpj())
                .build();
    }

    public Associate map(AssociateEntity associateEntity) {
        return  Associate.builder()
                .id(associateEntity.getAssociateId())
                .name(associateEntity.getName())
                .cpfCnpj(associateEntity.getCpfCnpj())
                .build();
    }

}
