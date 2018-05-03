package org.minions.devfund.rafael;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is the main class of Movie.
 * <p>
 * Movie
 * This class will have the following instance variables:
 * String name – the name of the movie
 * ArrayList<Actor> actors – an ArrayList of the actors in the movie.
 * double rating – a freshness rating from rotten tomatoes (www.rottentomatoes.com)
 * Add getters and setters for these instance variables.
 * <p>
 * Make sure to create a constructor that initializes your variables appropriately.
 *
 * @author rafael alfaro
 * @version 1.0
 */
public class Movie implements Comparable<Movie> {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    /**
     * Constructor of Movie class.
     *
     * @param name : movie name
     */
    Movie(final String name) {
        this.name = name;
        this.rating = 0.0;
        actors = new ArrayList<>();
    }

    /**
     * Constructor of movie class without name.
     */
    public Movie() {
        this("");
    }

    /**
     * Gets name of Movie.
     *
     * @return String name of movie
     */
    String getName() {
        return name;
    }

    /**
     * Set the movie's name.
     *
     * @param name Movies name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets Actors list.
     *
     * @return String: Actors name
     */
    List<Actor> getActors() {
        return actors;
    }

    /**
     * Sets Actors name.
     *
     * @param actors Actors list
     */
    public void setActors(final List<Actor> actors) {
        this.actors = (ArrayList<Actor>) actors;
    }

    /**
     * Gets rating.
     *
     * @return double rating
     */
    double getRating() {
        return rating;
    }

    /**
     * Sets Rating.
     *
     * @param rating rating
     */
    void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Verifies if an object is equals to other object.
     *
     * @param obj Movie
     * @return : if a movie is equal to other movie object.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return ((Movie) obj).getName().equals(name);
    }

    /**
     * Gets object hash code.
     *
     * @return object hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name.hashCode(), actors.hashCode(), rating);
    }

    /**
     * Returns Rating to string.
     *
     * @return String
     */
    public String toString() {
        return name + " Rating: " + rating;
    }

    /**
     * Compare two object.
     *
     * @param objectMovie Movie object
     * @return String
     */
    @Override
    public int compareTo(final Movie objectMovie) {
        double movieRating = objectMovie.getRating();
        if (rating > movieRating) {
            return 1;
        } else if (rating < movieRating) {
            return -1;
        } else {
            return 0;
        }
    }
}
