package org.minions.devfund.rafael;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * This class has two instance variables:
 * ArrayList<Movie> movieList – an ArrayList of movies
 * ArrayList<Actor> actorList – an ArrayList of actors
 * <p>
 * Note: Make sure to add getters for both these instance variables. That is, add a getMovieList() and a
 * getActorList() method.
 * <p>
 * Add the following methods to this class:
 * <p>
 * MovieDatabase()
 * a constructor that just creates a new movieList and a new actorList. At the time of construction,
 * both of these lists will be empty.
 * <p>
 * void addMovie(String name, String[] actors)
 *
 * @author rafael alfaro
 * @version 1.0
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * a constructor that just creates a new movieList and a new actorList.
     * At the time of construction, both of these lists will be empty.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Reads Rating from files.
     *
     * @param moviesDB Movie Data Base
     */
    private static void readRating(final MovieDatabase moviesDB) {
        try (Scanner sc = new Scanner(new File("resources/ratings.txt"))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] ratings = sc.nextLine().split("\t");
                moviesDB.addRating(ratings[0], Double.parseDouble(ratings[1]));
            }
            sc.close();
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.toString());
        }
    }

    /**
     * Reads Movies from file.
     *
     * @param moviesDB Movie Data Base
     */
    private static void readMovie(final MovieDatabase moviesDB) {
        Map<String, List<String>> movies = new HashMap<>();
        try (Scanner sc = new Scanner(new File("resources/movies.txt"))) {
            while (sc.hasNextLine()) {
                String[] actors = sc.nextLine().split(", ");
                for (int i = 1; i < actors.length; i++) {
                    if (!movies.containsKey(actors[i])) {
                        movies.put(actors[i], new ArrayList<>());
                    }
                    movies.get(actors[i]).add(actors[0]);
                }
            }
            for (String movie : movies.keySet()) {
                List<String> actors = movies.get(movie);
                moviesDB.addMovie(movie, actors.toArray(new String[0]));
            }
            sc.close();
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.toString());
        }
    }


    /**
     * Gets Movie list.
     *
     * @return movie list
     */
    public ArrayList<Movie> getMovieList() {
        return this.movieList;
    }

    /**
     * Gets Actor List.
     *
     * @return actors list
     */
    public ArrayList<Actor> getActorList() {
        return this.actorList;
    }

    /**
     * This method takes in the name of a movie that is not currently in the database along with a list of
     * actors for that movie.
     * If the movie is already in the database, your code ignores this request (this specification is
     * an oversimplification).
     * If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     *
     * @param name   actor name
     * @param actors actor list
     */
    private void addMovie(final String name, final String[] actors) {
        Movie newMovie = new Movie(name);

        if (!movieList.contains(newMovie)) {
            movieList.add(newMovie);

            for (String actorName : actors) {
                Actor actor = new Actor(actorName);
                if (!actorList.contains(actor)) {
                    actorList.add(actor);
                } else {
                    actor = actorList.get(actorList.indexOf(actor));
                }

                newMovie.getActors().add(actor);
                actor.getMovies().add(newMovie);

            }
        }
    }

    /**
     * Add a rating for this movie.
     * Assume that the name argument will definitely be a name that is currently in the database.
     *
     * @param name   Name
     * @param rating Rating
     */
    private void addRating(final String name, final double rating) {
        if (movieList.indexOf(new Movie(name)) != -1) {
            movieList.get(movieList.indexOf(new Movie(name))).setRating(rating);
        }
    }

    /**
     * Overwrite the current rating of a movie with this new rating.
     * Assume that the name argument will definitely be a name that is currently in the database.
     *
     * @param name      Name
     * @param newRating Rating
     */
    public void updateRating(final String name, final double newRating) {
        movieList.get(movieList.indexOf(new Movie(name))).setRating(newRating);
    }

    /**
     * Prints the actors of Db.
     */
    public void printActorsDatabase() {
        for (Actor actor : actorList) {
            System.out.println(actor);
            for (Movie movie : actor.getMovies()) {
                System.out.println("\t" + movie);
            }
        }
    }

    /**
     * Prints the movies of Db.
     */
    public void printMoviesDatabase() {
        for (Movie movie : movieList) {
            System.out.println(movie);
            for (Actor actor : movie.getActors()) {
                System.out.println("\t" + actor);
            }
        }
    }

    /**
     * Returns the name of the movie with the highest rating.
     * In the case of a tie, return any one of the best movies.
     *
     * @return Return best movie
     */
    private String getBestMovie() {
        Collections.sort(movieList);
        return movieList.get(movieList.size() - 1).getName();
    }

    /**
     * Returns the name of the actor that has the best average rating for their movies.
     * In the case of a tie, return any one of the best actors.
     *
     * @return Return Best Actor
     */
    private String getBestActor() {
        Collections.sort(actorList);
        return actorList.get(actorList.size() - 1).getName();
    }

    /**
     * Create a new instance of a movieDatabase.
     * Add all the movies in the file movies.txt.
     * Go through the ratings of the movies in the file ratings.txt and add the ratings for the movies.
     * Call the methods that you created and print out the name of the best actor
     * and the name of the highest rated movie.
     *
     * @param args argument list
     */
    public static void main(final String[] args) {
        MovieDatabase movieDB = new MovieDatabase();
        readMovie(movieDB);
        readRating(movieDB);
        System.out.println("Best movie: " + movieDB.getBestMovie());
        System.out.println("Best actor: " + movieDB.getBestActor());
    }
}
