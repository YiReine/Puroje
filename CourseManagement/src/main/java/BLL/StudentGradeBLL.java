/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.ArrayList;
import DAL.StudentGrade.StudentGrade;
import DAL.Student.StudentDAL;
import DAL.StudentGrade.StudentGradeDAL;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author VIVOBOOK
 */
public class StudentGradeBLL {

    public static ArrayList<StudentGrade> DSSDG;
    private StudentGradeDAL get;

    public StudentGradeBLL() {
        this.get = new StudentGradeDAL();
    }

    public ArrayList<StudentGrade> docDSHD() {
        if (DSSDG == null) {
            StudentGradeDAL get = new StudentGradeDAL();
            DSSDG = get.readStudent();
        }
        return DSSDG;
    }

    public boolean deleteStudentGradeBLL(int EnrollMentID) {
        boolean check = get.deleteStudentgradeDAL(EnrollMentID);
        return check;
    }

    public int insertStudentGradeBLL(String CouID, String StuID, String Grade) {

        if (Grade.equals("")) {
            return -1;
        }
        int courseid = Integer.parseInt(CouID);
        int stdentid = Integer.parseInt(StuID);
        float grade = Float.parseFloat(Grade);
        for (StudentGrade s : DSSDG) {
            if (courseid == s.getCourseID() && stdentid == s.getStudentID()) {
                return -2;
            }
        }
        System.out.println(DSSDG.size());
        int Enrollmentid = get.InsertStudentGradeDAL(stdentid, courseid, grade);
        if (Enrollmentid >= 0) {
            StudentGrade g = new StudentGrade();
            g.setEnrollmentID(Enrollmentid);
            g.setCourseID(courseid);
            g.setStudentID(stdentid);
            g.setGrade(grade);
            DSSDG.add(g);
            System.out.println(DSSDG.size());
            return 1;
        }
        return 0;
    }

    public ArrayList<StudentGrade> getStudentGrade(float grade) {
        ArrayList<StudentGrade> tamp = new ArrayList<>();
        for (StudentGrade s : DSSDG) {
            if (s.getGrade() == grade) {
                tamp.add(s);
            }
        }
        return tamp;
    }

    public int EditStudentGrade(int enrollmentID, String courseid, String studentID, String grade) {
        int courseID2 = Integer.parseInt(courseid);
        int studentID2 = Integer.parseInt(studentID);
        float grade2 = Float.parseFloat(grade);
        for (StudentGrade s : DSSDG) {
            if (courseID2 == s.getCourseID() && studentID2 == s.getStudentID()) {
                return -2;
            }
        }
        boolean check = get.editStudentGradeDAL(enrollmentID, courseID2, studentID2, grade2);
        return 1;
    }

    public List getStudentIDFromStudentGrade(int studentID) throws SQLException {
        List<StudentGrade> tempt;
        tempt = get.getStudentIDFromStudentGrade(studentID);
        return tempt;
    }
}
