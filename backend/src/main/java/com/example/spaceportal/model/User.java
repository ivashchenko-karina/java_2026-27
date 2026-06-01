package com.example.spaceportal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // "users", бо слово "user" у багатьох БД є зарезервованим
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role; // Роль користувача (наприклад, "ROLE_USER")
}
