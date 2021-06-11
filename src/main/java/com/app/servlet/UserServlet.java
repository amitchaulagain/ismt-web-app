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
 * List of users  ---> /users      ---->   /users     GET
 * Get by id      ---> /user?id=2&name=ram   ---->  /user?id=   GET
 * create         ---> /user  ---->/user?country=us        POST
 * update         ---> /user            ----> /user        PUT
 * delete         ---> /user  ----> /user?id=   DELETE
 *
 *
 * */
@WebServlet(urlPatterns = {"/users", "/createUser", "/editUser", "/user"})
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    UserRepo repo = new UserRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        System.out.println(request.getServletPath());

        if (request.getServletPath().equals("/users")) {
            List<User> users = repo.listUsers();
            request.setAttribute("company", "Apple Inc");
            request.setAttribute("userList", users);
            RequestDispatcher view = request.getRequestDispatcher("views/list-user.jsp");
            view.forward(request, response);

        } else if (request.getServletPath().equals("/createUser")) {
            RequestDispatcher view = request.getRequestDispatcher("views/create-user.jsp");
            view.forward(request, response);

        } else if (request.getServletPath().equals("/editUser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = repo.getById(id);

            request.setAttribute("user", user);

            RequestDispatcher view = request.getRequestDispatcher("views/edit-user.jsp");
            view.forward(request, response);

        } else if (request.getServletPath().equals("/user")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = repo.getById(id);
            request.setAttribute("user", user);
            RequestDispatcher view = request.getRequestDispatcher("views/get-user.jsp");
            view.forward(request, response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().equals("/user")) {

            User user = getUserData(request);

            try {
                repo.insert(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/users");

        }


    }

    private User getUserData(HttpServletRequest request) {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setCountry(request.getParameter("country"));
        String gender = request.getParameter("gender");
        if (gender.equals("male")) {
            user.setMale(true);
        } else {
            user.setMale(false);

        }

        String allCourses[] = request.getParameterValues("courses");

        String csvValues = String.join(",", allCourses);

        user.setAllCourse(csvValues);


        System.out.println(allCourses);


        return user;
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/user")) {
            int id = Integer.parseInt(request.getParameter("id"));
            repo.delete(id);
            response.sendRedirect("/users");

        }


    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().equals("/user")) {

            User user = getUserData(request);

            repo.edit(user);
            response.sendRedirect("/users");

        }
    }

}
