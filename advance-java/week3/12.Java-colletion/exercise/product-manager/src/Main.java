public class Main {
  public static void main(String[] args) {
    ProductManager productManager = new ProductManager();
    productManager.addProduct("book",12);
    productManager.addProduct("car",100);
    productManager.addProduct("cake",300);
    productManager.addProduct("candy",84);
    productManager.addProduct("apple",5);
    productManager.addProduct("shirt",211);
    productManager.displayProduct();
    System.out.println();
    productManager.deleteProduct("cake");
    productManager.displayProduct();
    System.out.println();
    productManager.editProductName("candy","chewing gum");
    productManager.displayProduct();
    System.out.println();
    productManager.sortAscendingPrice();
    productManager.displayProduct();
    System.out.println();
    productManager.sortDescendingPrice();
    productManager.displayProduct();
    System.out.println();
  }
}
