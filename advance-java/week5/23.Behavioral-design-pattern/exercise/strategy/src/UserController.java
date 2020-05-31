public class UserController {
    private UserStorage storage;

    public UserController(UserStorage storage) {
        this.storage = storage;
    }
    public void store(User user) {
        storage.store(user);
    }
}
