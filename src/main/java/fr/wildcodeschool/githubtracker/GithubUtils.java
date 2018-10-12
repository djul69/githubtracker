package fr.wildcodeschool.githubtracker;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@ApplicationScoped
public class GithubUtils {
    String GIT_ULR ="https://api.github.com/users/";
    @Inject
    private ObjectMapper om;

    public Githuber parseGithuber(String login) {
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
    }
}
