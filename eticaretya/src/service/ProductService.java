package service;

import model.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    // Tüm ürünleri listele
    public void listAllProducts() {
        List<Product> products = productRepository.getAllProducts();
        System.out.println("Mevcut Ürünler:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // ID'ye göre ürün getir
    public Product findProductById(int id) {
        return productRepository.getProductById(id);
    }

    // Stok kontrolü
    public boolean isInStock(Product product) {
        return product != null && product.getStock() > 0;
    }

    // Stok düşür (satın alındığında ya da sepete eklenince)
    public void decreaseStock(Product product) {
        if (product != null && product.getStock() > 0) {
            product.setStock(product.getStock() - 1);
        }
    }
}

