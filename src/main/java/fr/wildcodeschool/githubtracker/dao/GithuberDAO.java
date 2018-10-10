package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.sql.SQLException;
import java.util.List;

public interface GithuberDAO {
    List<Githuber> getGithubers() throws SQLException;
    void saveGithuber(Githuber githuber)throws SQLException;
    void deleteGithuber(int id_githuber)throws SQLException;
}