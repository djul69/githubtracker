package fr.wildcodeschool.githubtracker.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
public class Credentials {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private int id_user;
    @Column
    private String login;
    @Column
    private String password;

    //Constructors
    public Credentials(){

    }
    public Credentials(int id_user,String login, String password) {
        this.id_user=id_user;
        this.login = login;
        this.password = password;
    }

    //getters
    public String getLogin() {
        return login;
    }

    //setters
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
