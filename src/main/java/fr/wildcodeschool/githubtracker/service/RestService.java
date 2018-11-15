package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.model.Githuber;

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
public class RestService {
    @Inject
    GithubersService ghs;
    @Inject
    Githuber githuber;

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
        githuber = ghs.getAllGithubers().stream().filter(githuber -> githuber.getLogin().equals(login)).findFirst().orElse(null);
        if (githuber == null) {
            ghs.track(login);
            return Response.created(uriInfo.getBaseUriBuilder().path("githuber").path("{" + login + "}").build("{name}",login)).status(201).build();
        } else {
            return Response.created(null).status(409).entity("Le githuber est déjà dans la base").build();
        }
    }

    @GET
    @Path("/githuber/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recordedGithuber(@PathParam("name") String login) {
        githuber = ghs.getAllGithubers().stream().filter(githuber -> githuber.getLogin().equals(login)).findFirst().orElse(null);
        return Response.ok("Le nouveau githuber : " + githuber).build();
    }


    @DELETE
    @Path("/githuber/{id_githuber}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response eraseGithuber(@PathParam("id_githuber") int id_githuber) {
        githuber = ghs.getAllGithubers().stream().filter(githuber -> githuber.getId() == id_githuber).findFirst().orElse(null);
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
