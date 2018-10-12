package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "fr.wildcodeschool.githubtracker.controller.GithubersServlet", urlPatterns = {"/githubers"})
public class GithubersServlet extends HttpServlet {
    @Inject
    private GithubersService ghs; //injection par bdirect field injection

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("myList", ghs.getAllGithubers());
        request.getRequestDispatcher("/WEB-INF/githubers.jsp").forward(request,response);
    }
}

