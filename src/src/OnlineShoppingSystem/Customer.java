package OnlineShoppingSystem;

import java.sql.Connection;
import java.util.Scanner;

public class Customer {
    public void customerFunction(Connection con, String customerId) {
        var choice = "0";
        while (!choice.equals("7"))
        {
            System.out.println("Welcome customer");
            System.out.println("1 - View product list");
            System.out.println("2 - Search product namewise");
//    System.out.println("3 - Search product typewise");
            System.out.println("3 - Add Product to cart");
            System.out.println("4 - Remove product from cart");
            System.out.println("5 - View Cart");
            System.out.println("6 - Proceed to payment");
//    System.out.println("7 - Edit profile");
            System.out.println("7 - Logout from system");

            Scanner in = new Scanner(System.in);
            choice = in.nextLine();

            Database db = new Database();
            switch (choice) {
                case "1":
                    System.out.println("All products List :");
                    db.allProduct(con);
                    break;
                case "2":
                    System.out.printf("Enter Product Name");
                    String name = in.nextLine();
                    db.searchProduct(con, name);
                    break;
                case "3":
                    System.out.printf("Enter Product number");
                    var productId = in.nextLine();
                    db.addProductCart(con, productId,customerId );
                    break;
                case "4":
                    System.out.printf("Enter Product number");
                    productId = in.nextLine();
                    db.removeProductCart(con, productId,customerId );
                    break;
                case "5":
                    db.allCartList(con,customerId);
                    break;
                case "6":
                    System.out.println("All Cart products bought");
                    db.removeAllProductCart(con, customerId);
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
        }
    }
}
