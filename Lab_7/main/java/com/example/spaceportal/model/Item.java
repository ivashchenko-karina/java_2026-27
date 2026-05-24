package com.example.spaceportal.model;

import jakarta.persistence.*;
import lombok.*; // Імпорт Lombok

@Entity
@Table(name = "items")
@Data // Додаємо це (автоматично створить геттери та сеттери)
@NoArgsConstructor // Додаємо це (створить пустий конструктор)
@AllArgsConstructor // Додаємо це (створить конструктор з усіма полями)
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