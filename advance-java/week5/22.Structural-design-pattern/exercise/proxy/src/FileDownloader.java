import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileDownloader implements Downloader{
  @Override
  public void downloadFile(String urlString) {
    try {
      URL url = new URL(urlString);
      URLConnection httpConnection = url.openConnection();
      httpConnection.setRequestProperty(
              "User-agent",
              "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36"
      );
      ReadableByteChannel tar = Channels.newChannel(httpConnection.getInputStream());
      FileOutputStream fos = new FileOutputStream("sample.mp3");
      fos.getChannel().transferFrom(tar,0,Long.MAX_VALUE);
      fos.close();
      tar.close();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
