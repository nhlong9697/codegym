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
  public void downloadFile(String url) {
    try {
      URL url = new URL(url);
      URLConnection httpConnection = url.openConnection();
      httpConnection.setRequestProperty(
              "User-agent",
              "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36"
      );
      ReadableByteChannel tar = Channels.newChannel(httpConnection.getInputStream());
      FileOutputStream fos = new FileOutputStream("test.csv");
      fos.getChannel().transferFrom(tar,0,Long.MAX_VALUE);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
