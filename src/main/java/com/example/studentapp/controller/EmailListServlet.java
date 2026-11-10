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

        String url = "/index.html";

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("join")) {
            url = "/index.html";
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

            request.setAttribute("user", user);
            request.setAttribute("survey", survey);
            url = "/thanks.jsp";
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