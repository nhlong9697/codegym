import java.util.ArrayList;
import java.util.List;

public class PostManager implements IPostManager{
  List<Post> posts = new ArrayList<>();
  @Override
  public void create(Post post) {
    posts.add(post);
  }

  @Override
  public void read(int id) {
    posts.get(id);
  }

  @Override
  public void update(Post post) {
    posts.set(post.getId(),post);
  }

  @Override
  public void delete(int id) {
    posts.remove(id);
  }
}
