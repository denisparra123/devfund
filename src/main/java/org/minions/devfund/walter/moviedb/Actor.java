package org.minions.devfund.walter.moviedb;

import java.util.ArrayList;

/**
 * Actor class.
 */
public class Actor {
    private String name;
    private ArrayList<Movie> movies;

    /**
     * Constructor Actor.
     * @param name name of actor.
     */
    public Actor(final String name) {
        this.name = name;
        this.movies = new ArrayList<Movie>();
    }

    /**
     * Constructor Actor.
     */
    public Actor() {
        this("");
    }

    /**
     * Gets name of actor.
     * @return name of actor.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of actor.
     * @param name name of actor.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets list of movies.
     * @return list of movies.
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * Sets list of movies.
     * @param movies list of movies.
     */
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
