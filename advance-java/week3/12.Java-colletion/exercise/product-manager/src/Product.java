public class Product {
  private static int id = 0;
  private String name;
  private double price;
  private int productId;

  public Product(double price, String name) {
    this.price = price;
    this.name = name;
    this.productId = Product.id;
    Product.id++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getId() {
    return this.productId;
  }

}
