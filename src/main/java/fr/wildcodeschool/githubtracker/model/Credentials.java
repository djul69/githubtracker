package fr.wildcodeschool.githubtracker.model;

import javax.persistence.*;


import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "FIND_BY_LOGIN_PASSWORD", query = "SELECT u FROM Credentials u WHERE u.login = :login AND u.password = :password")
})
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

    //Getters and Setters

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

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
