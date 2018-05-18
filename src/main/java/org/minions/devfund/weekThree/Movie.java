/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekThree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Denis Parra
 */
public class Movie {

    private static final int SEVEN = 7;
    private static final int FIFTY_NINE = 59;
    private static final double DEFAULT_RATING = 1.0;
    private final String name;
    private final Set<Actor> actors;
    private double rating;

    /**
     * This default constructor.
     * @param name name of the movie
     */
    public Movie(final String name) {
        this.name = name;
        actors = new HashSet<>();
        rating = DEFAULT_RATING;
    }

    /**
     * This method is to get the name of the {@link Movie}.
     * @return the name of the  movie.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is to add an {@link Actor}.
     * @param actor to add.
     * @return true if is added correctly.
     */
    public boolean addActor(final Actor actor) {
        return actors.add(actor);
    }

    /**
     * This methos is to get all {@link Actor} of the current movie.
     * @return a list of {@link Actor}
     */
    public List<Actor> getActors() {
        List<Actor> result = new ArrayList<>();
        actors.forEach(actor -> result.add(actor));
        return result;
    }

    /**
     * This method is to get the rating of the movie.
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * This methos is to set the current rating.
     * @param rating the new rating
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        int hash = SEVEN;
        hash = FIFTY_NINE * hash + Objects.hashCode(this.name);
        hash = FIFTY_NINE * hash + Objects.hashCode(this.actors);
        return hash;
    }

    /**
     * @inheritDoc
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
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.actors, other.actors)) {
            return false;
        }
        return true;
    }

}
