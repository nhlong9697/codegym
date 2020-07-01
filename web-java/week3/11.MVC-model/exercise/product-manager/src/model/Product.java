package model;

public class Product {
  private int id;
  private String productName;
  private int price;
  private int quantity;
  private String color;
  private String description;
  private String category;

  public Product(int id,String productName, int price, int quantity, String color,
                 String description, String category) {
    this.id = id;
    this.productName = productName;
    this.price = price;
    this.quantity = quantity;
    this.color = color;
    this.description = description;
    this.category = category;
  }

  public Product(String productName, int price, int quantity, String color,
                 String description, String category) {

    this.productName = productName;
    this.price = price;
    this.quantity = quantity;
    this.color = color;
    this.description = description;
    this.category = category;
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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
