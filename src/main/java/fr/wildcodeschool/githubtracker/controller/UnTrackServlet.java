package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UnTrackServlet",urlPatterns="/UnTrack")
public class UnTrackServlet extends HttpServlet {
    @Inject
    GithubersService githubersService;
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id_githuber");
        int id_githuber=Integer.parseInt(id);

        githubersService.untrack(id_githuber );
        request.getRequestDispatcher("/WEB-INF/githubersDelete.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { request.setAttribute("myList", githubersService.getAllGithubers());
        request.getRequestDispatcher("/WEB-INF/githubers.jsp").forward(request,response);
    }
}
