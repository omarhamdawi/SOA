package org.example.resources;


import org.example.entities.Logement;
import org.example.metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/HelloClass")
public class Hello {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("SayHello")
    public String sayHello(){
        return "Hello";
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("logements")
    public void AddLogement(Logement l){
        LogementBusiness service = new LogementBusiness();
        service.addLogement(l);
    }

}
