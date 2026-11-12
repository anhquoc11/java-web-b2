package com.example.studentapp.controller;

import com.example.studentapp.entity.Survey;
import com.example.studentapp.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        System.out.println("EmailListServlet action: " + action);
        log("EmailListServlet action: " + action);

        if (action.equals("join")) {
            url = "/index.jsp";
        } else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String heardFrom = request.getParameter("heardFrom");
            String wantsUpdates = request.getParameter("wantsUpdates");
            String emailOffers = request.getParameter("emailOffers");
            String contactVia = request.getParameter("contactVia");

            if (wantsUpdates == null) {
                wantsUpdates = "No";
            } else {
                wantsUpdates = "Yes";
            }

            if (emailOffers == null) {
                emailOffers = "No";
            } else {
                emailOffers = "Yes";
            }

            User user = new User(firstName, lastName, email, dob);
            Survey survey = new Survey(heardFrom, wantsUpdates, emailOffers, contactVia);

            String message;
            if (firstName == null || lastName == null || email == null ||
                    firstName.trim().isEmpty() || lastName.trim().isEmpty() || email.trim().isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            } else {
                message = "";
                url = "/thanks.jsp";
            }

            request.setAttribute("user", user);
            request.setAttribute("survey", survey);
            request.setAttribute("message", message);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}