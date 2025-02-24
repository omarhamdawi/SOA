package org.example.resources;

import org.example.entities.RendezVous;
import org.example.metiers.RendezVousBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("rendezvous")
public class RendezVousResources {
    private static final RendezVousBusiness rendezVousBusiness = new RendezVousBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response getAllRendezVous() {
        List<RendezVous> rendezVousList = rendezVousBusiness.getListeRendezVous();
        return Response.status(200).entity(rendezVousList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getRendezVousById(@PathParam("id") int id) {
        RendezVous rendezVous = rendezVousBusiness.getRendezVousById(id);
            return Response.status(200).entity(rendezVous).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("logement/{reference}")
    public Response getRendezVousByLogementReference(@PathParam("reference") int reference) {
        List<RendezVous> rendezVousList = rendezVousBusiness.getListeRendezVousByLogementReference(reference);
            return Response.status(200).entity(rendezVousList).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response addRendezVous(RendezVous rendezVous) {
        boolean isAdded = rendezVousBusiness.addRendezVous(rendezVous);
            return Response.status(201).entity("Rendez-vous ajouté avec succès").build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    public Response updateRendezVous(@PathParam("id") int id, RendezVous updatedRendezVous) {
        boolean isUpdated = rendezVousBusiness.updateRendezVous(id, updatedRendezVous);

            return Response.status(200).entity("Rendez-vous mis à jour avec succès").build();

    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteRendezVous(@PathParam("id") int id) {
        boolean isDeleted = rendezVousBusiness.deleteRendezVous(id);
            return Response.status(200).entity("Rendez-vous supprimé avec succès").build();

    }
}