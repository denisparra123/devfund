package org.minions.devfund.rafael;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class will have the following instance variables:
 * String name – the full name of the actor or actress.
 * ArrayList<Movie> movies – an Arraylist that has movies that this actor has acted in.
 * Add getters and setters for these instance variables.
 * <p>
 * Make sure to create a constructor that initializes your variables appropriately.
 *
 * @author rafael alfaro
 * @version 1.0
 */
public class Actor implements Comparable<Actor> {
    private String name;
    private ArrayList<Movie> movies;

    /**
     * Constructor of Actor.
     *
     * @param name Actor Name.
     */
    Actor(final String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    /**
     * Actor Constructor.
     */
    public Actor() {
        this("");
    }

    /**
     * Gets actor name.
     *
     * @return String: Actor name
     */
    String getName() {
        return name;
    }

    /**
     * Sets actor name.
     *
     * @param name Actor name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the movies.
     *
     * @return movies list
     */
    List<Movie> getMovies() {
        return movies;
    }

    /**
     * Sets movies.
     *
     * @param movies movie list
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = (ArrayList<Movie>) movies;
    }

    /**
     * Verifies if an object is equals to other object.
     *
     * @param obj Actor
     * @return if a actor is equal to other actor object returns true.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return ((Actor) obj).getName().equals(name);
    }

    /**
     * Gets object hash code.
     *
     * @return object hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name.hashCode(), movies.hashCode());
    }


    /**
     * Returns the average rating in a string.
     *
     * @return average rating
     */
    public String toString() {
        return name + " average rating: " + getActorRating();
    }

    /**
     * Gets Actor rating.
     *
     * @return double
     */
    private double getActorRating() {
        double ratingSum = 0;
        for (Movie movie : movies) {
            ratingSum += movie.getRating();
        }
        return ratingSum / movies.size();
    }

    /**
     * Compare two objects.
     *
     * @param objectActor Actor object
     * @return int
     */
    @Override
    public int compareTo(final Actor objectActor) {
        Double rating = this.getActorRating();
        double actorRating = objectActor.getActorRating();
        if (rating > actorRating) {
            return 1;
        } else if (rating < actorRating) {
            return -1;
        } else {
            return 0;
        }
    }
}
