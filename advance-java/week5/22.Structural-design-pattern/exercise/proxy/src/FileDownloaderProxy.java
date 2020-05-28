public class FileDownloaderProxy implements Downloader{
  private FileDownloader fileDownloader;

  public FileDownloaderProxy() {
    this.fileDownloader = new FileDownloader();
  }

  @Override
  public void downloadFile(String url) {
    fileDownloader.downloadFile(url);
  }
}
