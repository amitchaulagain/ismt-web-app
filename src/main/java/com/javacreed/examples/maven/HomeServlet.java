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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String lIST_STUDENT = "/listStudents.jsp";
    public static final String INSERT_OR_EDIT = "/student.jsp";
    private StudentDao dao = new StudentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



       /* request.setAttribute("test","We are testing");
        request.setAttribute("apple",1000);
        request.setAttribute("ball",2.66667);*/


        String firstName=request.getParameter("first_name");
        String lastName=request.getParameter("last_name");





        List<Student> students = new ArrayList<>();

        Student student1= new Student();
        student1.setStudentId(1);
        student1.setFirstName("Ram");
        student1.setLastName("Kumar");
        student1.setCourse("bsc csit");
        student1.setYear(2021);
        students.add(student1);

        students.add(new Student(2,"Sam","Bdr","bsc",2022));
        students.add(new Student(3,"Hari","Bdr","bsc",2012));


        request.setAttribute("studentsList",students);


        RequestDispatcher view = request.getRequestDispatcher("views/home.jsp");
        view.forward(request, response);
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
