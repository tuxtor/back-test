package com.nabenik.controller;

import com.nabenik.model.Movie;
import com.nabenik.repository.MovieRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieController {


    @Inject
    MovieRepository movieRepository;

    @GET
    public List<Movie> listAll(@QueryParam("title") String title){
        return movieRepository.listAll(title);
    }

    @GET
    @Path("/{id}")
    public Movie findById(@PathParam("id") Long id){
        return movieRepository.findById(id);
    }

    @PUT
    public Response create(Movie movie)
    {
        if(movie!=null)
            movieRepository.create(movie);
        else
            System.err.println("Movie is null, can't create a movie");
        return Response.created(URI.create("/Lol")).build();
    }

    @POST
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Movie movie){
        if(movie!=null&&id!=null)
            movieRepository.update(movie);
        else
            System.err.println("Id or movie is null, cant update a movie");
        return Response.created(URI.create("/Lol")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        
        Movie movie = movieRepository.findById(id);
        if(movie!=null)
            movieRepository.delete(movie);
        else
            System.out.println("Movie with Id: "+id+" not found");
        return Response.ok().build();
    }
}
