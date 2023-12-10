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
        System.out.println("5. Add customers");
        System.out.println("6. Removing customers");
//        System.out.println("7. Editing profiles");
        System.out.println("7. View registered customers");

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
                System.out.printf("Enter Product Name");
                name=in.nextLine();
                db.deleteProduct(con,name);
                break;
            case "3":
                System.out.println("All products List :");
                db.allProduct(con);
                break;
            case "4":
                System.out.printf("Enter Product Name");
                name=in.nextLine();
                db.searchProduct(con,name);
                break;
            case "5":
                System.out.println("Enter customer name");
                name=in.nextLine();
                System.out.println("Enter Age");
                String age = in.nextLine();
                System.out.println("Enter city");
                String cityName=in.nextLine();
                db.createCustomer(con,name,age,cityName);
                break;
            case "6":
                System.out.printf("Enter Customer Name you want to delete");
                name=in.nextLine();
                db.deleteCustomer(con,name);
                break;
            case "7":
                System.out.println("All Customers List :");
                db.allCustomers(con);
                break;
            default:break;


        }
    }
}
