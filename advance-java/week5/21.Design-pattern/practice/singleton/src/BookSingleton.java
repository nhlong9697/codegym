public class BookSingleton {
  private String author;
  private String title;
  private static BookSingleton book;
  private static boolean isLoaned;

  private BookSingleton() {
    author = "Gamma, Helm, Johnson, and Vlissides";
    title = "Design patterns";
    book = null;
    isLoaned = false;
  }

  public static BookSingleton borrowBook() {
    if (!isLoaned) {
      if (book == null) {
        book = new BookSingleton();
      }
      isLoaned = true;
      return book;
    }
    return null;
  }

  public void returnBook(BookSingleton bookReturned) {
    isLoaned = false;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthorAndTitle() {
    return getTitle() + " by " + getAuthor();
  }
}
