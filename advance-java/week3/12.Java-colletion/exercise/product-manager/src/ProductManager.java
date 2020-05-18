import java.util.ArrayList;

public class ProductManager {
  private ArrayList<Product> productsList;

  public ProductManager() {
    this.productsList = new ArrayList<>();
  }

  public void addProduct(String name, double price) {
    Product newProduct = new Product(price, name);
    this.productsList.add(newProduct);
  }

  public void editProductName(String oldName, String newName) {
    int indexValue = getProductIndexByName(oldName);
    if (indexValue != -1) {
      this.productsList.set(indexValue, new Product(this.productsList.get(indexValue).getPrice(), newName));
    } else {
      System.out.println("there is no " + oldName);
    }
  }

  public void deleteProduct(String productName) {
    int indexValue = getProductIndexByName(productName);
    if (indexValue != -1) {
      this.productsList.remove(indexValue);
    } else {
      System.out.println("cant delete " + productName);
    }
  }

  private int getProductIndexByName(String productName) {
    int indexValue = -1;
    for (int i = 0; i < this.productsList.size(); i++) {
      if(this.productsList.get(i).getName().equals(productName));
        indexValue = i;
    }
    return indexValue;
  }
}
