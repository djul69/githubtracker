package fr.wildcodeschool.githubtracker.controller.rest;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;
import fr.wildcodeschool.githubtracker.controller.rest.JWT.JWTTokenNeeded;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Dependent
@Path("/")
@JWTTokenNeeded
public class  RestService {
    @Inject
    GithubersService ghs;

    @GET
    @Path("/githubers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGithubers() {
        List<Githuber> myList = ghs.getAllGithubers();
        return Response.ok(myList).build();
    }

    @POST
    @Path("/githuber/{login}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response recordGithuber(@Context UriInfo uriInfo, @PathParam("login") String login) {
        Githuber githuber = ghs.getAllGithubers().stream().filter(githuber1 -> githuber1.getLogin().equals(login)).findFirst().orElse(null); //on ne fait pas un inject du githuber car si on a plusieurs acces en meme temps à l'API ca va bugger
        if (githuber == null) {
            ghs.track(login);
            return Response.created(uriInfo.getBaseUriBuilder().path("githuber").path(login).build()).status(201).entity("retrouvez les infos de " + login + " sur " + uriInfo.getBaseUriBuilder().path("githuber").path(login).toString() + " en méthode GET").build();
        } else {
            return Response.created(null).status(409).entity("Le githuber est déjà dans la base").build();
        }
    }

    @GET
    @Path("/githuber/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recordedGithuber(@PathParam("login") String login) {
        Githuber githuber = ghs.getAllGithubers().stream().filter(githuber1 -> githuber1.getLogin().equals(login)).findFirst().orElse(null);
        if (githuber == null) {
            return Response.created(null).status(404).entity("Le githuber n'existe pas").build();
        } else {
            return Response.ok(githuber).build();
        }
    }


    @DELETE
    @Path("/githuber/{id_githuber}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response eraseGithuber(@PathParam("id_githuber") int id_githuber) {
        Githuber githuber = ghs.getAllGithubers().stream().filter(githuber1 -> githuber1.getId() == id_githuber).findFirst().orElse(null);
        if (githuber == null) {
            return Response.created(null).status(404).entity("Le githuber n'existe pas").build();
        } else {
            ghs.untrack(id_githuber);
            return Response.ok("le githuber " + githuber.getLogin() + " a été effacé").build();
        }
    }

    @GET
    @Path("/test")
    @Produces("text/plain")
    public String test() {
        return "this is a test";
    }

}
