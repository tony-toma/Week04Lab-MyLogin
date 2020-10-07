/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message;
        HttpSession session = request.getSession();
        
        if(username == null || password == null || password.isEmpty() || username.isEmpty()) {
           message = "Please fill in both password and username fields";
           request.setAttribute("message", message);
           request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           return;
        }
       
        
        // Since the username and passwords aren't empty or null
        // Attempt to login into an account
        AccountService accountService = new AccountService();
        User user = accountService.login(username, password);
        
        if(user == null) {
            message = "Invalid Login Credentials";
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        else { 
            session.setAttribute("user", user);
            response.sendRedirect("home");
            return;
        }
        
        
    }

}
