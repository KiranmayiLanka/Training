package com.A2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.A2.Service.ItemService;
import com.A2.entities.Item;

@RestController
@RequestMapping("items")
public class ItemController {
	
    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/getid/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        itemService.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }


}
