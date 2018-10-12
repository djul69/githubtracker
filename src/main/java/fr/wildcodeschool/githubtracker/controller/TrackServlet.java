package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TrackServlet", urlPatterns="/track")
public class TrackServlet extends HttpServlet {
    //@Inject  GithuberDAO githuberDAO; plus nécessaire depuis le qualifier InMemory
    @Inject
    GithubersService githubersSevice;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login= request.getParameter("login");
        githubersSevice.track(login); //TODO ajouter la gestion des login inexistants
        response.sendRedirect("githubers");
    }
}

