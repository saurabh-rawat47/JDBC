import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentDAO dao = new StudentDAO();
        Student s2 = new Student();
        s2.rollno = 10;
        s2.name = "Tony";
        dao.connect();
//        dao.addStudent(s2);
        dao.deleteStudent(10);
    }

}

class StudentDAO {
    Connection con = null;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "0000");
    }

    public Student getStudent(int rollno) throws ClassNotFoundException, SQLException {
        String query = "Select name from student where id=" + rollno;
        Student s = new Student();
        s.rollno = rollno;
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "0000");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String name = rs.getString(1);
        s.name = name;
        return s;
    }

    public void addStudent(Student s) throws SQLException {
        String query = "insert into student values(?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, s.rollno);
        pst.setString(2, s.name);
        pst.executeUpdate();
    }

    public void deleteStudent(int id) throws SQLException {
        String query = "delete from student\n" +
                "where id =" + id;
        Statement st = con.createStatement();
        st.executeUpdate(query);
    }
}

class Student {
    int rollno;
    String name;
}
