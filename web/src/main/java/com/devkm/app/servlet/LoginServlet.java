package com.devkm.app.servlet;

import com.devkm.app.remote.Login;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @EJB(lookup = "com.devkm.app.ejb.remote.Login")
    Login login;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String user_type = login.login(email, password);
        HttpSession session = request.getSession();
        if (user_type.equals("superAdmin")){
            response.sendRedirect("homePageAdmin.jsp");
            request.login("superadmin","admin1234");
            session.setAttribute("email", email);
        } else if (user_type.equals("admin")) {
            response.sendRedirect("homePageAdmin.jsp");
            request.login("admin","admin1234");
            session.setAttribute("email", email);

        } else if (user_type.equals("user")) {
            response.sendRedirect("homePage.jsp");
            request.login("user","user1234");
            session.setAttribute("email", email);
        }else if (user_type.equals("NONE")){
            System.out.println("not working");
        }

    }
}
