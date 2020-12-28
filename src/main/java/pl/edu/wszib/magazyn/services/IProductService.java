package pl.edu.wszib.magazyn.services;

import pl.edu.wszib.magazyn.model.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(int id);
    void updateProduct(Product product);
    List <Product> getAllProducts();

}