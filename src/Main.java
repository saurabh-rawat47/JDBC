import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/aliens";
        String uname = "root";
        String password = "0000";
//        String query = "Select * from student";
        String query1 = "insert into student(id,name)" +
                "values" +
                "(6,'bob')";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(query);
        int count = st.executeUpdate(query1);
        System.out.println(count + "rows affect");
//        while (rs.next()) {
//            String name = rs.getInt(1) + ":" + rs.getString(2);
//            System.out.println(name);
//        }
        st.close();
        con.close();
    }
}
