package org.example.resources;

import org.example.entities.Logement;
import org.example.metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("logements")
public class LogementResources {
    public static LogementBusiness L = new LogementBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response getLogementsList() {
        return Response.status(200).entity(L.getListeLogements()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("log/{ref}")
    public Response getLogementsListeByref(@PathParam("ref") int reference) {
        Logement logement = L.getLogementsByReference(reference);

            return Response.status(200).entity(logement).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("delegation")
    public Response getLogementByDelegation(@QueryParam("delparam") String del) {
        List<Logement> logements = L.getLogementsByDeleguation(del);

            return Response.status(200).entity(logements).build();

        }




    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listByRef/{ref}")
    public Response getLogementsListeByRef(@PathParam("ref") int reference) {
        List<Logement> logements = L.getLogementsListeByref(reference);
            return Response.status(200).entity(logements).build();


    }




    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response addLogement(Logement logement) {
        boolean isAdded = L.addLogement(logement);
            return Response.status(201).entity("Logement ajouté avec succès").build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("update/{ref}")
    public Response updateLogement(@PathParam("ref") int reference, Logement logement) {
        boolean isUpdated = L.updateLogement(reference, logement);
            return Response.status(200).entity("Logement mis à jour avec succès").build();
    }

    @DELETE
    @Path("delete/{ref}")
    public Response deleteLogement(@PathParam("ref") int reference) {
        boolean isDeleted = L.deleteLogement(reference);
            return Response.status(200).entity("Logement supprimé avec succès").build();

    }
}