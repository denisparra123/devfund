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
public class Actor {

    private static final int SEVEN = 7;
    private static final int SEVENTY_NINE = 79;
    private final String name;
    private final Set<Movie> movies;

    /**
     * Default constructor.
     * @param name name of actor.
     */
    public Actor(final String name) {
        this.name = name;
        movies = new HashSet<>();
    }

    /**
     * This methos is to add a {@link Movie}.
     * @param movie to add
     * @return true if this added correctly.
     */
    public boolean addMovie(final Movie movie) {
        return movies.add(movie);
    }

    /**
     * This methos is to get the name of the actor.
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * This methos is to get all {@link Movie} that below the current actor.
     * @return a list of movies
     */
    public List<Movie> getMovies() {
        List<Movie> result = new ArrayList<>();
        movies.forEach(movie -> result.add(movie));
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = SEVEN;
        hash = SEVENTY_NINE * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     *  {@inheritDoc}
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
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
