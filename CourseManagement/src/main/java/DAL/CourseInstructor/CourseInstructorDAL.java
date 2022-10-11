/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.CourseInstructor;

import DAL.MyDatabaseManager;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CourseInstructorDAL extends MyDatabaseManager{

    public CourseInstructorDAL() {
        super();
        this.connectDB();
    }
    public List readCourseInstructor() throws SQLException {
        String query = "SELECT * FROM course as ce, courseinstructor as c, person as p where c.personID = p.personID and c.courseid = ce.courseid";
        ResultSet rs = CourseInstructorDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        
        if(rs != null) {
            int i = 1;
            while(rs.next()) { 
                CourseInstructor c = new CourseInstructor();
                c.setPersonID(rs.getInt("PersonID"));
                c.setCourseID(rs.getInt("CourseID"));
                list.add(c);
            }
        }
        return list;
    }
    public List findCourseInstructor(String sql) throws SQLException {
        String query = "SELECT * FROM courseinstructor";
        ResultSet rs = CourseInstructorDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        
        if(rs != null) {
            int i = 1;
            while(rs.next()) {
//                CourseInstructor c = new CourseInstructor();
//                c.setPersonID(rs.getInt("PersonID"));
//                c.setCourseID(rs.getInt("CourseID"));
                ArrayList tempList = new ArrayList();
                tempList.add(rs.getInt("PersonID"));
                tempList.add(rs.getInt("CourseID"));
                tempList.add(rs.getString("LastName"));
                tempList.add(rs.getString("Title"));
                list.add(tempList);
            }
        }
        return list;
    }
    
}
