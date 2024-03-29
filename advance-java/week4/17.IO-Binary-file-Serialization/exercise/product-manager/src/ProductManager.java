import java.io.*;

public class ProductManager {
  public static void main(String[] args) throws IOException {
    try (
      ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object.dat")));
    ) {
      output.writeObject(new Product("iPhone10", 2000, "Apple"));
      output.writeObject(new Product("galaxy10", 1500, "Samsung"));
      output.writeObject(new Product("note9", 200, "Xiaomi"));
    }
    try (
      ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("object.dat")))
    ) {
      Product readObject;
      while ((readObject = (Product) input.readObject()) != null) {
        System.out.println(readObject);
      }
    } catch (ClassNotFoundException e) {
      System.out.println("class not found");
    } catch (EOFException ignored) {
    }
  }
}
