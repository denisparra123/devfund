/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekThree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Denis Parra
 */
public class MovieDatabase {

    private final Set<Actor> actors;
    private final Set<Movie> movies;

    /**
     * Deafult constructor.
     */
    public MovieDatabase() {
        actors = new HashSet<>();
        movies = new HashSet<>();
    }

    /**
     * This methos is to add a {@link Movie}.
     * @param name name of the movie.
     * @param actors actors of the movie.
     */
    public void addMovie(final String name, final String[] actors) {
        Movie movie = getMovie(name);
        for (String actorName: actors) {
            Actor actorToAdd = getActor(actorName);
            movie.addActor(actorToAdd);
            actorToAdd.addMovie(movie);
            this.actors.add(actorToAdd);
        }
        movies.add(movie);
    }

    /**
     * This method is to add a rating to {@link Movie}.
     * @param name name of the movie.
     * @param rating rating of the movie.
     */
    public void addRating(final String name, double rating) {
        movies.forEach(movie -> {
            if (name.equals(movie.getName())) {
                movie.setRating(rating);
            }
        });
    }

    /**
     * This method is to update a rating to {@link Movie}.
     * @param name name of the movie.
     * @param newRating rating of the movie.
     */
    public void updateRating(final String name, double newRating) {
        addRating(name, newRating);
    }

    /**
     * This method is to get the best actor.
     * @return the name of {@link Actor}
     */
    public String getBestActor() {
        double maxAverage = 0;
        Actor result = new Actor("");
        for (Actor actor: actors) {
            double sumRating = 0;
            List<Movie> moviesActor = actor.getMovies();
            sumRating = moviesActor.stream().mapToDouble(movie -> movie.getRating()).sum();
            double average = sumRating / moviesActor.size();
            if (average > maxAverage) {
                maxAverage = average;
                result = actor;
            }
        }
        return result.getName();
    }

    /**
     * This method is to get the best {@link Movie}.
     * @return the name of the {@link Movie}
     */
    public String getBestMovie() {
        double maxRating = 0;
        Movie result = new Movie("");
        for (Movie movie: movies) {
            double rating = movie.getRating();
            if (maxRating < rating) {
                maxRating = rating;
                result = movie;
            }
        }
        return result.getName();
    }

    /**
     * This methos is to get a {@link Movie} if exist.
     * @param name to search.
     * @return a {@link Movie}
     */
    private Movie getMovie(final String name) {
        return movies.stream().filter(movie -> name.equals(movie.getName()))
                .findFirst().orElse(new Movie(name));
    }

    /**
     * This method is to get a {@link Actor} if exist.
     * @param name to filter.
     * @return  a {@link Actor}
     */
    private Actor getActor(final String name) {
        return actors.stream().filter(actor -> name.equals(actor.getName()))
                .findFirst().orElse(new Actor(name));
    }
}
