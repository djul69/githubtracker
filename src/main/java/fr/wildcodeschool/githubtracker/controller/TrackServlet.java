package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TrackServlet", urlPatterns="/track")
public class TrackServlet extends HttpServlet {

    //@Inject  GithuberDAO githuberDAO; plus nécessaire depuis le qualifier InMemory
    @Inject
    GithubersService githubersSevice;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login= request.getParameter("login");

        try {
            githubersSevice.track(login); //TODO ajouter la gestion des login inexistants
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("githubers");
    }

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
}

