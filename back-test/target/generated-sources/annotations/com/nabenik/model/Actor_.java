package com.nabenik.model;

import com.nabenik.model.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-24T20:31:38")
@StaticMetamodel(Actor.class)
public class Actor_ { 

    public static volatile SingularAttribute<Actor, String> birthday;
    public static volatile SingularAttribute<Actor, String> country;
    public static volatile SingularAttribute<Actor, Long> actorId;
    public static volatile SingularAttribute<Actor, Movie> movie;
    public static volatile SingularAttribute<Actor, String> name;

}