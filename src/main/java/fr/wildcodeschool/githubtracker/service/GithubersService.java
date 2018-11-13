package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.GithubUtils;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InJpa;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
@Dependent
public class GithubersService {
    //private GithuberDAO dao; plus d'acualité depuis MemoryGithuberDAO
    //private MemoryGithuberDAO dao; plus d'actualité depuis le qualifier InMemory
    @Inject  @InJpa //on choisit d'utiliser le DAO memoire ou BDD
    GithuberDAO dao;
    @Inject
    GithubUtils githubUtils;
    /*@Inject                                        //injection par bean constructor
    public GithubersService(MemoryGithuberDAO dao) {
        this.dao = dao;
    }
*/

    public List<Githuber> getAllGithubers()  {
        return dao.getGithubers();
    }

    public Githuber getGithuber(String login)  {
        return getAllGithubers().stream().filter(githuber -> githuber.getLogin().equals(login)).findFirst().orElse(null);
    }

    public void track(String login) {
        try {
            dao.saveGithuber(githubUtils.parseGithuber(login)); //la méthode Track permet de switcher entre un githuberDAO @inmemory ou @injdbc
        } catch (NullPointerException e) {
            throw new RuntimeException("login github non trouvé", e);
        }
    }

    public void untrack(int id_githuber ) {
        dao.deleteGithuber(id_githuber);
    }
}

    





