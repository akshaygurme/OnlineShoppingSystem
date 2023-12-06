package OnlineShoppingSystem;

import javax.xml.stream.StreamFilter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
}
