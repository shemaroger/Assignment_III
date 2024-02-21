package com.shema.jsp_assignment_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/SignUp_Servlet")
public class SignUp_Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

     String email = request.getParameter("email");
     String password = request.getParameter("password");

     if(email != null && !email.isEmpty() && password != null && !password.isEmpty() ){
         HttpSession session = request.getSession();
         session.setAttribute("email", email);
         session.setAttribute("password", password);
         response.sendRedirect("signin.jsp");
     }else{
         response.sendRedirect("signup.jsp");
     }
    }
}
