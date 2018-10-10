package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.GithubUtils;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InJdbc;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;
@Dependent
public class GithubersService {
    //private GithuberDAO dao; plus d'acualité depuis MemoryGithuberDAO
    //private MemoryGithuberDAO dao; plus d'actualité depuis le qualifier InMemory
    @Inject  @InJdbc //on choisit d'utiliser le DAO memoire ou BDD
    GithuberDAO dao;
    @Inject
    GithubUtils githubUtils;
    /*@Inject                                        //injection par bean constructor
    public GithubersService(MemoryGithuberDAO dao) {
        this.dao = dao;
    }
*/

    public List<Githuber> getAllGithubers() throws SQLException {
        return dao.getGithubers();
    }

    public Githuber getGithuber(String login) throws SQLException {
        return getAllGithubers().stream().filter(githuber -> githuber.getLogin().equals(login)).findFirst().orElse(null);
    }

    public void track(String login) throws SQLException{
         dao.saveGithuber(githubUtils.parseGithuber(login)); //la méthode Track permet de switcher entre un githuberDAO @inmemory ou @injdbc
        //TODO ajouter la gestion des login inexistants
    }

    public void untrack(int id_githuber )throws SQLException {
        dao.deleteGithuber(id_githuber);
    }
}

    





