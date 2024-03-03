/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
/**
 *
 * @author DAO
 */
public class StudentDAO {
     public static int addStudent(Student s){
        int id=-1;
        try(Connection con=DBConnection.getConnection()) {
            PreparedStatement stmt=con.prepareStatement("Insert into Student(name, gender,dob) output inserted.id values(?,?,?)");
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getGender().substring(0,1));
            stmt.setDate(3, s.getDateOB());
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public static int update(Student student) {
        int status = 0;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE Student SET name=?, gender=?, dob=? WHERE id=?");
            ps.setString(1, student.getName());
            ps.setString(2, student.getGender().substring(0,1));
            ps.setDate(3, student.getDateOB());
            ps.setInt(4, student.getId());

            status = ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Student WHERE id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return status;
    }
    public static Student getStudentById(int id) {
        Student student = new Student();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Student WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
            // Convert java.sql.Date to String in "dd/MM/yyyy" format
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = sdf.format(rs.getDate("dob"));
            
            student.setDob(formattedDate);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
public static List<Student> getAllStudents() {
    List<Student> list = new ArrayList<>();
    try (Connection con = DBConnection.getConnection()) {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Student");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            
            // Format the date using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = sdf.format(rs.getDate("dob"));
            
            student.setDob(formattedDate);
            list.add(student);
        }
    } catch (Exception e) {
        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, e);
    }
    return list;
}

    public static List<Student> getAllStudentsByPage(int currentPage, int recordsPerPage) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> studentList = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            int offset = (currentPage - 1) * recordsPerPage;
            pstmt = conn.prepareStatement("SELECT * FROM Student ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;");
            pstmt.setInt(1, offset);
            pstmt.setInt(2, recordsPerPage);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                // Format the date using SimpleDateFormat
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = sdf.format(rs.getDate("dob"));

                student.setDob(formattedDate);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return studentList;
    }
    public static int getTotalRecords() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int totalRecords = 0;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT COUNT(*) FROM Student");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                totalRecords = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return totalRecords;
    }

}
