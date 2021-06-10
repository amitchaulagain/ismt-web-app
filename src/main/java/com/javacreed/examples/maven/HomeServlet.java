package com.javacreed.examples.maven;

import com.app.dao.StudentDao;
import com.app.dao.StudentDaoImpl;
import com.app.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String lIST_STUDENT = "/listStudents.jsp";
    public static final String INSERT_OR_EDIT = "/student.jsp";
    private StudentDao dao = new StudentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setCourse(request.getParameter("course"));
        student.setYear(Integer.parseInt(request.getParameter("year")));
        String studentId = request.getParameter("studentId");

        if (studentId == null || studentId.isEmpty())
            dao.addStudent(student);
        else {
            student.setStudentId(Integer.parseInt(studentId));
            dao.updateStudent(student);
        }
        RequestDispatcher view = request.getRequestDispatcher(lIST_STUDENT);
        request.setAttribute("students", dao.getAllStudents());
        view.forward(request, response);
    }


}
