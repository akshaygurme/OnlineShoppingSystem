package OnlineShoppingSystem;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class Database {

    public Connection connectToDatabase(){

        Connection con=null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Mysql Driver loaded");

            String url = "jdbc:mysql://localhost:3306/Online_Shopping_DB";
            String username = "root";
            String password = "Akshay@123";

            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection created Successfully");

        }catch (Exception e)
        {
            System.out.println(e);
        }
        return con;
    }

    public void closeConnection(Connection con){
        try {
            con.close();
            System.out.println("Connection Closed Successfully");
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void insertData(){
        String query = "insert into ";
    }

    public boolean adminLogin(String username, String password, Connection con)
    {
        String query="select * from admin_Login where username='" + username + "' and password='" + password + "'";
        try {
            Statement st = con.createStatement();
            var result = st.executeQuery(query);
            if(result!=null)
            {
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public void addProduct(Connection con, String name, String price, String quantity){
        String query = "insert into product_data (name,price,quantity) values (?, ?, ?)";

        //use prepared statement
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, price);
            st.setString(3, quantity);

            st.execute();
            System.out.println("Added Product");

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public  void deleteProduct(Connection con,String name){
        String query = "delete from product_data where name = '"+name+"'";

        try
        {
        Statement st = con.createStatement();
        st.execute(query);
        System.out.println("Delete Product");
        }catch (Exception e)
        {
            System.out.println("Error Deleting Product" +e);
        }
    }

    public void allProduct(Connection con)
    {
        String query = "Select * from product_data";
        try {
            Statement st = con.createStatement();
           var result = st.executeQuery(query);

           while (result.next()) {
               int id = result.getInt("id");
               String name = result.getString("name");
               int price = result.getInt("price");
               int quantity = result.getInt("quantity");

               System.out.format("%s, %s, %s, %s\n", id, name, price, quantity);
               System.out.println("");
           }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void searchProduct(Connection con, String name)
    {
        String query = "Select * from product_data where name = '"+name+"'";
        try {
            Statement st = con.createStatement();
            var result = st.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                name = result.getString("name");
                int price = result.getInt("price");
                int quantity = result.getInt("quantity");

                System.out.format("%s, %s, %s, %s\n", id, name, price, quantity);
                System.out.println("");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void createCustomer(Connection con,String name, String age,String cityName){
        String query = "insert into customer_info (name,age,city) values (?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, age);
            st.setString(3, cityName);

            st.execute();
            System.out.println("Added Customer");
            }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

//    deleteCustomer(con,name)
    public  void deleteCustomer(Connection con,String name){
        String query = "delete from customer_info where name = '"+name+"'";

        try
        {
            Statement st = con.createStatement();
            st.execute(query);
            System.out.println("Delete Product");
        }catch (Exception e)
        {
            System.out.println("Error Deleting Product" +e);
        }
    }

//    allCustomers(con)

    public ResultSet allCustomers(Connection con)
    {
        String query = "Select * from customer_info";
        try {
            Statement st = con.createStatement();
            var result = st.executeQuery(query);
//            List<ResultSet>

//            while (result.next()) {
//                int cust_id = result.getInt("cust_id");
//                String name = result.getString("name");
//                int age = result.getInt("age");
//                String city = result.getString("city");
//
//                System.out.format("%s, %s, %s, %s\n", cust_id, name, age, city);
//                System.out.println("");
//
//            }
            return result;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public void  addProductCart(Connection con,String productId,String customerId)
    {
        String query = "insert into cart values (?,?)";
        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,productId);
            pst.setString(2,customerId);

            pst.execute();
            System.out.println("Added product in Cart");
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void  removeProductCart(Connection con,String productId,String customerId)
    {
        String query = "delete form cart where product_Id = ? and cust_id = ?";
        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,productId);
            pst.setString(2,customerId);

            pst.execute();
            System.out.println("Added product in Cart");
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public ResultSet allCartList(Connection con, String customerId)
    {
        String query = "Select * from cart where cust_id = '"+customerId+"'";
        try {
            Statement st = con.createStatement();
            var result = st.executeQuery(query);

            while (result.next()) {
//                int cust_id = result.getInt("cust_id");
                String productId = result.getString("product_id");
//                int age = result.getInt("age");
//                String city = result.getString("city");

                System.out.format("%s\n", productId);
                System.out.println("");

            }
            return result;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
     public void removeAllProductCart(Connection con, String cust_id){
        String query = "delete from cart where cust_id = ?";
        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,cust_id);

            pst.execute();

        }catch (Exception  e){

        }
     }

}
