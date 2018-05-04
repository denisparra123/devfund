package org.minions.devfund.walter.moviedb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * MovieDatabase class.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Gets list of Movies.
     * @return list of movies
     */
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Gets list of Actors.
     * @return list of actors
     */
    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    /**
     * Constructor MovieDatabase.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Adds a Movie into the movie list.
     * @param name name of movie.
     * @param actors list of actors.
     */
    public void addMovie(final String name, final String[] actors) {
        Movie movie = searchMovieInDB(name);
        if (movie == null) {
            movie = new Movie(name);
            for (String actorName : actors) {
                Actor actor = searchActorInDB(actorName);
                if (actor == null) {
                    actor = new Actor(actorName);
                    ArrayList<Movie> movies = actor.getMovies();
                    actor.setMovies(movies);
                    ArrayList<Actor> actorsMovie = new ArrayList<>();
                    actorsMovie.add(actor);
                    movie.setActors(actorsMovie);
                    movies.add(movie);
                    actorList.add(actor);
                } else {
                    ArrayList<Actor> actorsMovie = new ArrayList<>();
                    actorsMovie.add(actor);
                    movie.setActors(actorsMovie);

                    ArrayList<Movie> movies = actor.getMovies();
                    movies.add(movie);
                    actor.setMovies(movies);
                }
            }
            movieList.add(movie);
        } else {
            for (String actorName : actors) {
                Actor actor = searchActorInDB(actorName);
                if (actor == null) {
                    actor = new Actor(actorName);
                    ArrayList<Movie> movies = actor.getMovies();
                    actor.setMovies(movies);
                    ArrayList<Actor> actorsMovie = movie.getActors();
                    actorsMovie.add(actor);
                    movie.setActors(actorsMovie);
                    movies.add(movie);
                    actorList.add(actor);
                } else {
                    ArrayList<Actor> actorsMovie = movie.getActors();
                    actorsMovie.add(actor);
                    movie.setActors(actorsMovie);

                    ArrayList<Movie> movies = actor.getMovies();
                    movies.add(movie);
                    actor.setMovies(movies);
                }
            }
        }
    }

    /**
     * Searches a Movie into movie list DB.
     * @param name name of movie.
     * @return movie object.
     */
    public Movie searchMovieInDB(final String name) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Searches an Actor in actor list DB.
     * @param name name of actor.
     * @return actor object.
     */
    public Actor searchActorInDB(final String name) {
        for (Actor actor : actorList) {
            if (actor.getName().equals(name)) {
                return actor;
            }
        }
        return null;
    }

    /**
     * Adds Ratings to a movie.
     * @param name name of the movie.
     * @param rating value of rating.
     */
    public void addRating(final String name, final double rating) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(rating);
            }
        }
    }

    /**
     * Updates the rating of a movie.
     * @param name name of movie.
     * @param newRating new value of rating.
     */
    public void updateRating(final String name, final double newRating) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(newRating);
            }
        }
    }

    /**
     * Gets the best Actor with best average of rating.
     * @return Name of actor.
     */
    public String getBestActor() {
        ArrayList<String> bestAverageRatingActor = new ArrayList<>();
        Double averageRating = 0.0;
        for (Actor actor : actorList) {
            Double average = 0.0;
            for (Movie movie : actor.getMovies()) {
                average += movie.getRating();
            }
            average = average / actor.getMovies().size();
            if (average.compareTo(averageRating) == 0) {
                averageRating = average;
                bestAverageRatingActor.add(actor.getName());
            }
            if (average.compareTo(averageRating) > 0) {
                averageRating = average;
                bestAverageRatingActor.clear();
                bestAverageRatingActor.add(actor.getName());
            }
        }
        return bestAverageRatingActor.get(new Random().nextInt(bestAverageRatingActor.size()));
    }

    /**
     * Gets the best movie with highest rating.
     * @return name of the movie.
     */
    public String getBestMovie() {
        ArrayList<String> movieListHighest = new ArrayList<>();
        double highestRating = 0.0;
        for (Movie movie : movieList) {
            if (movie.getRating().compareTo(highestRating) == 0) {
                highestRating = movie.getRating();
                movieListHighest.add(movie.getName());
            }
            if (movie.getRating().compareTo(highestRating) > 0) {
                highestRating = movie.getRating();
                movieListHighest.clear();
                movieListHighest.add(movie.getName());
            }
        }
        return movieListHighest.get(new Random().nextInt(movieListHighest.size()));
    }

    /**
     * Main method to use the methods and classes created.
     * @param args arguments.
     */
    public static void main(final String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();
        addMovies(movieDatabase);
        addRating(movieDatabase);
        System.out.println("Best Movie: " + movieDatabase.getBestMovie());
        System.out.println("Best Actor: " + movieDatabase.getBestActor());
    }

    /**
     * Adds a movie using ./resources/movies.txt.
     * @param movieDatabase movie database object.
     */
    public static void addMovies(final MovieDatabase movieDatabase) {
        try {
            String fileName = "./resources/movies.txt";

            File file = new File(fileName);
            Scanner sc = new Scanner(file, "UTF-8");
            while (sc.hasNextLine()) {
                ArrayList<String> partialMovies = new ArrayList<>();
                partialMovies.addAll(Arrays.asList(sc.nextLine().split(", ")));
                String[] actor = new String[] {partialMovies.get(0)};
                partialMovies.remove(0);
                for (String movie : partialMovies) {
                    movieDatabase.addMovie(movie, actor);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a rating to the movie using ./resources/ratings.txt.
     * @param movieDatabase movie database object.
     */
    public static void addRating(final MovieDatabase movieDatabase) {
        try {
            String fileName = "./resources/ratings.txt";

            File file = new File(fileName);
            Scanner sc = new Scanner(file, "UTF-8");
            while (sc.hasNextLine()) {
                String[] ratingsByMovie = sc.nextLine().split("\t");
                if (ratingsByMovie[1].equals("critic_score")) {
                    continue;
                }
                movieDatabase.addRating(ratingsByMovie[0], new Double(ratingsByMovie[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
