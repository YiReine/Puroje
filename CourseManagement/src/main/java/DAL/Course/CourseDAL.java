/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Course;

import DAL.MyDatabaseManager;
import static java.awt.Event.INSERT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class CourseDAL extends MyDatabaseManager{
    public CourseDAL(){
        CourseDAL.connectDB();
    }
    public boolean addCourse(int CourseID, String Title, int Credits, int DepartmentID, String url ){
        try {
            String query = "INSERT INTO `course`(`CourseID`, `Title`, `Credits`, `DepartmentID`) VALUES (?,?,?,?)";
            PreparedStatement pstmt =this.getConnection().prepareStatement(query);
            pstmt.setInt(1, CourseID);
            pstmt.setString(2, Title);
            pstmt.setInt(3,Credits);
            pstmt.setInt(4, DepartmentID);
            
            System.out.println();
            if(pstmt.executeUpdate()==1){
                query = "INSERT INTO `onlinecourse`(`CourseID`, `url`) VALUES (?,?)";
                PreparedStatement pstmt2 =this.getConnection().prepareStatement(query);
                pstmt2.setInt(1, CourseID);
                pstmt2.setString(2, url);
                pstmt2.executeUpdate();
            }
            return true;
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        return false;
    }
    public boolean editCourse(int CourseID, String Title, int Credits, int DepartmentID, String url ){
        try {
            String query = "UPDATE `course` SET `Title`=?,`Credits`=?,`DepartmentID`=? WHERE CourseID ='"+CourseID+"'";
            PreparedStatement pstmt =this.getConnection().prepareStatement(query);
            pstmt.setString(1, Title);
            pstmt.setInt(2,Credits);
            pstmt.setInt(3, DepartmentID);
            
            System.out.println();
            if(pstmt.executeUpdate()==1){
                query = "UPDATE `onlinecourse` SET `url`=? WHERE CourseID ='"+CourseID+"'";
                PreparedStatement pstmt2 =this.getConnection().prepareStatement(query);
                pstmt2.setString(1, url);
                pstmt2.executeUpdate();
            }
            return true;
            
        } catch (Exception e) {
            System.out.println("Error");
        }
        return false;
    }
    
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
