package OnlineShoppingSystem;

import java.sql.Connection;
import java.util.Scanner;

public class Customer {
public void customerFunction(Connection con){
    System.out.println("Welcome customer");
    System.out.println("1 - View product list");
    System.out.println("2 - Search product namewise");
    System.out.println("3 - Search product typewise");
    System.out.println("4 - Add Product to cart");
    System.out.println("5 - Remove product from cart");
    System.out.println("6 - View Cart");
    System.out.println("7 - Proceed to payment");
    System.out.println("8 - Edit profile");
    System.out.println("9 - Logout from system");

    Scanner in = new Scanner(System.in);
    var choice = in.nextLine();

    switch (choice)
    {
        case "1":
            break;
        case "2":
            break;
        case "3":
            break;
        case "4":
            break;
        case "5":
            break;
        case "6":
            break;
        case "7":
            break;
        case "8":
            break;
        case "9":
            break;
        default:
            System.out.println("Wrong Choice");
    }
}
}
