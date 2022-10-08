package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDAL extends MyDatabaseManager {

    public TeacherDAL() {
        TeacherDAL.connectDB();
    }

    //1 layer
    public void readTeachers() throws SQLException {
        String query = "SELECT * FROM Person WHERE HireDate >0";
        ResultSet rs = TeacherDAL.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            System.out.println("TT \t PersonID \t FirstName \t\t LastName");
            while (rs.next()) {
                System.out.print(i + "\t" + rs.getInt("PersonID"));
                System.out.println("\t\t" + rs.getString("FirstName") + "\t\t\t" + rs.getString("LastName"));
                i++;
            }
        }
    }

    //2 layer
    public ArrayList readTeacher() throws SQLException {
        String query = "SELECT * FROM Person WHERE HireDate >0";
        ResultSet rs = TeacherDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Teacher s = new Teacher();
                s.setPersonID(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                list.add(s);
            }
        }
        return list;
    }

    public Teacher getTeacher(int personID) throws SQLException {

        String query = "SELECT * FROM Person WHERE HireDate > 0 AND PersonID = ? ";

        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        ResultSet rs = p.executeQuery();

        Teacher s = new Teacher();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                s.setPersonID(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setHireDate(Date.valueOf(rs.getString("HireDate").split(" ")[0]));
            }
        }
        return s;
    }

    public int updateTeacher(Teacher s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "
                + " WHERE PersonID = ?";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonID());
        int result = p.executeUpdate();
        return result;
    }

    public int insertTeacher(Teacher s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, HireDate) VALUES (?, ?, ?)";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getHireDate().toString());
        int result = p.executeUpdate();
        return result;
    }

    //1 
    public void findTeacher(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                System.out.print(rs.getInt("PersonID") + " - ");
                System.out.println(rs.getString("Lastname") + " "
                        + rs.getString("Firstname"));
                i++;
            }
        } else {
            System.out.println("Not found");
        }
    }

    //3 layer
    public List findTeachers(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Teacher s = new Teacher();
                s.setPersonID(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                list.add(s);
            }
        }
        return list;
    }

    public int deleteTeacher(int personID) throws SQLException {
        String query = "DELETE FROM Person WHERE PersonID = ?";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();

        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int choice = 1;
        System.out.println("Quan ly thong tin sinh vien:");
        System.out.println("----------------------------");
        //System.out.print("Enter 0: Exits; \t    1: List ; \t 2: Insert ; \t 3: Update  \t 4: Delete \t5. Find: ");
        try {

            TeacherDAL s = new TeacherDAL();

            Teacher st = new Teacher();
            while (choice > 0) {
                System.out.println("0. Exits \n1. List \n2. Insert \n3. Update \n4. Delete \n5. Find ");
                System.out.print("Please choice: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice) {
                    case 1 ->
                        s.readTeachers();
                    case 2 -> {
                        System.out.print("Firstname: ");
                        String firstName = in.nextLine();
                        System.out.print("Lastname: ");
                        String lastName = in.nextLine();
                        st.setLastName(lastName);
                        st.setFirstName(firstName);
                        long millis = System.currentTimeMillis();
                        java.sql.Date date = new java.sql.Date(millis);
                        st.setHireDate(date);
                        if (s.insertTeacher(st) != 0) {
                            System.out.println("Complete insert ");
                        } else {
                            System.out.println("Nothing insert ");
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter PersonID to Update: ");
                        int personID = Integer.parseInt(in.nextLine());
                        st.setPersonID(personID);
                        System.out.println("Firstname: ");
                        String firstName2 = in.nextLine();
                        System.out.println("Lastname: ");
                        String lastName2 = in.nextLine();
                        st.setLastName(lastName2);
                        st.setFirstName(firstName2);
                        if (s.updateTeacher(st) != 0) {
                            System.out.println("Complete update");
                        } else {
                            System.out.println("Complete update");
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter PersonID to delete: ");
                        int personID = Integer.parseInt(in.nextLine());
                        if (s.deleteTeacher(personID) != 0) {
                            System.out.println("Complete delete");
                        } else {
                            System.out.println("Nothing delete");

                        }
                    }
                    case 5 -> {
                        System.out.print("Enter fullname to search: ");

                        String fullName = in.nextLine();
                        s.findTeacher(fullName);
                    }
                    default ->
                        System.out.println("Enter number not match");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
