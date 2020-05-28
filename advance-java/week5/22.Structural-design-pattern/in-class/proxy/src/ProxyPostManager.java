public class ProxyPostManager implements IPostManager {
  private String username;
  private String password;
  public ProxyPostManager(String username, String password) {
    this.username = username;
    this.password = password;
  }

  private IPostManager realPostManager = new PostManager();
  private boolean isAdmin() {
    if (username.equals("admin") && password.equals("admin")) {
      return true;
    }
    return false;
  }

  @Override
  public void create(Post post) {
    if (this.isAdmin()) {
      realPostManager.create(post);
    }
    else {
      throw new RuntimeException("you cannot create");
    }
  }

  @Override
  public void read(int id) {
    realPostManager.read(id);
  }

  @Override
  public void update(Post post) {
    if (this.isAdmin()) {
      realPostManager.update(post);
    }
    else {
      throw new RuntimeException("you cannot update bruh");
    }
  }

  @Override
  public void delete(int id) {
    if (this.isAdmin()) {
      realPostManager.delete(id);
    } else {
      throw new RuntimeException("you canot read bruh");
    }
  }
}
