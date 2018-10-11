package fr.wildcodeschool.githubtracker.dao;
/**
 * classe utilisée pour stocker des githubers en memoire a partir d'un login
 */

import fr.wildcodeschool.githubtracker.GithubUtils;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@InMemory
@ApplicationScoped

public class MemoryGithuberDAO implements GithuberDAO {
    String GIT_ULR ="https://api.github.com/users/";
    Map<String, Githuber> myMap = new HashMap<String, Githuber>();
    @Inject
    GithubUtils githubUtils;
    @Inject
    private DumbGithuberDAO dumbGithuberDAO;

    /*@Inject
    private ObjectMapper om; plus d'actualité depuis le qualifier*/

    public List<Githuber> getGithubers() {
        List<Githuber> newList = new ArrayList<Githuber>(myMap.values());
        return newList;
    }

    public void saveGithuber(Githuber githuber) {
        if (githuber!=null){
            myMap.put(githuber.getLogin(), githuber);}
    }

    /*public Githuber parseGithuber(String login) {
        String urlText = GIT_ULR + login;
        final URL url;
        try {
            url = new URL(urlText);
            final URLConnection connection = url.openConnection();
            try (final InputStream is = connection.getInputStream()) {
                return om.readValue(is, Githuber.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
     }*/

    @PostConstruct
    private void recupDumb() {
        List<Githuber> myList = dumbGithuberDAO.getGithubers();
        for (Githuber githuber : myList) {
            saveGithuber(githubUtils.parseGithuber(githuber.getLogin()));

        }
    }

    @Override
    public void deleteGithuber(int id_githuber)  {
    }
}


