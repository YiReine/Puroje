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

        String query = "SELECT * FROM Person WHERE EnrollmentDate > 0 AND PersonID = ? ";

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

    public int getPersonFromCourseInstructor(int personID) throws SQLException {

        String query = "SELECT PersonID FROM courseinstructor WHERE PersonID = ? ";

        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                Student s = new Student(); //CourseInstructor s = new CourseInstructor(); mới đúng
                s.setPersonId(rs.getInt("PersonID"));
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public int getPersonFromStudentGrade(int personID) throws SQLException {

        String query = "SELECT StudentID FROM studentgrade WHERE StudentID = ?";

        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                Student s = new Student(); //StudentGrade s = new StudentGrade(); mới đúng
                s.setPersonId(rs.getInt("StudentID"));
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public int deleteStudent(int personID) throws SQLException {
        if (getPersonFromCourseInstructor(personID) == 1 || getPersonFromStudentGrade(personID) == 1) {
            return 0;
        } else {
            String query = "DELETE FROM Person WHERE PersonID = ?";
            PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
            p.setInt(1, personID);
            p.executeUpdate();
            return 1;
        }
    }
    public ArrayList<String> readDSID(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT PersonID FROM person WHERE EnrollmentDate>0";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String data = rs.getString("PersonID");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<String[]> readStudentByCourseID(int courseID){
        ArrayList<String[]> list = new ArrayList<>();
        try {
            String query = "SELECT PersonID , LastName , Firstname , Grade FROM `person`, `studentgrade` "
                    + "WHERE PersonID = StudentID and CourseID = '"+courseID+"'";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String PersonID = rs.getString("PersonID");
                    String FullName = rs.getString("Lastname")+" "+rs.getString("Firstname");
                    String grade = rs.getString("Grade");
                    System.out.println(FullName);
                    String[] s = {PersonID,FullName,grade}; 
                    list.add(s);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<String[]> readStudentByCourseTitle(String courseTitle){
         ArrayList<String[]> list = new ArrayList<>();
        try {
            String query = "SELECT PersonID , LastName , Firstname , Grade FROM `person`, `studentgrade` "
                    + "WHERE PersonID = StudentID and CourseID = '"+courseID+"'";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String PersonID = rs.getString("PersonID");
                    String FullName = rs.getString("Lastname")+" "+rs.getString("Firstname");
                    String grade = rs.getString("Grade");
                    System.out.println(FullName);
                    String[] s = {PersonID,FullName,grade}; 
                    list.add(s);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
    }
}
