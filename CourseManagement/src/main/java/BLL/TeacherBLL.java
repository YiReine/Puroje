package BLL;

import DAL.Teacher;
import DAL.TeacherDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherBLL {

    TeacherDAL tchDal;

    public TeacherBLL() {
        tchDal = new TeacherDAL();
    }

    public List LoadTeachers(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = tchDal.readTeacher();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }

    public List findTeacher(String fullname) throws SQLException {
        List list = new ArrayList();

        list = tchDal.findTeachers(fullname);

        return list;
    }

    public Teacher getTeacher(int personID) throws SQLException {
        Teacher t = tchDal.getTeacher(personID);
        return t;
    }

    public int addTeacher(Teacher t) throws SQLException {
        int result = tchDal.insertTeacher(t);
        return result;
    }
    
    public int editTeacher(Teacher t) throws SQLException {
        int edit = tchDal.updateTeacher(t);
        return edit;
    }
    
    public int deleteTeacher(int personID) throws SQLException {
        int del = tchDal.deleteTeacher(personID);
        return del;
    }

    public static void main(String[] args) {
        try {
            TeacherBLL tchBll = new TeacherBLL();
            List data = tchBll.LoadTeachers(1);
            Teacher t = (Teacher) data.get(0);
            System.out.println(t.getFirstName());
            System.out.println("Nothing");
        } catch (SQLException e) {
            Logger.getLogger(TeacherBLL.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }
}
