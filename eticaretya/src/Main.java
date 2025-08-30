import model.Product;
import model.User;
import service.CartService;
import service.ProductService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Başlangıç nesneleri
        User user = new User(1, "Berk");
        ProductService productService = new ProductService();
        CartService cartService = new CartService(user.getCart());

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== E-Ticaret Sistemine Hoşgeldiniz ===");

        do {
            // Menü
            System.out.println("\n1- Ürünleri Listele");
            System.out.println("2- Sepete Ürün Ekle");
            System.out.println("3- Sepeti Görüntüle");
            System.out.println("4- Sepetten Ürün Çıkar");
            System.out.println("5- Çıkış");
            System.out.print("Seçiminiz: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Ürünleri listele
                    productService.listAllProducts();
                    break;

                case 2: // Sepete ürün ekle
                    System.out.print("Eklemek istediğiniz ürünün ID'sini girin: ");
                    int addId = scanner.nextInt();
                    Product addProduct = productService.findProductById(addId);

                    if (productService.isInStock(addProduct)) {
                        cartService.addToCart(addProduct);
                        productService.decreaseStock(addProduct); // stoktan düş
                    } else {
                        System.out.println("Ürün bulunamadı veya stokta yok.");
                    }
                    break;

                case 3: // Sepeti göster
                    cartService.showCart();
                    break;

                case 4: // Sepetten ürün çıkar
                    System.out.print("Çıkarmak istediğiniz ürünün ID'sini girin: ");
                    int removeId = scanner.nextInt();
                    Product removeProduct = productService.findProductById(removeId);

                    if (removeProduct != null) {
                        cartService.removeFromCart(removeProduct);
                    } else {
                        System.out.println("Geçersiz ürün.");
                    }
                    break;

                case 5: // Çıkış
                    System.out.println("Çıkış yapılıyor. İyi günler!");
                    break;

                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        } while (choice != 5);

        scanner.close();
    }
}