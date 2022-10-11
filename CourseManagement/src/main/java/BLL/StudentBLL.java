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

    public List LoadStudents(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = stdDal.readStudent();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
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
    
    public ArrayList<String> readDSID(){
        StudentDAL std = new StudentDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }
    
    public ArrayList<String[]> readStudentByCourseIdBll(int courseID){
        StudentDAL std = new StudentDAL();
        ArrayList<String[]> list = std.readStudentByCourseID(courseID);
        return list;
    }
    
    public static void main(String[] args) {
    }
}
