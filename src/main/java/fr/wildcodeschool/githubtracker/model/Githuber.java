package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "githuber")
public class Githuber implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private int id_bd;
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String login;
    @Column
    private String url;
    @Column
    private String bio;
    @Column
    private String location;
    @Column(name = "avatar_url")
    private String avatar;

    @JsonCreator
    // @JsonIgnoreProperties(ignoreUnknown=true) Plus besoin avec la classe OjectMapperProducer
    public Githuber(@JsonProperty("name") String name, @JsonProperty("id") int id, @JsonProperty("email") String email, @JsonProperty("login") String login, @JsonProperty("avatar_url") String avatar) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.login = login;
        this.avatar = avatar;
    }

    public Githuber() {
    }

    public Githuber(String name, int id, String email, String login, String avatar, String url, String bio, String location) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.login = login;
        this.avatar = avatar;
        this.url = url;
        this.bio = bio;
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

