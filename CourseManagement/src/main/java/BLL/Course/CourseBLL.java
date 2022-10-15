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
}
