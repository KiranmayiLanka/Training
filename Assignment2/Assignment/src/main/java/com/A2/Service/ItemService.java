package com.A2.Service;

import org.springframework.stereotype.Service;

import com.A2.entities.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private List<Item> items = new ArrayList<>();
    
    public ItemService() {
    	
        items.add(new Item(1l, "Item 1"));
        items.add(new Item(2l, "Item 2"));
        items.add(new Item(3l, "Item 3"));
    }

    public List<Item> getAllItems() {
        return items;
    }

    public Item getItemById(Long id) {
        // Find and return an item by ID or handle not found case
        return items.stream()
            .filter(item -> item.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItem(Long id, Item updatedItem) {
        // Update the item with the provided ID, or handle not found case
        items.stream()
            .filter(item -> item.getId().equals(id))
            .findFirst()
            .ifPresent(item -> {
                item.setName(updatedItem.getName());
            });
    }

    public void deleteItem(Long id) {
        // Remove the item with the provided ID, or handle not found case
        items.removeIf(item -> item.getId().equals(id));
    }
}

