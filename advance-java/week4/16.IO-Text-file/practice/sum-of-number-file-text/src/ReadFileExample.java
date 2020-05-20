import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class ReadFileExample {
  public static void main(String[] args) throws IOException {
    //write to txt file
    File sourceFile = null;
    try {
      sourceFile = new File("numbers.txt");
      if (sourceFile.exists()) {
        throw new FileAlreadyExistsException(sourceFile.getAbsolutePath());
      }
    }
    catch(FileAlreadyExistsException e) {
      System.out.println("File already exists");
    }
    //write
    try (PrintWriter sourcePrintWriter = new PrintWriter(new BufferedWriter(new FileWriter(sourceFile)))) {
    //append instead of write
    // try (PrintWriter sourcePrintWriter = new PrintWriter(new BufferedWriter(new FileWriter(sourceFile,true)))) {
      for (int i = 1; i <= 5; i++) {
        sourcePrintWriter.println(i);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    //calculate sum
    readTextFile(sourceFile);
  }

  public static void readTextFile(File file) {
    try {
      if (!file.exists()) {
        throw new FileNotFoundException();
      }
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = "";
      int sum = 0;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
        sum += Integer.parseInt(line);
      }
      reader.close();
      System.out.println("sum is " + sum);
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
