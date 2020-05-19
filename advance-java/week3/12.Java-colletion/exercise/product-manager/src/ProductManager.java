import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Collections;

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
      this.productsList.get(indexValue).setName(newName);
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
      if(this.productsList.get(i).getName().equals(productName))
        indexValue = i;
    }
    return indexValue;
  }

  public void sortAscendingPrice() {
    Collections.sort(productsList);
  }

  public void sortDescendingPrice() {
    Collections.sort(productsList, Collections.reverseOrder());
  }

  public void displayProduct() {
    for (Product product: productsList) {
      System.out.println(product.toString());
    }
  }
}
