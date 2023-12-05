package OnlineShoppingSystem;

import java.sql.Connection;

public class Shop {
    public static void main(String[] args) {

        Database db = new Database();
        Connection con = db.connectToDatabase();
        System.out.println("Welcome to Online Shopping Portal");
        db.closeConnection(con);
    }
}
