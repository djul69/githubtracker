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

@WebServlet(name = "UnTrackServlet",urlPatterns="/UnTrack")
public class UnTrackServlet extends HttpServlet {
    @Inject
    GithubersService githubersService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id=request.getParameter("id_githuber");

    int id_githuber=Integer.parseInt(id);

        try {
            githubersService.untrack(id_githuber );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/githubersDelete.jsp").forward(request,response);
    }
}
