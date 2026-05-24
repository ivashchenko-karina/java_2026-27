package com.example.spaceportal.repository;

import com.example.spaceportal.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Додаємо цю анотацію, щоб Spring автоматично створив API за адресою /api/items
@RepositoryRestResource(path = "items")
public interface ItemRepository extends JpaRepository<Item, Long> {
}