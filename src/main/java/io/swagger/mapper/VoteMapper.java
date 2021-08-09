package io.swagger.mapper;

import io.swagger.entity.ItemEntity;
import io.swagger.entity.VoteEntity;
import io.swagger.model.Item;
import io.swagger.model.Vote;
import io.swagger.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VoteMapper {


    public Item map(ItemEntity itemEntity) {
        return  Item.builder()
                .id(itemEntity.getItemId())
                .description(itemEntity.getDescription())
                .build();
    }

}
