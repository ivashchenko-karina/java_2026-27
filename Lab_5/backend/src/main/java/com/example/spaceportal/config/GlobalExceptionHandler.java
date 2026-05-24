package com.example.spaceportal.config; // вкажи свій пакет, де лежить контролер

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Контролер для перехоплення помилок по всьому проєкту
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // Ловимо абсолютно всі винятки (Exception)
    public String handleException(Exception ex, Model model) {
        // Передаємо текст помилки на HTML сторінку
        model.addAttribute("message", ex.getMessage());
        return "error-page"; // Spring шукатиме файл error-page.html у папці templates
    }
}
