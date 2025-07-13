import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentDAO dao = new StudentDAO();
        Student s1 = dao.getStudent(8);
        System.out.println(s1.name);
    }

}

class StudentDAO {
    public Student getStudent(int rollno) throws ClassNotFoundException, SQLException {
        String query = "Select name from student where id=" + rollno;
        Student s = new Student();
        s.rollno = rollno;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "0000");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String name = rs.getString(1);
        s.name = name;
        return s;
    }

}

class Student {
    int rollno;
    String name;
}
