package com.example.spaceportal.controller;

import com.example.spaceportal.model.Item;
import com.example.spaceportal.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // Додає підтримку логування (вимога лабораторної)
@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*") // Дозволяє фронтенду на Vue.js робити запити
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getAllItems() {
        log.info("Отримання списку космічних об'єктів для API");
        return itemRepository.findAll();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        log.info("Додавання нового об'єкта через API: {}", item.getName());
        return itemRepository.save(item);
    }
}
