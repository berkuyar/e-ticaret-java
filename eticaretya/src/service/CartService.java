package service;

import model.Cart;
import model.Product;

public class CartService {
    private Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    // Sepete ürün ekle
    public void addToCart(Product product) {
        if (product != null) {
            cart.addProduct(product);
            System.out.println(product.getName() + " sepete eklendi.");
        } else {
            System.out.println("Geçersiz ürün.");
        }
    }

    // Sepetten ürün çıkar
    public void removeFromCart(Product product) {
        if (product != null) {
            cart.removeProduct(product);
            System.out.println(product.getName() + " sepetten çıkarıldı.");
        } else {
            System.out.println("Geçersiz ürün.");
        }
    }

    // Sepeti yazdır
    public void showCart() {
        cart.printCart();
    }

    // Toplam fiyatı göster
    public void showTotalPrice() {
        System.out.println("Sepet toplamı: " + cart.getTotalPrice() + "₺");
    }
}

