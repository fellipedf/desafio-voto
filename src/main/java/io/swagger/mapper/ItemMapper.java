package io.swagger.mapper;

import io.swagger.entity.ItemEntity;
import io.swagger.model.Item;
import io.swagger.repository.ItemRepository;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    private final ItemRepository itemRepository;

    public ItemMapper(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public ItemEntity toEntity(Item item) {
        return ItemEntity.builder()
                .description(item.getDescription())
                .build();
    }

    public Item map(ItemEntity itemEntity) {
        return  Item.builder()
                .id(itemEntity.getItemId())
                .description(itemEntity.getDescription())
                .build();
    }

    public List<ItemEntity> toEntityList(List<Long> itemIds) {
        List<ItemEntity> itemEntities = new ArrayList<>();
        for (Long item : itemIds) {
            Optional<ItemEntity> itemEntity = itemRepository.findById(item);
            if (itemEntity.isPresent()) {
                itemEntities.add(itemEntity.get());
            }
        }
        return itemEntities;
    }

    public List<Long> toMapList(List<ItemEntity> items) {
        List<Long> itemsId = new ArrayList<>();
        for (ItemEntity item : items) {
            itemsId.add(item.getItemId());
        }
        return itemsId;

    }


}
