import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/aliens";
        String uname = "root";
        String password = "0000";
        int userid = 8;
        String username = "Rani";
        String query = "insert into student values(?,?)";


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, userid);
        st.setString(2, username);
        int count = st.executeUpdate();
        System.out.println(count + "rows/s affect");
        st.close();
        con.close();
    }
}
