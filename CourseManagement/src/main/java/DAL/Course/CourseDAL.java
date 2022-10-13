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

/**
 *
 * @author chris
 */
public class CourseDAL extends MyDatabaseManager {

    public CourseDAL() {

    }

    public ArrayList<Course> readCourse() throws SQLException {
        String query = "SELECT * FROM course ";
        ResultSet rs = CourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                Course c = new Course();
                c.setCourseID(rs.getInt("CourseID"));
                c.setCredits(rs.getInt("Credits"));
                c.setDepartmentID(rs.getInt("DepartmentID"));
                c.setTitle(rs.getString("Title"));
                list.add(c);
            }
        }
        return list;
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
        int id = 0;
        String query = "SELECT CourseID FROM course  ORDER BY CourseID DESC  LIMIT 1;";
        ResultSet rs = CourseDAL.doReadQuery(query);
        try {
            while (rs.next()) {
                id = rs.getInt("CourseID");
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
        p.setInt(1, s.getCredits());
        p.setInt(2, s.getDepartmentID());
        p.setString(3, s.getTitle());
        p.setInt(4, s.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public int deleteCourse(int CourseID) throws SQLException {
        String query = "DELETE FROM course WHERE CourseID = ?";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, CourseID);
        int result = p.executeUpdate();
        return result;
    }

    public int getCourseIDFromCourse(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM course WHERE CourseID = ?";

        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                Course s = new Course();
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
}
