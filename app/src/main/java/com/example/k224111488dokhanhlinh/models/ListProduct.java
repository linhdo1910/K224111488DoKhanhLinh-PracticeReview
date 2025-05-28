package com.example.k224111488dokhanhlinh.models;

import java.util.ArrayList;
import java.util.List;
public class ListProduct {
    private List<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
        generateSampleData();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void generateSampleData() {
        products.add(new Product(1, "P001", "Coca Cola", 10.0,
                "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-ltbc2mbfhrixeb.webp"));
        products.add(new Product(2, "P002", "Pepsi", 9.5,
                "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lte7vjofzh6sde.webp"));
        products.add(new Product(3, "P003", "7Up", 8.0,
                "https://down-vn.img.susercontent.com/file/3acc1dbb3356714154be600f4054aadd.webp"));
        products.add(new Product(4, "P004", "Fanta", 8.5,
                "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lwfzbhv7w7ob00@resize_w900_nl.webp"));
        products.add(new Product(5, "P005", "Sprite", 9.0,
                "https://down-vn.img.susercontent.com/file/bb43e1e305aa159ef5cd03157a42821f.webp"));
        products.add(new Product(6, "P006", "Chocolate Cake", 25.0,
                "https://down-vn.img.susercontent.com/file/a36cbebdb1c90e98b9514bbd6b0bece1.webp"));
        products.add(new Product(7, "P007", "Cheesecake", 28.0,
                "https://down-vn.img.susercontent.com/file/sg-11134201-7rbnb-lqnbl826v6t698.webp"));
        products.add(new Product(8, "P008", "Apple Juice", 12.0,
                "https://example.com/images/apple_juice.jpg"));
        products.add(new Product(9, "P009", "Orange Juice", 12.0,
                "https://example.com/images/orange_juice.jpg"));
        products.add(new Product(10, "P010", "Banana Smoothie", 15.0,
                "https://example.com/images/banana_smoothie.jpg"));
        products.add(new Product(11, "P011", "Strawberry Yogurt", 18.0,
                "https://example.com/images/strawberry_yogurt.jpg"));
        products.add(new Product(12, "P012", "Green Tea", 7.0,
                "https://example.com/images/green_tea.jpg"));
        products.add(new Product(13, "P013", "Black Coffee", 10.0,
                "https://example.com/images/black_coffee.jpg"));
        products.add(new Product(14, "P014", "Latte", 12.0,
                "https://example.com/images/latte.jpg"));
        products.add(new Product(15, "P015", "Cappuccino", 12.0,
                "https://example.com/images/cappuccino.jpg"));
        products.add(new Product(16, "P016", "Espresso", 11.0,
                "https://example.com/images/espresso.jpg"));
        products.add(new Product(17, "P017", "Mango Juice", 13.0,
                "https://example.com/images/mango_juice.jpg"));
        products.add(new Product(18, "P018", "Watermelon Juice", 14.0,
                "https://example.com/images/watermelon_juice.jpg"));
        products.add(new Product(19, "P019", "Pineapple Juice", 13.0,
                "https://example.com/images/pineapple_juice.jpg"));
        products.add(new Product(20, "P020", "Lemon Tea", 9.0,
                "https://example.com/images/lemon_tea.jpg"));
    }
    public boolean isExist(Product p) {
        for (Product existingProduct : products) {
            if (existingProduct.getId() == p.getId() ||
                    (existingProduct.getProductCode() != null && existingProduct.getProductCode().equalsIgnoreCase(p.getProductCode())) ||
                    (existingProduct.getName() != null && existingProduct.getName().equalsIgnoreCase(p.getName()))) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product p) {
        products.add(p);
    }
}
