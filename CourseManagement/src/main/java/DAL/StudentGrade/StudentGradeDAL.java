/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.StudentGrade;

import DAL.MyDatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author VIVOBOOK
 */
public class StudentGradeDAL extends MyDatabaseManager {

    public StudentGradeDAL() {
        StudentGradeDAL.connectDB();
    }

    public ArrayList readStudent() {
        ArrayList<StudentGrade> list = new ArrayList();
        try {
            String query = "SELECT * FROM studentgrade";
            ResultSet rs = this.doReadQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    StudentGrade s = new StudentGrade();
                    s.setEnrollmentID(rs.getInt("EnrollmentID"));
                    s.setCourseID(rs.getInt("CourseID"));
                    s.setStudentID(rs.getInt("StudentID"));
                    s.setGrade(rs.getFloat("Grade"));
                    list.add(s);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public int InsertStudentGradeDAL(int StuID, int CouID, float grade) {
        try {
            String sql = "INSERT INTO `studentgrade` (`CourseID`, `StudentID`, `Grade`) VALUES (?,?,?)";
            PreparedStatement pstmt = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, CouID);
            pstmt.setInt(2, StuID);
            pstmt.setFloat(3, grade);
            pstmt.executeUpdate();
            int generakey = 0;
            try ( ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generakey = generatedKeys.getInt(1);
                }
            }
            return generakey;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối");
        }
        return -2;
    }

    public boolean deleteStudentgradeDAL(int EnrollMentID) {
        try {
            String query = "DELETE FROM `studentgrade` WHERE `EnrollmentID` = '" + EnrollMentID + "'";
            PreparedStatement stament = this.getConnection().prepareStatement(query);
            stament.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean editStudentGradeDAL(int enrollmentid, int courseid, int studentid, float grade) {
        try {
            String query = "UPDATE `studentgrade` SET `CourseID`=?,`StudentID`=?,`Grade`=? WHERE `EnrollmentID` = '" + enrollmentid + "'";
            PreparedStatement stament = this.getConnection().prepareStatement(query);
            stament.setInt(1, courseid);
            stament.setInt(2, studentid);
            stament.setFloat(3, grade);
            stament.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public List getCourseIDFromStudentGrade(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM studentgrade WHERE CourseID = ?";

        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                StudentGrade s = new StudentGrade();
                s.setCourseID(rs.getInt("CourseID"));
                list.add(s);
            }
        }
        return list;
    }
}
