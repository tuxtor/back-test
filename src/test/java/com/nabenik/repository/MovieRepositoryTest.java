package com.nabenik.repository;

import com.nabenik.model.Actor;
import com.nabenik.model.Movie;
import com.nabenik.rest.JAXRSConfiguration;
import com.nabenik.util.EntityManagerProducer;
import java.util.List;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

@RunWith(Arquillian.class)
public class MovieRepositoryTest {

    @Inject
    MovieRepository movieRepository;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Deployment
    public static WebArchive createDeployment(){
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addClass(Movie.class)
                .addClass(Actor.class)
                .addClass(EntityManagerProducer.class)
                .addClass(MovieRepository.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/persistence.xml");

        System.out.println(war.toString(true));

        return war;
    }

    @Test
    public void create() {
        Movie movie = new Movie("El silencio de Jimmy", "2014", "4 aÃ±os");
        movieRepository.create(movie);


        System.out.println("Movie Id " + movie.getMovieId());

        assertNotNull(movie.getMovieId());
    }

    /**
     * Test of findById method, of class MovieRepository.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");        
        MovieRepository instance = new MovieRepository();
        Movie expResult = new Movie("Titulo1", "2019", "1 año");
        instance.create(expResult);
        Movie result = instance.findById(expResult.getMovieId());
        assertEquals(expResult, result);
        if(result!=null)
        {
            if(expResult.getMovieId()==result.getMovieId())
                System.out.println("Correct Test");
            else
                fail("Test failed");
         
        }
        else
            fail("Test failed");
    }

    /**
     * Test of create method, of class MovieRepository.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Movie movie = new Movie("titulo1", "2019", "1 año");
        MovieRepository instance = new MovieRepository();
        instance.create(movie);
        Movie result = instance.findById(movie.getMovieId());
        if(result!=null)
        {    
            if(movie.getMovieId()==result.getMovieId())
                System.out.println("Correct test");
            else
                fail("Test failed");
        }
        else
            fail("Test failed");
    }

    /**
     * Test of update method, of class MovieRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Movie movie = new Movie("Titulo1","2019","1 year");
        MovieRepository instance = new MovieRepository();
        instance.create(movie);
        Movie expResult = new Movie("Titulo2", "2019", "1 year");
        expResult.setMovieId(movie.getMovieId());
        Movie result = instance.update(movie);        
        assertEquals(expResult, result);
        
        if(result!=null)
        {
            if(result.getTitle().equals(expResult.getTitle()))
                System.out.println("Correct Text");
            else
                fail("Test failed");
        }
        else
            fail("Test failed");
    }

    /**
     * Test of delete method, of class MovieRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Movie movie = new Movie("Titulo1", "2018", "1 year");
        MovieRepository instance = new MovieRepository();
        instance.create(movie);
        instance.delete(movie);
        Movie result = instance.findById(movie.getMovieId());
        if(result==null)
            System.out.println("Correct Test");
        else
            fail("Test failed");
    }
    

}
