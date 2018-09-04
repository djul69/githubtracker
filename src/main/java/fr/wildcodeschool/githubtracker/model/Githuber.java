package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Githuber {
    private String name;
    private int id;
    private String email;
    private String login;
    private String avatar;
    @JsonCreator
    // @JsonIgnoreProperties(ignoreUnknown=true) Plus besoin avec la classe OjectMapperProducer
    public Githuber(@JsonProperty("name") String name, @JsonProperty ("id") int id, @JsonProperty ("email") String email, @JsonProperty ("login") String login, @JsonProperty ("avatar_url") String avatar) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.login = login;
        this.avatar = avatar;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name= name;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email= email;
    }
    public String getLogin()
    {
        return login;
    }
    public void setLogin(String login)
    {
        this.login= login;
    }
    public String getAvatar()
    {
        return avatar;
    }
    public void setAvatar(String avatar)
    { this.avatar= avatar; }
}

