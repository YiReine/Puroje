package BLL;

import DAL.Course.CourseDAL;
import DAL.Course.CourseDAL;
import DAL.MyDatabaseManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class CourseBLL {
    private CourseDAL get;
    public CourseBLL(){
       this.get = new CourseDAL();
    }
    public boolean addCourse(int CourseID, String Title, int Credits, int DepartmentID, String url ){
        boolean check = get.addCourse(CourseID, Title, Credits, DepartmentID, url);
        return check;
    }
    public boolean editCourse(int CourseID, String Title, int Credits, int DepartmentID, String url){
        boolean check = get.editCourse(CourseID, Title, Credits, DepartmentID, url);
        return check;
    }
    
    //=============================================================================
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