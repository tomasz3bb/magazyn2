package pl.edu.wszib.magazyn.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.magazyn.database.IDataBase;
import pl.edu.wszib.magazyn.model.Product;

import java.util.Scanner;

@Component
public class GUI implements IGUI{

    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    Scanner scanner3 = new Scanner(System.in);

    @Autowired
    public IDataBase dataBase;

    @Override
    public void showMainMenu() {

        System.out.println("1. Show all products");
        System.out.println("2. Add quantity to the product");
        System.out.println("3. Delete quantity of the product");
        System.out.println("4. Exit");

        String choose = scanner.nextLine();

        switch (choose){
            case "1":
                this.showAllProducts();
                this.showMainMenu();
                break;
            case "2":
                this.addQuantity();
                this.showMainMenu();
                break;
            case "3":
                this.deleteQuantity();
                this.showMainMenu();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Wrong number !");
                this.showMainMenu();
                break;

        }
    }
    private void showAllProducts(){
        for (Product product : this.dataBase.getAllProducts()){
            System.out.println(product);
        }
    }
    private void addQuantity(){
        System.out.println("Code: ");
        String code = scanner2.nextLine();
        System.out.println("Quantity: ");
        int quantity = scanner3.nextInt();
        boolean result = this.dataBase.addProductQuantity(code, quantity);
        if (result){
            System.out.println("Successed!");
        }else {
            System.out.println("Error! Wrong product code! ");
        }
    }
    private void deleteQuantity(){
        System.out.println("Code: ");
        String code = scanner2.nextLine();
        System.out.println("Quantity: ");
        int quantity = scanner3.nextInt();
        boolean result = this.dataBase.deleteProductQuantity(code, quantity);
            if (result){
                System.out.println("Successed!");
            }else {
                System.out.println("Error! Wrong product code or quantity!");
            }
        }
}
