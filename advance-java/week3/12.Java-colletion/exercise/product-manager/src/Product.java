public class Product implements Comparable<Product> {
  private static int id = 0;
  private String name;
  private int price;
  private int productId;

  public Product(int price, String name) {
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

  public int getPrice() {
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
    if (this.price == product.price) {
      return 0;
    }
    else if (this.price > product.price) {
      return 1;
    }
    else {
      return -1;
    }
  }
}
