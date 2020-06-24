package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
  private static Map<Integer, Product> products;

  static {
    products = new HashMap<>();
    products.put(1, new Product(1,"Book","The old man and the sea", 25));
    products.put(2, new Product(2, "Laptop", "Dell Inspiron 3580", 1000));
    products.put(3, new Product(3, "Beverage","Pepsi", 3));
    products.put(4, new Product(4, "Laptop","Macbook Air", 2500));
    products.put(5, new Product(5, "Phone","Xiaomi Rednote 4", 400));
    products.put(6, new Product(6, "Phone","IPhone 10", 1000));
    products.put(7, new Product(7, "Phone","Samsung galaxy S8", 800));
    products.put(8, new Product(8, "Book","The Intelligent Investor", 3));
  }
  @Override
  public List<Product> findAll() {
    return new ArrayList<>(products.values());
  }

  @Override
  public List<Product> findByName(String nameToFind) {
    ArrayList<Product> productListByName = new ArrayList<>();
    for (Product product : products.values()) {
      if (product.getProductName().toLowerCase().contains(nameToFind.toLowerCase())) {
        productListByName.add(product);
      }
    }
    return productListByName;
  }

  @Override
  public void add(Product product) {
    int id = (int) (Math.random() * 10000);
    product.setId(id);
    products.put(product.getId(),product);
  }

  @Override
  public Product findById(int id) {
    return products.get(id);
  }

  @Override
  public void update(int id, Product product) {
    products.put(id,product);
  }

  @Override
  public void remove(int id) {
    products.remove(id);
  }

  @Override
  public List<Product> sortBy(String searchCategory) {
    return null;
  }
}
