package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();

        // Hazır ürünler ekleyelim
        products.add(new Product(1, "Laptop", 15000, 5));
        products.add(new Product(2, "Telefon", 10000, 10));
        products.add(new Product(3, "Kulaklık", 1500, 20));
        products.add(new Product(4, "Klavye", 700, 15));
        products.add(new Product(5, "Mouse", 500, 25));
    }
    // Tüm ürünleri döndür
    public List<Product> getAllProducts() {
        return products;
    }

    // ID'ye göre ürün bul
    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // bulunamazsa null döndür
    }
}
