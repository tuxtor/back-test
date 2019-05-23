package com.nabenik.controller;

import com.nabenik.model.Movie;
import com.nabenik.repository.MovieRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieController {


    @Inject
    MovieRepository movieRepository;

    @GET
    public List<Movie> listAll(@QueryParam("title") String title){

        Movie movie1 = new Movie("The Shawshank Redemption ", "1994", "2h 22min");
        Movie movie2 = new Movie("The Godfather", "1972", "2h 55min");

        return Arrays.asList(movie1, movie2);

    }

    @GET
    @Path("/{id}")
    public Movie findById(@PathParam("id") Long id){
        return movieRepository.findById(id);
    }

    @PUT
    public Response create(Movie movie){
        movieRepository.create(movie);
        return Response.created(URI.create("/Lol")).build();
    }

    @POST
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Movie movie){
        movieRepository.update(movie);
        return Response.created(URI.create("/Lol")).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Movie movie = movieRepository.findById(id);
        movieRepository.delete(movie);
        return Response.ok().build();
    }
}
