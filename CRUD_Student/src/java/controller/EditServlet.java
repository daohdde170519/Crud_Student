/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.StudentDAO;

/**
 *
 * @author DAO
 */
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Update Student</h1>");
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);

            Student student = StudentDAO.getStudentById(id);
            request.setAttribute("student", student);
            request.getRequestDispatcher("update.jsp").forward(request, response);
//            out.print("<form action='EditServlet2' method='post'>");
//            out.print("<table>");
//            out.print("<tr><td></td><td><input type='hidden' name='id' value='" + student.getId() + "'/></td></tr>");
//            out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + student.getName() + "'/></td></tr>");
//            out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='" + student.getGender() + "'/></td></tr>");
//            out.print("<tr><td>Date of Birth:</td><td><input type='text' name='dob' value='" + student.getDob() + "'/></td></tr>");
//            out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
//            out.print("</table>");
//            out.print("</form>");
        }
    }
}
