package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.GithubUtils;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;

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
    @Inject  @InMemory
    GithuberDAO githuberDAO;

    @Inject
    GithubUtils githubUtils;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login= request.getParameter("login");
        githuberDAO.saveGithuber(githubUtils.parseGithuber(login));
        response.sendRedirect("githubers");
    }

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
}

