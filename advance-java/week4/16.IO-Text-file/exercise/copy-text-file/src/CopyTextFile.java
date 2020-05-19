import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import java.io.*;
public class CopyTextFile {
  public static void main(String[] args) throws IOException{
    //write source file
    try {
      FileWriter sourceFile = new FileWriter("sourceFile.txt");
      sourceFile.write("This is the source file");
      sourceFile.close();
    }
    catch (FileAlreadyExistsException ex) {
      System.out.println("file already exist");
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    //read source file and copy to target file
    try {
      //read source file
      File sourceFile = new File("sourceFile.txt");
      FileReader sourceFileReader = new FileReader(sourceFile);
      BufferedReader sourceFileBuffer = new BufferedReader(sourceFileReader);

      //write to target file
      FileWriter targetFile = new FileWriter("targetFile.txt");
      String sourceFileLine;
      String targetFileLine;
      while ((sourceFileLine = sourceFileBuffer.readLine()) != null) {
        targetFileLine = sourceFileLine.replaceAll("source", "target");
        targetFile.write(targetFileLine);
      }
      targetFile.close();
      sourceFileBuffer.close();
    }
    catch(FileNotFoundException ex) {
      System.out.println("file is not found");
    }
    catch(FileAlreadyExistsException ex) {
      System.out.println("file already exist");
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    //read target file after copy
    try {
      File targetFile = new File("targetFile.txt");
      FileReader targetFileReader = new FileReader(targetFile);
      BufferedReader targetFileBuffer = new BufferedReader(targetFileReader);
      String targetFileLine;
      while((targetFileLine = targetFileBuffer.readLine()) != null) {
        System.out.println(targetFileLine);
      }
      targetFileBuffer.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
