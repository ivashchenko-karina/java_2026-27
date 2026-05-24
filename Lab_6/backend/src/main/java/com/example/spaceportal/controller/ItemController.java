package com.example.spaceportal.controller;

import com.example.spaceportal.model.Item;
import com.example.spaceportal.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    // GET - Отримати всі космічні об'єкти
    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // POST - Створити новий об'єкт
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    // PUT - Оновити існуючий за ID (виправлено під твої поля)
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));

        // Використовуємо рідні name, description та imageUrl
        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        item.setImageUrl(itemDetails.getImageUrl());

        Item updatedItem = itemRepository.save(item);
        return ResponseEntity.ok(updatedItem);
    }

    // DELETE - Видалити за ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));

        itemRepository.delete(item);
        return ResponseEntity.noContent().build();
    }
}