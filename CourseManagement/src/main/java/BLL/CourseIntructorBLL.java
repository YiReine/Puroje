package BLL;

import java.util.ArrayList;
import DAL.CourseInstructor.CourseInstructorDAL;
import java.sql.SQLException;
import java.util.List;

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
