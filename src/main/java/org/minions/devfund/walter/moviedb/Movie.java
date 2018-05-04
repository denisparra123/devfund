package org.minions.devfund.walter.moviedb;

import java.util.ArrayList;

/**
 * Movie class.
 */
public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private Double rating;

    /**
     * Constructor of Movie.
     * @param name name of movie.
     */
    public Movie(final String name) {
        this.name = name;
        this.actors = new ArrayList<Actor>();
        this.rating = 0.0;
    }

    /**
     * Constructor of Movie.
     */
    public Movie() {
        this("");
    }

    /**
     * Gets name of the movie.
     * @return name of movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of movie.
     * @param name name of movie.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets list of Actors.
     * @return list of actors.
     */
    public ArrayList<Actor> getActors() {
        return actors;
    }

    /**
     * Sets list of actors.
     * @param actors list of actors.
     */
    public void setActors(final ArrayList<Actor> actors) {
        this.actors = actors;
    }

    /**
     * Gets rating of movie.
     * @return rating of movie.
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Sets rating of movie.
     * @param rating rating of movie.
     */
    public void setRating(final Double rating) {
        this.rating = rating;
    }
}
