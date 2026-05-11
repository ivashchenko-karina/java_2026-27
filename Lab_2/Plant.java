package org.example.model;

public class Plant {
    private String name;
    private String description;
    private String light;
    private String watering;
    private String price;
    private String imageUrl;

    public Plant(String name, String description, String light, String watering, String price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.light = light;
        this.watering = watering;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLight() { return light; }
    public void setLight(String light) { this.light = light; }

    public String getWatering() { return watering; }
    public void setWatering(String watering) { this.watering = watering; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}