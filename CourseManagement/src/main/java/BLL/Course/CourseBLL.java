/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL.Course;

import DAL.Course.Course;
import DAL.Course.CourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class CourseBLL {

    CourseDAL cdal;

    public CourseBLL() {
        cdal = new CourseDAL();
    }

    public int addCourse(Course s) throws SQLException {
        int result = cdal.insertCourse(s);
        return result;
    }

    public int editCourse(Course s) throws SQLException {
        int result = cdal.updateCourse(s);
        return result;
    }

    public int NewCourseBLL() throws SQLException {
        int id = cdal.NewCourseID();
        return id;
    }

    public int deleteCourse(int CourseID) throws SQLException {
        int result = cdal.deleteCourse(CourseID);
        return result;
    }

    public List getCourseIDFromCourse(int courseID) throws SQLException {
        List<Course> listTemp;
        listTemp = cdal.getCourseIDFromCourse(courseID);
        return listTemp;
    }

    public List LoadCourses(int page) throws SQLException {
        ArrayList list = cdal.readCourse();
        return list;
    }
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
        public ArrayList<String[]> readCourseByStudentIdBLL(String StudentID){
        int studentID = Integer.parseInt(StudentID);
        CourseDAL std = new CourseDAL();
        ArrayList<String[]> list = std.readCourseByStudentId(studentID);
        return list;
    }
     public ArrayList<String> readCourseTitleBLL(){
        CourseDAL std = new CourseDAL();
        ArrayList<String> list = std.readCourseTitle();
        return list;
    }
}
