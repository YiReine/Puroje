package BLL;

import DAL.Student.Student;
import DAL.Student.StudentDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBLL {

    StudentDAL stdDal;

    public StudentBLL() {
        stdDal = new StudentDAL();
    }

    public List LoadStudents() throws SQLException {
        ArrayList list = stdDal.readStudent();
        return list;
    }

    public List findStudent(String fullname) throws SQLException {
        List list = new ArrayList();

        list = stdDal.findStudents(fullname);

        return list;
    }

    public Student getStudent(int personID) throws SQLException {
        Student s = stdDal.getStudent(personID);
        return s; 
    }

    public int addStudent(Student s) throws SQLException {
        int result = stdDal.insertStudent(s);
        return result;
    }

    public int updateStudent(Student s) throws SQLException {
        int result = stdDal.updateStudent(s);
        return result;
    }

    public int deleteStudent(int personID) throws SQLException {
        int result = stdDal.deleteStudent(personID);
        return result;
    }

    public static void main(String[] args) {
    }
}
