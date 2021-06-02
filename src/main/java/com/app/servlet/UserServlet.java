package com.app.servlet;

import com.app.model.User;
import com.app.repository.UserRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/*
* Update User
*
* Get User By Id
*
*
* */
@WebServlet(urlPatterns = {"/user", "/createUser","/deleteUser"})
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    UserRepo repo = new UserRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        System.out.println(request.getServletPath());

        if (request.getServletPath().equals("/user")) {
            List<User> users = repo.listUsers();
            request.setAttribute("users", users);
            RequestDispatcher view = request.getRequestDispatcher("views/user.jsp");
            view.forward(request, response);

        } else if (request.getServletPath().equals("/createUser")) {
            RequestDispatcher view = request.getRequestDispatcher("views/create-user.jsp");
            view.forward(request, response);

        } else if (request.getServletPath().equals("/deleteUser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            repo.delete(id);
            response.sendRedirect("/user");

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Student student = new Student();
//        student.setFirstName(request.getParameter("firstName"));
//        student.setLastName(request.getParameter("lastName"));
//        student.setCourse(request.getParameter("course"));
//        student.setYear(Integer.parseInt(request.getParameter("year")));
//        String studentId = request.getParameter("studentId");
//
//        if (studentId == null || studentId.isEmpty())
//            dao.addStudent(student);
//        else {
//            student.setStudentId(Integer.parseInt(studentId));
//            dao.updateStudent(student);
//        }
//        RequestDispatcher view = request.getRequestDispatcher(lIST_STUDENT);
//        request.setAttribute("students", dao.getAllStudents());
//        view.forward(request, response);

        if (request.getServletPath().equals("/createUser")) {

            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setCountry(request.getParameter("country"));

            try {
                repo.insert(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            RequestDispatcher view = request.getRequestDispatcher("/user");
//            view.forward(request, response);
            response.sendRedirect("/user");

        }


    }


}
