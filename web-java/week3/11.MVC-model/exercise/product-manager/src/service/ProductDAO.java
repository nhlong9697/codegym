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
    private static final String SORT_BY_A_CATEGORY = "SELECT id,productName,category, price FROM " +
            "demo.products ORDER BY %s";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT id, productName, category, price " +
            "FROM demo.products WHERE id = ?";
    private static final String SEARCH_PRODUCT_BY_PRODUCT_NAME = "SELECT " +
            "id, " +
            "productName," +
            "category," +
            "price " +
            "FROM demo.products WHERE productName LIKE ?";
    private static final String INSERT_PRODUCT = "INSERT INTO demo.products (" +
            "productName," +
            "category," +
            "price" +
            ") " +
            "VALUES (?,?,?);";
    private static final String DELETE_PRODUCT = "DELETE FROM demo.products WHERE ID = ?";
    private static final String UPDATE_USER = "UPDATE demo.products " +
            "SET productName = ?, " +
            "category = ?, " +
            "price = ? " +
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
                String category = rs.getString("category");
                int price = rs.getInt("price");
                products.add(new Product(id,productName,category,price));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByName(String nameToFind) {
        List<Product> product = new ArrayList<>();
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
                String category = rs.getString("category");
                int price = rs.getInt("price");
                product.add(new Product(id,productName,category,price));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return product;
    }

    @Override
    public void add(Product product) {
        System.out.println(INSERT_PRODUCT);
        try (
                Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_PRODUCT)
        ) {
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setString(2,product.getCategory());
            preparedStatement.setInt(3,product.getPrice());
            preparedStatement.executeUpdate();
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
               String category = rs.getString("category");
               int price = rs.getInt("price");
               product = new Product(id,productName,category,price);
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
            preparedStatement.setString(2,product.getCategory());
            preparedStatement.setInt(3,product.getPrice());
            preparedStatement.setInt(4,id);
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
                String category = rs.getString("category");
                int price = rs.getInt("price");
                sortedProducts.add(new Product(id,productName,category,price));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return sortedProducts;
    }
}
