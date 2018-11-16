package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.model.Credentials;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class UserService  {
    @PersistenceContext
    private EntityManager em;

    public void authenticateDAO (String login, String password){
        TypedQuery<Credentials> query = em.createNamedQuery("FIND_BY_LOGIN_PASSWORD", Credentials.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        Credentials creds = query.getSingleResult();

        if (creds == null)
            throw new SecurityException("Invalid user/password");
    }
}

    





