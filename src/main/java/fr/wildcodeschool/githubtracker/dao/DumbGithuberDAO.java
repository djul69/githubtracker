package fr.wildcodeschool.githubtracker.dao;
/**
 * class utilisée pour stocker des githubers en dur
 */

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Dependent
public class DumbGithuberDAO implements GithuberDAO {
    @Override
    public List<Githuber> getGithubers() {
        Githuber user1 = new Githuber("hervé", 34, "hervé@gmail.com", "Hmarionx", "https://api.adorable.io/avatars/141/herv%C3%A9@gmail.com");
        Githuber user2 = new Githuber("jeff", 456, "jeff@gmail.com", "jfm17", "https://api.adorable.io/avatars/141/jeff@gmail.com");
        Githuber user3 = new Githuber("stephane", 2, "stephane@gmail.com", "stephwildcode", "https://api.adorable.io/avatars/141/stephane@gmail.com");
        Githuber user4 = new Githuber("julien", 1345, "julien@gmail.com", "djul69", "https://api.adorable.io/avatars/141/julien@gmail.com");
        Githuber user5 = new Githuber("julien2", 26, "julien2@gmail.com", "julienroyer", "https://api.adorable.io/avatars/141/julien2@gmail.com");
        List<Githuber> myList = new ArrayList<Githuber>();
        myList.add(user1);
        myList.add(user2);
        myList.add(user3);
        myList.add(user4);
        myList.add(user5);
        List<Githuber> myListImmuable = Collections.unmodifiableList(myList);
        return myListImmuable;
    }

    @Override
    public void saveGithuber(Githuber githuber) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteGithuber(int id_githuber)  {
    }
}

