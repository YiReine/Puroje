/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL.Course;

import DAL.Course.CourseDAL;
import DAL.Course.OnsiteCourse;
import DAL.Course.OnsiteCourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class OnsiteCourseBLL extends CourseBLL {
    OnsiteCourseDAL osdal;
    CourseBLL cobll;
    CourseDAL cdal;

    public OnsiteCourseBLL() {
        osdal = new OnsiteCourseDAL();
        cobll = new CourseBLL();
        cdal = new CourseDAL();
        //    OnsiteCourseDAL.closeConnect();

    }
    public List LoadOnsiteCourse(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = osdal.readOnsiteCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }

    public List findOnsiteCourse(String value) throws SQLException {
        List list = new ArrayList();
        list = osdal.findOnsiteCourse(value);
        return list;

    }
    public int addOnsiteCourse(OnsiteCourse s) throws SQLException {
        this.addCourse(s);
        int id= this.NewCourseBLL();
        s.setCourseID(id);
        int result = osdal.insertOnsiteCourse(s);
        return result;
    }
    public int editOnsiteCourse(OnsiteCourse s) throws SQLException {
        this.editCourse(s);
        int result = osdal.updateOnsiteCourse(s);
        return result;
    }
    public OnsiteCourse getOs(int CourseID) throws SQLException {
        OnsiteCourse os= osdal.getOs(CourseID);
        return os;
    }
    public int deleteOnsiteCourse(int CourseID) throws SQLException {
        
        int result;        
        osdal.deleteOnsiteCourse(CourseID);
        if (cobll.deleteCourse(CourseID) == 0) {
            result = 0;
        } else {
            cdal.deleteCourse(CourseID);
            result = 1;
        }
        return result;
    }
    

}

