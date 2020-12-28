package pl.edu.wszib.magazyn.DAO.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.magazyn.DAO.IProductDAO;
import pl.edu.wszib.magazyn.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    Connection connection;

    @Override
    public Product getProductById(int id) {
        String sql = "SELECT * FROM tproduct WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return new Product(resultSet.getInt("id"),
                    resultSet.getString("category"),
                    resultSet.getString("name"),
                    resultSet.getString("code"),
                    resultSet.getInt("quantity"),
                    resultSet.getDouble("price"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        String sql ="UPDATE tproduct SET category = ?, name = ?, code = ?, quantity = ?, price = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getCategory());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getCode());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.setInt(6, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tproduct;";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                products.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("category"),
                        resultSet.getString("name"),
                        resultSet.getString("code"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("price")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}
