package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.model.Credentials;
import fr.wildcodeschool.githubtracker.service.JWT.SimpleKeyGenerator;
import org.slf4j.Logger;

import javax.inject.Inject;
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

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;

@Path("/login")
public class AuthenticatorEndpoint {
    @Inject
    Logger log;
    @PersistenceContext
    private EntityManager em;
    @Inject
    private SimpleKeyGenerator keyGenerator;
    @Context
    private UriInfo uriInfo;

    //Obtenir une liste de Users dans la Table "user"
    public Credentials getCreds() {
        TypedQuery<Credentials> query = em.createQuery("select c from Credentials c where c.login='julien'", Credentials.class);
        return query.getSingleResult();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) //eg: { "login": "wilder", "password": "wcs12345" }
    public Response authenticate(Credentials creds) {
        creds = getCreds();
        log.info(String.format("login/password : %s/%s", creds.getLogin(), creds.getPassword()));

        if (true) {  //LET'S ASSUME WE LOG IN HERE
            // Issue a token for the user and return it within the response
            String token = issueToken(creds.getLogin());
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
        } else {
            return Response.status(401).build();
        }
    }

    private String issueToken(String login) {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoianVsaWVuIiwicGFzc3dvcmQiOiJodWFjcnJ0In0.9s56LC0drKf3lo38-MRP7PENAckv9DC1MZ0EM9fG820";
    }
}
