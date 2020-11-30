package pl.edu.wszib.magazyn.database.impl;

import org.springframework.stereotype.Component;
import pl.edu.wszib.magazyn.database.IProductsRepository;
import pl.edu.wszib.magazyn.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepositoryImpl implements IProductsRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductsRepositoryImpl(){
        this.products.add(new Product("Motherboard", "ASUS Pro 1", 25, "ASP1", 450));
        this.products.add(new Product("Mouse", "Gaming X2", 32, "GX2", 50));
        this.products.add(new Product("Keyboard", "Log Z1", 12, "LZ1", 65));
        this.products.add(new Product("Processor", "Intel i5 9600K", 4, "Ii5", 996));
    }

    @Override
    public boolean addProductQuantity(String code, int quantity) {
        for (Product currentProduct : products){
            if (currentProduct.getCode().equals(code)){
                int newQuantity = quantity + currentProduct.getQuantity();
                currentProduct.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProductQuantity(String code, int quantity) {
        for (Product currentProduct : products){
            if (currentProduct.getCode().equals(code) && currentProduct.getQuantity() >= quantity){
                int newQuantity = currentProduct.getQuantity() - quantity;
                currentProduct.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }
}
