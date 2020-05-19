public class Product implements Comparable<Product> {
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

  @Override
  public int compareTo(Product product) {
    if (this.price > product.getPrice()) {
      return 1;
    }
    else if (this.price < product.getPrice()) {
      return -1;
    }
    else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return this.name + "-" + this.productId + "-" + this.price;
  }
}
