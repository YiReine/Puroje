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
            PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
            p.setInt(1, CourseID);
            p.executeUpdate();
            return 1;
        }
    }
    public int getCourseIDFromOnsiteCourse(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM onsitecourse WHERE CourseID = ?";

        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
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

        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
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

    public int getCourseIDFromStudentGrade(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM studentgrade WHERE CourseID = ?";

        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
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

    public int getCourseIDFromOnlineCourse(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM onlinecourse WHERE CourseID = ?";

        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
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
    
    //=============================================================================
     public ArrayList<String> readDSID(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT CourseID FROM course";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String data = rs.getString("CourseID");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
     
    public ArrayList<String[]> readCourseByStudentId(int StudentID){
        ArrayList<String[]> list = new ArrayList<>();
        try {
           String queryOnline = "SELECT onlinecourse.CourseID , Title , Grade FROM `course`,`studentgrade`,`onlinecourse` "
                    + "WHERE course.CourseID = onlinecourse.CourseID and studentgrade.CourseID = onlinecourse.CourseID and StudentID = '"+StudentID+"'";
            String queryOnsite = "SELECT onsitecourse.CourseID , Title , Grade FROM `course`,`studentgrade`,`onsitecourse` "
                    + "WHERE course.CourseID = onsitecourse.CourseID and studentgrade.CourseID = onsitecourse.CourseID and StudentID = '"+StudentID+"'"; 
           ResultSet rs = this.doReadQuery(queryOnline);
           
           if(rs !=null){
                while(rs.next()){
                    String CourseID = rs.getString("CourseID");
                    String Title = rs.getString("Title");
                    String Type = "On";
                    String Grade = rs.getString("Grade");
                    String[] s = {CourseID,Title,Type,Grade};
                    list.add(s);
                }
            }
           ResultSet rs2 = this.doReadQuery(queryOnsite);
           if(rs2 !=null){
                while(rs2.next()){
                    String CourseID = rs2.getString("CourseID");
                    String Title = rs2.getString("Title");
                    String Type = "Off";
                    String Grade = rs2.getString("Grade");
                    String[] s = {CourseID,Title,Type,Grade};
                    list.add(s);
                }
            }
        
        } catch (Exception e) {
        }
        return list;
    }
}