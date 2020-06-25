package model;

public class Product {
  private int id;
  private String productName;
  private String category;
  private int price;

  public Product(int id,String productName, String category, int price) {
    this.id = id;
    this.productName = productName;
    this.category = category;
    this.price = price;
  }

  public Product(String productName, String category, int price) {

    this.productName = productName;
    this.category = category;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
