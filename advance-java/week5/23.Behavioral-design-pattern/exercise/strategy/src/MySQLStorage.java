public class MySQLStorage implements UserStorage{
    @Override
    public void store(User user) {
        System.out.println("Store " + user.toString() + " in MySQLStorage");
    }
}
