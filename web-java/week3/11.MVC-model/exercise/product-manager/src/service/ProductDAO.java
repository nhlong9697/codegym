package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ProductService{

    private String jdbcPassword = "Long12345^";
    private String jdbcUsername = "long";
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM demo.products";
    private static final String SORT_BY_A_CATEGORY = "SELECT " +
            "id,productName, price, quantity,color,description,category FROM " +
            "demo.products ORDER BY %s";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT " +
            "id, " +
            "productName," +
            "price," +
            "quantity, " +
            "color, " +
            "description, " +
            "category " +
            "FROM demo.products WHERE id = ?";
    private static final String SEARCH_PRODUCT_BY_PRODUCT_NAME = "SELECT " +
            "id, " +
            "productName," +
            "price," +
            "quantity, " +
            "color, " +
            "description, " +
            "category " +
            "FROM demo.products WHERE productName LIKE ?";

    private static final String INSERT_PRODUCT = "INSERT INTO demo.products (" +
            "productName," +
            "price," +
            "quantity, " +
            "color, " +
            "description, " +
            "category" +
            ") " +
            "VALUES (?,?,?,?,?,?);";

    private static final String DELETE_PRODUCT = "DELETE FROM demo.products WHERE ID = ?";
    private static final String UPDATE_USER = "UPDATE demo.products " +
            "SET " +
            "productName = ?, " +
            "price = ?, " +
            "quantity = ?, " +
            "color = ?, " +
            "description = ?, " +
            "category = ? " +
            "WHERE id = ?";
    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
        ) {

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                products.add(new Product(id,productName,price,quantity,color,description,category));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByName(String nameToFind) {
        List<Product> foundProducts = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_BY_PRODUCT_NAME);
        ) {

            preparedStatement.setString(1,"%" + nameToFind + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                foundProducts.add(new Product(id,productName,price,quantity,color,description,category));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return foundProducts;
    }

    @Override
    public void add(Product product) {
        System.out.println(INSERT_PRODUCT);
        try (
                Connection connection = getConnection(); CallableStatement callableStatement =
                connection.prepareCall(INSERT_PRODUCT)
        ) {
            callableStatement.setString(1,product.getProductName());
            callableStatement.setInt(2,product.getPrice());
            callableStatement.setInt(3,product.getQuantity());
            callableStatement.setString(4,product.getColor());
            callableStatement.setString(5,product.getDescription());
            callableStatement.setString(6,product.getCategory());
            callableStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
        ) {

           preparedStatement.setInt(1,id);
           System.out.println(preparedStatement);
           ResultSet rs = preparedStatement.executeQuery();

           while(rs.next()) {
               String productName = rs.getString("productName");
               int price = rs.getInt("price");
               int quantity = rs.getInt("quantity");
               String color = rs.getString("color");
               String description = rs.getString("description");
               String category = rs.getString("category");
               product = new Product(id,productName,price,quantity,color,description,category);
           }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setString(6,product.getCategory());
            preparedStatement.setInt(7,id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =
                connection.prepareStatement(DELETE_PRODUCT);

        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Product> sortBy(String sortCategory) {
        List<Product> sortedProducts = new ArrayList<>();
        String sortByACategoryStatement = String.format(SORT_BY_A_CATEGORY,sortCategory);
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sortByACategoryStatement);
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                sortedProducts.add(new Product(id,productName,price,quantity,color,description,category));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return sortedProducts;
    }

    @Override
    public List<String> categoryList() {
        return null;
    }
}
