package com.shema.jsp_assignment_1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Properties;

@WebServlet("/AdmisionServlet")
public class AdmisionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get other form parameters
        String fullName = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String bd = request.getParameter("bd");
        String course = request.getParameter("course");
        String passportPicture = request.getParameter("passportPicture");
        String otherDocument = request.getParameter("otherDocument");

        request.setAttribute("name",fullName);
        JavaMailServlet emailServlet = new JavaMailServlet();
        emailServlet.javaMail(email);
        getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request,response);
    }


}

