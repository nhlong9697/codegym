public class StrategyDemo {
    public static void main(String[] args) {
        User user = new User();
        XMLStorage XMLStorage = new XMLStorage();
        MySQLStorage mySQLStorage = new MySQLStorage();
        UserController userControllerXML = new UserController(XMLStorage);
        UserController userControllerMySQL = new UserController(mySQLStorage);
        userControllerMySQL.store(user);
        userControllerXML.store(user);

    }
}
