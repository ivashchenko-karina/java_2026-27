package com.example.spaceportal.controller;

import com.example.spaceportal.model.Item;
import com.example.spaceportal.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items") // Переходимо на адресу /items
public class ItemController {

    @Autowired
    private ItemRepository repository;

    // READ: Виведення списку всіх космічних об'єктів
    @GetMapping
    public String listItems(Model model) {
        // За допомогою моделі передаємо список із бази в HTML-шаблон
        model.addAttribute("items", repository.findAll());
        return "index"; // Сервер шукатиме файл index.html у папці templates
    }

    // CREATE: Перехід на сторінку форми для додавання нового об'єкта
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("item", new Item()); // Передаємо порожній об'єкт для форми
        return "item-form";
    }

    // CREATE: Збереження об'єкта з форми
    @PostMapping("/save")
    public String saveItem(@ModelAttribute("item") Item item) {
        repository.save(item);
        return "redirect:/items"; // Після збереження повертаємось на список
    }

    // UPDATE: Перехід на форму редагування існуючого об'єкта
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Item item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Об'єкт не знайдено з id: " + id));
        model.addAttribute("item", item);
        return "item-form";
    }

    // DELETE: Видалення об'єкта за ID
    @GetMapping("/delete/{id}") // У Thymeleaf простіше викликати видалення через звичайне посилання
    public String deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/items";
    }
}