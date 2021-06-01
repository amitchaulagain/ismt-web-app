package com.javacreed.examples.maven;

import com.app.dao.StudentDao;
import com.app.dao.StudentDaoImpl;
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

@WebServlet(urlPatterns = {"/user", "/createUser"})
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentDao dao = new StudentDaoImpl();


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

            RequestDispatcher view = request.getRequestDispatcher("views/add_user.jsp");
            view.forward(request, response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().equals("/user")) {
            Integer id = Integer.valueOf(request.getParameter("id"));

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String country = request.getParameter("country");

            User user = new User(id, name, email, password, country);

            try {
                repo.insert(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            RequestDispatcher view = request.getRequestDispatcher("views/user.jsp");
            view.forward(request, response);

        }


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
    }


}
