package model;

public class User {
    private int id;
    private String name;
    private Cart cart;  // Kullanıcının sepeti

    // Constructor
    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.cart = new Cart(); // Her kullanıcı oluşturulduğunda boş sepet veriyoruz
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    // Kullanıcı bilgilerini yazdırmak için
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
