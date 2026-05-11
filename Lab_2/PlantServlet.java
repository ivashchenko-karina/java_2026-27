package org.example.servlet;

import com.google.gson.Gson;
import org.example.model.Plant;

// Оновлені імпорти під Tomcat 10 (Jakarta)
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/plants")
public class PlantServlet extends HttpServlet {

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Налаштування CORS та кодування відповіді
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        response.setContentType("application/json;charset=UTF-8");

        List<Plant> plants = new ArrayList<>();
        plants.add(new Plant(
                "Монстера Деліціоза",
                "Популярна ліана з великим перфорованим листям. Символ стильного інтер'єру.",
                "Півтінь або розсіяне світло",
                "Помірний, після висихання верхнього шару землі",
                "450 грн",
                "https://a.allegroimg.com/original/115022/9396ee02452392aceddaa46f769a/SZTUCZNA-Roslina-MONSTERA-DELICIOSA-50-75-cm-DUZA-Ozdoba-REALISTYCZNA-XL"
        ));
        plants.add(new Plant(
                "Фікус Лірата",
                "Елегантне деревце з великим листям у формі скрипки. Потребує простору.",
                "Яскраве розсіяне світло",
                "Регулярний, не допускати застою води",
                "680 грн",
                "https://plantsroom.com.ua/wp-content/uploads/2024/07/img_9028.jpg"
        ));
        plants.add(new Plant(
                "Сансев'єрія",
                "Надзвичайно витривала рослина, яка чудово очищує повітря.",
                "Тіньовитривала, росте будь-де",
                "Рідкісний, раз на 2-3 тижні",
                "250 грн",
                "https://floriya.market/files/95908f78dbff.png"
        ));

        String jsonResponse = this.gson.toJson(plants);

        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}