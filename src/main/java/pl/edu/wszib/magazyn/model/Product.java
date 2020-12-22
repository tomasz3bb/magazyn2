package pl.edu.wszib.magazyn.model;

public class Product {
    int id;
    String category;
    String name;
    int quantity;
    String code;
    double price;

    public Product(int id, String category, String name, int quantity, String code, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.code = code;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}

