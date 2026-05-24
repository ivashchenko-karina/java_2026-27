package com.example.spaceportal.controller;

import com.example.spaceportal.model.Item;
import com.example.spaceportal.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:5500")
public class ItemController {
    @Autowired
    private ItemRepository repository;
    @GetMapping
    public List<Item> getAllItems() {
        return repository.findAll();
    }
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return repository.save(item);
    }
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        Item item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Об'єкт не знайдено з id: " + id));
        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        item.setImageUrl(itemDetails.getImageUrl());
        return repository.save(item);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}