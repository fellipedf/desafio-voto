package io.swagger.mapper;

import io.swagger.entity.AssociateEntity;
import io.swagger.model.Associate;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AssociateMapper {

    AssociateEntity toEntity(Associate associate);

    Associate map(AssociateEntity byId);
}
