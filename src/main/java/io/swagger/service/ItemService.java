package io.swagger.service;

import io.swagger.api.ApiException;
import io.swagger.entity.ItemEntity;
import io.swagger.mapper.ItemMapper;
import io.swagger.model.Item;
import io.swagger.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository repository;

    public ItemService(ItemMapper itemMapper, ItemRepository repository) {
        this.itemMapper = itemMapper;
        this.repository = repository;
    }

    public void save(Item item) {
        repository.save(itemMapper.toEntity(item));
    }

    public void delete(String id) {
        repository.deleteById(Long.valueOf(id));
    }

    public Item findItemById(String id) throws ApiException {
        Optional<ItemEntity> associateEntity = repository.findById(Long.valueOf(id));
        if (associateEntity.isPresent()) {
            return itemMapper.map(associateEntity.get());
        }
        throw new ApiException(201, "Item não encontado");
    }


    public List<Item> findAll() {
        Iterable<ItemEntity> all = repository.findAll();
        List<Item> listReturn = new ArrayList<>();
        for (ItemEntity i : all) {
            listReturn.add(itemMapper.map(i));
        }
        return listReturn;
    }

}
