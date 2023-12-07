package OnlineShoppingSystem;

import java.sql.Connection;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {

        Database db = new Database();
        Connection con = db.connectToDatabase();
        System.out.println("");
        System.out.println("Welcome to Online Shopping Portal");
        System.out.println("");


        boolean cont=true;
        while(cont) {
            System.out.println("*********************************************************");
            System.out.println("");
            System.out.println("1 - REGISTER AS ADMIN");
            System.out.println("2 - REGISTER AS CUSTOMER");
            System.out.println("3 - LOGIN TO SYSTEM");
            System.out.println("4 - EXIT");
            System.out.println("");
            System.out.println("*********************************************************");
            System.out.println("");

            System.out.println("Enter choice : ");

            Scanner in = new Scanner(System.in);
            var choice = in.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Pressed 1");
                    System.out.println("Enter Username : ");
                    var username = in.nextLine();
                    System.out.println("Enter Password : ");
                    var password = in.nextLine();

                    var result = db.adminLogin(username, password, con);
                    if (result) {
                        //admin function call
                        System.out.println("Logged into Admin");
                        Admin ad = new Admin();
                        ad.adminFuntion(con);

                    }
                    break;

                case "2":
                    System.out.println("Register as Customer");
                    break;

                case "3":
                    System.out.println("Login to System");
                    break;

                case "4":
                    System.out.println("Exit");
                    cont=false;
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
        db.closeConnection(con);
    }
}
