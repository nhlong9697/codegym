import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class Copy {
  public static void main(String[] args) throws IOException {
    //check status
    File sourceFile = null;
    File targetFile = null;
    try {
      sourceFile = new File("dumpling.mp3");
      if (!sourceFile.exists()) {
        throw new FileNotFoundException();
      }
      targetFile = new File("target.mp3");
      if (targetFile.exists()) {
        throw new FileAlreadyExistsException(targetFile.getAbsolutePath());
      }//read and copy
      try (
              BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
              BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile))
      ) {
        int byteRead;
        double numberOfByteCopied = 0;
        while ((byteRead = inputStream.read()) != -1) {
          outputStream.write((byte) byteRead);
          numberOfByteCopied++;
        }
        System.out.println("copy successful");
        System.out.println(numberOfByteCopied + " bytes copied");
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (FileAlreadyExistsException exception) {
      System.out.println("File already exists");
    }
  }
}
