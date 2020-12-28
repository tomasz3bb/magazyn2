package pl.edu.wszib.magazyn.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.magazyn.DAO.IProductDAO;
import pl.edu.wszib.magazyn.model.Product;
import pl.edu.wszib.magazyn.services.IStorageService;
import pl.edu.wszib.magazyn.session.SessionObject;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements IStorageService {

    @Autowired
    IProductDAO productDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public double calculateTotal() {
        double sum = 0;
        for (Product product : this.sessionObject.getStorage()) {
            sum = sum + product.getPrice() * product.getQuantity();
        }
        return sum;
    }

    @Override
    public void addProductByIdToStorage(int id) {
        Product product = this.productDAO.getProductById(id);
        for (Product productFromStorage : this.sessionObject.getStorage()){
            if (productFromStorage.getId() == product.getId()){
                productFromStorage.setQuantity(productFromStorage.getQuantity() +1 );
                return;
            }
        }
        product.setQuantity(1);
        this.sessionObject.getStorage().add(product);
    }

    @Override
    public void deleteProductByIdFromStorage(int id) {
        Product product = this.productDAO.getProductById(id);
        for (Product productFromStorage : this.sessionObject.getStorage()){
            if (productFromStorage.getId() == product.getId()){
                productFromStorage.setQuantity(productFromStorage.getQuantity() - 1);
                return;
            }
        }
        product.setQuantity(1);
        this.sessionObject.getStorage().remove(product);
    }
}
