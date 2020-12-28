package pl.edu.wszib.magazyn.services;

public interface IStorageService {
    double calculateTotal();
    void addProductByIdToStorage(int id);
}
