package yzhao.spring.io.connectsql;

//import java.sql.*;
//
//public class testjdbc {
//    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
//    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/test";
//
//    static final String USER = "root";
//    static final String PASS = "123456";
//
//    public static  void main(String [] args){
//        Connection conn = null;
//        Statement stmt = null;
//
//        try{
//            Class.forName("org.mariadb.jdbc.Driver");
//
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT id,first, last, age FROM Employees";
//
//            ResultSet rs = stmt.executeQuery(sql);
//
//
//            //STEP 5: Extract data from result set
//            while(rs.next()){
//                //Retrieve by column name
//                int id  = rs.getInt("id");
//                int age = rs.getInt("age");
//                String first = rs.getString("first");
//                String last = rs.getString("last");
//
//                //Display values
//                System.out.print("ID: " + id);
//                System.out.print(", Age: " + age);
//                System.out.print(", First: " + first);
//                System.out.println(", Last: " + last);
//            }
//            //STEP 6: Clean-up environment
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            //Handle errors for JDBC
//            se.printStackTrace();
//        }catch(Exception e){
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        }finally{
//            //finally block used to close resources
//            try{
//                if(stmt!=null)
//                    stmt.close();
//            }catch(SQLException se2){
//            }// nothing we can do
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//        System.out.println("There are so thing wrong!");
//    }//end main
//}//end FirstExample

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class testjdbc{
    public static void main(String[] args) throws SQLException{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-sql.xml");

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}