package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    public Cart(){
        this.products = new ArrayList<>();
    }

    //ürün ekleme

    public void addProduct(Product product){
        products.add(product);
    }
    // Sepetten ürün çıkarma
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Sepetteki ürünleri döndür
    public List<Product> getProducts() {
        return products;
    }

    // Toplam fiyat hesapla
    public double getTotalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    // Sepeti yazdırma
    public void printCart() {
        if (products.isEmpty()) {
            System.out.println("Sepetiniz boş.");
        } else {
            System.out.println("Sepetinizdeki ürünler:");
            for (Product p : products) {
                System.out.println(p);
            }
            System.out.println("Toplam Fiyat: " + getTotalPrice() + "₺");
        }
    }
}
