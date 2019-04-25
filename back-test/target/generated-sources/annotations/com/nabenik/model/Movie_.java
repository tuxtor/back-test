package com.nabenik.model;

import com.nabenik.model.Actor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-24T20:31:38")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> duration;
    public static volatile SingularAttribute<Movie, String> year;
    public static volatile SingularAttribute<Movie, Long> movieId;
    public static volatile ListAttribute<Movie, Actor> actorList;
    public static volatile SingularAttribute<Movie, String> title;

}