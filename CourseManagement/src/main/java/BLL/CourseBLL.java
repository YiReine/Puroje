package BLL;

import DAL.Course.Course;
import DAL.Course.CourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class CourseBLL {
    CourseDAL cdal;
    public CourseBLL(){
      cdal = new CourseDAL();  
    }
//     public int addCourse(Course s) throws SQLException {
//       int result = cdal.insertCourse(s);
//        return result;
//    }
//      public int editCourse(Course s) throws SQLException {
//       int result = cdal.updateCourse(s);
//        return result;
//    }
//     public int NewCourseBLL() throws SQLException {
//       int id=cdal.NewCourseID();
//       return id;
//    }
//    public int deleteCourse(int CourseID) throws SQLException {
//        int result = cdal.deleteCourse(CourseID);
//        return result;
//    }
    
    //=============================================================================
   public List LoadCourses(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list =  cdal.readCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }
   /////
    public ArrayList<String> readDSID(){
        CourseDAL std = new CourseDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }
    public ArrayList<String[]> readCourseByStudentIdBLL(int StudentID){
        CourseDAL std = new CourseDAL();
        ArrayList<String[]> list = std.readCourseByStudentId(StudentID);
        return list;
    }
}