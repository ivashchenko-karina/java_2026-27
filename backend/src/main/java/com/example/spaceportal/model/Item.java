package com.example.spaceportal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@Data                  // Автоматичні Getter/Setter від Lombok
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000) // щоб довгий опис поміщався в базу
    private String description;

    private String imageUrl;
}
