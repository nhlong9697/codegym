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
        //throw new FileAlreadyExistsException(targetFile.getAbsolutePath());
        System.out.println("file already existed");
      }
      //read and copy
      try (
              BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
              BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile, true))
      ) {
        int byteRead;
        int totalBytesCopied = 0;
        while ((byteRead = inputStream.read()) != -1) {
          outputStream.write((byte) byteRead);
          totalBytesCopied++;
        }
        System.out.println("copy successful");
        System.out.println(totalBytesCopied + "bytes copied");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } //catch (FileAlreadyExistsException exception) {
      //System.out.println("File already exists");
    //}
  }
}
