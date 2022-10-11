/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Course;

import DAL.MyDatabaseManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class CourseDAL extends MyDatabaseManager{
    public CourseDAL() {

    }
    public int insertCourse(Course s) throws SQLException {
        String query = "Insert course (Credits, DepartmentID, Title) VALUES (?, ?, ?)";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, s.getCredits());
        p.setInt(2, s.getDepartmentID());
        p.setString(3, s.getTitle());
        int result = p.executeUpdate();
        return result;
    }
    public int NewCourseID() {
        int id=0;
        String query="SELECT CourseID FROM course  ORDER BY CourseID DESC  LIMIT 1;";
        ResultSet rs = CourseDAL.doReadQuery(query);
        try {
            while(rs.next()){
                id= rs.getInt("CourseID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
   }
    public int updateCourse(Course s) throws SQLException {
        String query = "Update course SET Credits = ? , DepartmentID = ? , Title = ? "
                + " WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1,s.getCredits());
        p.setInt(2, s.getDepartmentID());
        p.setString(3, s.getTitle());
        p.setInt(4, s.getCourseID());
        int result = p.executeUpdate();
        return result;
    }
    public int deleteCourse(int CourseID) throws SQLException {
        if (getCourseIDFromOnsiteCourse(CourseID) == 1 
                || getCourseIDFromCourseInstructor(CourseID) == 1 
                || getCourseIDFromOnlineCourse(CourseID) == 1 
                || getCourseIDFromStudentGrade(CourseID) == 1) {
            return 0;
        } else {
            String query = "DELETE FROM course WHERE CourseID = ?";
            PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
            p.setInt(1, CourseID);
            p.executeUpdate();
            return 1;
        }
    }
    public int getCourseIDFromOnsiteCourse(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM onsitecourse WHERE CourseID = ?";

        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                OnsiteCourse s = new OnsiteCourse();
                s.setCourseID(rs.getInt("CourseID"));
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public int getCourseIDFromCourseInstructor(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM courseinstructor WHERE CourseID = ?";

        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                OnsiteCourse s = new OnsiteCourse();
                s.setCourseID(rs.getInt("CourseID"));
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public int getCourseIDFromStudentGrade(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM studentgrade WHERE CourseID = ?";

        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                OnsiteCourse s = new OnsiteCourse();
                s.setCourseID(rs.getInt("CourseID"));
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public int getCourseIDFromOnlineCourse(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM onlinecourse WHERE CourseID = ?";

        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                OnsiteCourse s = new OnsiteCourse();
                s.setCourseID(rs.getInt("CourseID"));
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        return 1;
    }
       
}
