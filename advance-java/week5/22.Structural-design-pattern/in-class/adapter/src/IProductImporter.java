import java.util.List;

public interface IProductImporter {
  List<Product> importFile(String path);

}
