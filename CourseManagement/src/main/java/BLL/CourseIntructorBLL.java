/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.ArrayList;
import DAL.CourseInstructor.CourseInstructorDAL;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author HP
 */
public class CourseIntructorBLL {

   private CourseInstructorDAL cid = new CourseInstructorDAL();
    public List loadCourseInstructor() throws SQLException {
        List list = cid.readCourseInstructor();
        return list;
    }
    public List findCourseInstructor(String condition) throws SQLException {
        List list = cid.readCourseInstructor();
        return list;
    }
}
