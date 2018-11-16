package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.model.Credentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;

@Path("/login")
public class AuthenticatorEndpoint {
    final Logger log = LoggerFactory.getLogger(AuthenticatorEndpoint.class);
    @PersistenceContext
    private EntityManager em;
    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON) //eg: { "login": "julien", "password": "......" }
    public Response authentification(Credentials creds) {
        try {
            authenticate(creds.getLogin(), creds.getPassword());
            log.info(String.format("login/password : %s/%s", creds.getLogin(), creds.getPassword()));
            String token = issueToken(creds.getLogin(), creds.getPassword());
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build(); //renvoi dans le Header le token
        } catch (Exception e) {
            return Response.status(401).build();
        }
    }

    private void authenticate(String login, String password) {
        TypedQuery<Credentials> query = em.createNamedQuery("FIND_BY_LOGIN_PASSWORD", Credentials.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        Credentials creds = query.getSingleResult();

        if (creds == null)
            throw new SecurityException("Invalid user/password");
    }

    /*
    methoce pour construire le token JWT
     */
    private String issueToken(String login, String password) {
        String keyString = "simplekey";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setSubject(password)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        log.info("#### generating token for a key : " + jwtToken + " - " + key);
        return jwtToken;
    }
}
