/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL.Course;

import DAL.Course.CourseDAL;
import DAL.Course.Department;
import DAL.Course.DepartmentDAL;
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
    DepartmentDAL dpmdal = new DepartmentDAL();

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

    public int addOnsiteCourse(OnsiteCourse s) throws SQLException {
        this.addCourse(s);
        int id = this.NewCourseBLL();
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
        OnsiteCourse os = osdal.getOs(CourseID);
        return os;
    }

    public List findOnsiteCourse(String condititon) throws SQLException {

        ArrayList<OnsiteCourse> onlclist = osdal.readOnsiteCourse();
        ArrayList<Department> dpmlist = dpmdal.readDepartment();
        ArrayList<OnsiteCourse> onlcsearch = new ArrayList<OnsiteCourse>();
        condititon = condititon.trim().replaceAll("  +", " ").toLowerCase();
        String oldCondition = condititon;
        String[] conditions = condititon.split(" ");
//
        for (int i = 0; i < onlclist.size(); i++) {
            String regex = onlclist.get(i).getTitle() + " " + dpmdal.getDepartmentName(onlclist.get(i).getDepartmentID());
            for (int j = 0; j < conditions.length; j++) {
                String oldChirlCondition = conditions[j];
                conditions[j] = "(.*)" + conditions[j] + "(.*)";
                if (regex.toLowerCase().matches(conditions[j])) {
//                    System.out.println(list.get(i).getPersonID()+" -> ID" + list.get(i).getCourseID());
                    onlcsearch.add(onlclist.get(i));
                    break;
                }
                conditions[j] = oldChirlCondition;
            }

        }
        if (onlcsearch.size() == 0) {
            return onlclist;
        }
//        System.out.println(listSearchs.size());
        return onlcsearch;

    }

    public int deleteOnsiteCourse(int CourseID) throws SQLException {

        int result;

        if (cobll.testConditionError(CourseID) == 0) {
            result = 0;
        } else {
            osdal.deleteOnsiteCourse(CourseID);
            cdal.deleteCourse(CourseID);
            result = 1;
        }
        return result;
    }
}
