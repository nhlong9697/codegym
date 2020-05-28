import java.util.ArrayList;
import java.util.List;

public class ProductExcelAdapter implements IProductImporter {
  private ProductProviderExporter provider;

  public ProductExcelAdapter(ProductProviderExporter provider) {
    this.provider = provider;
  }

  @Override
  public List<Product> importFile(String path) {
    List<Product> products = new ArrayList<>();
    String textFile = this.convertExcelToTextFile();
    //read text file
    return products;
  }

  String convertExcelToTextFile() {
    String excelFile = provider.exportFile();

    return "products.txt";
  }
}
