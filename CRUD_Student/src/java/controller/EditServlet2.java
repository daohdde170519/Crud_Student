/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String genderStr = request.getParameter("gender");
        String dobStr = request.getParameter("dob");

        // Assuming you have a method named update in the StudentDao class
        Student student = new Student();
        student.setId(id);
        student.setName(name);

        student.setGender(genderStr);

        student.setDob(dobStr);

        int status = StudentDAO.update(student);

        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Sorry! Unable to update record");
        }

        out.close();
    }
}

