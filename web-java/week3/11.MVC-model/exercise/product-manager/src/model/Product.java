package model;

public class Product {
  private int id;
  private String category;
  private String productName;
  private int price;

  public Product(int id,String category, String productName, int price) {
    this.id = id;
    this.productName = productName;
    this.price = price;
    this.category = category;
  }

  public Product(String category, String productName, int price) {

    this.category = category;
    this.productName = productName;
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
