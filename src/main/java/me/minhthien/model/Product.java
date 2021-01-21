package me.minhthien.model;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private String imageUrl;
    private Double price;
    private int quantity;
    private LocalDate lastImportDate;
    
    public Product() {
    }
    
    public Product(String name, String imageUrl, Double price, int quantity,
        LocalDate lastImportDate) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.quantity = quantity;
        this.lastImportDate = lastImportDate;
    }
    
    /*
    *   Getter & Setter
    * */
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public LocalDate getLastImportDate() {
        return lastImportDate;
    }
    
    public void setLastImportDate(LocalDate lastImportDate) {
        this.lastImportDate = lastImportDate;
    }
    
    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            ", lastImportDate=" + lastImportDate +
            '}';
    }
}
