package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.UserDAO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
@Dependent
public class UserService {
@Inject
    UserDAO userDAO;

    public void authenticateDAO (String login, String password){
        userDAO.authenticateDAO(login, password);
    }
}

    





