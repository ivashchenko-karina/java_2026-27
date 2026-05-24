package com.example.spaceportal.model;

import jakarta.persistence.*;
import lombok.*; // Додаємо імпорт Lombok

@Entity
@Table(name = "items") // Твоя правильна таблиця з БД
@Data // Генерує гетери, сетери, toString, equals та hashCode автоматично
@NoArgsConstructor // Генерує порожній конструктор public Item() {}
@AllArgsConstructor // Генерує конструктор з усіма полями
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;
}