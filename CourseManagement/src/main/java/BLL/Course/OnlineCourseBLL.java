/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL.Course;

import DAL.Course.CourseDAL;
import DAL.Course.Department;
import DAL.Course.DepartmentDAL;
import DAL.Course.OnlineCourse;
import DAL.Course.OnlineCourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class OnlineCourseBLL extends CourseBLL {

    OnlineCourseDAL oldal;
    CourseBLL cobll;
    CourseDAL cdal;
    DepartmentDAL dpmdal = new DepartmentDAL();

    public OnlineCourseBLL() {
        oldal = new OnlineCourseDAL();
        cobll = new CourseBLL();
        cdal = new CourseDAL();
        //    OnsiteCourseDAL.closeConnect();

    }

    public List LoadOnlineCourse(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = oldal.readOnlineCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }

    public List findOnlineCourse(String condititon) throws SQLException {

        ArrayList<OnlineCourse> onlclist = oldal.readOnlineCourse();
        ArrayList<Department> dpmlist = dpmdal.readDepartment();
        ArrayList<OnlineCourse> onlcsearch = new ArrayList<OnlineCourse>();
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

    public int addOnlineCourse(OnlineCourse s) throws SQLException {
        this.addCourse(s);
        int id = this.NewCourseBLL();
        s.setCourseID(id);
        int result = oldal.insertOnlineCourse(s);
        return result;
    }

    public int editOnlineCourse(OnlineCourse s) throws SQLException {
        this.editCourse(s);
        int result = oldal.updateOnlineCourse(s);
        return result;
    }

    public OnlineCourse getOs(int CourseID) throws SQLException {
        OnlineCourse os = oldal.getOs(CourseID);
        return os;
    }

    public int deleteOnlineCourse(int CourseID) throws SQLException {

        int result;

        if (cobll.testConditionError(CourseID) == 0) {
            result = 0;
        } else {
            oldal.deleteOnlineCourse(CourseID);
            cdal.deleteCourse(CourseID);
            result = 1;
        }
        return result;
    }
}
