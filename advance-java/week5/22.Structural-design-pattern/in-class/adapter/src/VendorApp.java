import java.util.List;

public class VendorApp {
  public static void main(String[] args) {
    ProductProviderExporter exporter = new ProductProviderExporter();
    IProductImporter productImporter = new ProductExcelAdapter(exporter);
    List<Product> products = productImporter.importFile("");
  }
}
