package DAL.Student;

import DAL.MyDatabaseManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAL extends MyDatabaseManager {

    public StudentDAL() {
        StudentDAL.connectDB();
    }

    //2 layer
    public ArrayList readStudent() throws SQLException {
        String query = "SELECT * FROM Person WHERE EnrollmentDate >0";
        ResultSet rs = StudentDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Student s = new Student();
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEnrollmentDate(Date.valueOf(rs.getString("EnrollmentDate").split(" ")[0]));
                list.add(s);
            }
        }
        return list;
    }

    public Student getStudent(int personID) throws SQLException {

        String query = "SELECT * FROM Person WHERE EnrollmentDate >0 AND PersonID = ? ";

        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        ResultSet rs = p.executeQuery();

        Student s = new Student();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {

                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEnrollmentDate(Date.valueOf(rs.getString("EnrollmentDate").split(" ")[0]));
            }
        }
        return s;
    }

    public int updateStudent(Student s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "
                + " WHERE PersonID = ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonId());
        int result = p.executeUpdate();
        return result;
    }

    public int insertStudent(Student s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, EnrollmentDate) VALUES (?, ?, ?)";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getEnrollmentDate().toString());
        int result = p.executeUpdate();
        return result;
    }

    //1 
    public void findStudent(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                System.out.print(rs.getInt("PersonID") + " - ");
                System.out.println(rs.getString("Lastname") + " "
                        + rs.getString("Firstname"));
                i++;
            }
        } else {
            System.out.println("Not found");
        }
    }

    //3 layer
    public List findStudents(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Student s = new Student();
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                list.add(s);
            }
        }
        return list;
    }

    public int deleteStudent(int personID) throws SQLException {
        String query = "DELETE FROM Person WHERE PersonID = ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();

        return result;
    }

    public static void main(String[] args) {
    }
}
