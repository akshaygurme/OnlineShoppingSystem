package OnlineShoppingSystem;

import java.sql.Connection;
import java.util.Scanner;

public class Admin {

    public void adminFuntion(Connection con)
    {
        System.out.println("Welcome to Admin portal");
        System.out.println("1. Add Products");
        System.out.println("2. Delete Products");
        System.out.println("3. View All Products");
        System.out.println("4. Search Product");
        System.out.println("5. Adding customers");
        System.out.println("6. Removing customers");
        System.out.println("7. Editing profiles");
        System.out.println("8. View registered customers");

        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();

        Database db = new Database();

        switch (choice)
        {
            case "1":
                System.out.println("Enter Product Name");
                String name=in.nextLine();
                System.out.println("Enter Price");
                String price=in.nextLine();
                System.out.println("Enter Product Quantity");
                String quantity=in.nextLine();
                db.addProduct(con,name,price,quantity);
                break;
            case "2":
                break;
            case "3":break;
            case "4":break;
            case "5":break;
            case "6":break;
            case "7":break;
            case "8":break;
            default:break;


        }
    }
}
