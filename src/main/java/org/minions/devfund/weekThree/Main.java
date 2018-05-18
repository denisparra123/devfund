/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekThree;

/**
 *
 * @author Denis Parra
 */
public final class Main {

    private static final double SEVENTY_FOUR = 74.0;
    private static final double FIFTY_ONE = 51.0;
    private static final double FIFTY_FOUR = 54.0;
    private static final double EIGTHY_TWO = 82.0;
    private static final double SEVENTY_NINE = 79.0;
    private static final double FIFTY_NINE = 59.0;
    private static final double SIXTY_NINE = 69.0;
    private static final double NINETY_FIVE = 95.0;
    private static final double SEVENTY_TWO = 72.0;
    private static final double NINETY_SIX = 96.0;
    private static final double SEVENTY_SEVEN = 77.0;
    private static final double SEVENTY_ONE = 71.0;
    private static final double THIRTY_FIVE = 35.0;
    private static final double NINETY = 90.0;
    private static final double EIGTHY_EIGTH = 88.0;
    private static final double THIRTY_NINE = 39.0;
    private static final double SIXTY = 60.0;
    private static final double SIXTY_TWO = 62.0;

    /**
     * Default constructor.
     */
    private Main() {
      //not called
    }

    /**
     * The main method.
     * @param args args.
     */
    public static void main(final String[] args) {
        MovieDatabase database = new MovieDatabase();
        database.addMovie("Sleepers", new String[]{"Brad Pitt", "Dustin Hoffman"});
        database.addMovie("Troy", new String[] {"Brad Pitt", "Diane Kruger"});
        database.addMovie("Meet Joe Black", new String[] {"Brad Pitt", "Anthony Hopkins"});
        database.addMovie("Oceans Eleven", new String[] {"Brad Pitt"});
        database.addMovie("Seven", new String[] {"Brad Pitt"});
        database.addMovie("Mr & Mrs Smith", new String[] {"Brad Pitt"});
        database.addMovie("You've Got Mail", new String[] {"Tom Hanks", "Meg Ryan"});
        database.addMovie("Apollo 13", new String[] {"Tom Hanks"});
        database.addMovie("Sleepless in Seattle", new String[] {"Tom Hanks", "Meg Ryan"});
        database.addMovie("Catch Me If You Can", new String[] {"Tom Hanks"});
        database.addMovie("Philadelphia", new String[] {"Tom Hanks"});
        database.addMovie("Forrest Gump", new String[] {"Tom Hanks"});
        database.addMovie("National Treasure", new String[] {"Diane Kruger"});
        database.addMovie("Rain Man", new String[] {"Dustin Hoffman"});
        database.addMovie("Kramer vs. Kramer", new String[] {"Dustin Hoffman"});
        database.addMovie("Hannibal", new String[] {"Anthony Hopkins"});
        database.addMovie("The Edge", new String[] {"Anthony Hopkins", "Alec Baldwin"});
        database.addMovie("Proof", new String[] {"Anthony Hopkins"});
        database.addRating("Sleepers", SEVENTY_FOUR);
        database.addRating("Troy", FIFTY_FOUR);
        database.addRating("Meet Joe Black", FIFTY_ONE);
        database.addRating("Oceans Eleven", EIGTHY_TWO);
        database.addRating("Seven", SEVENTY_NINE);
        database.addRating("Mr & Mrs Smith", FIFTY_NINE);
        database.addRating("You've Got Mail", SIXTY_NINE);
        database.addRating("Apollo 13", NINETY_FIVE);
        database.addRating("Sleepless in Seattle", SEVENTY_TWO);
        database.addRating("Catch Me If You Can", NINETY_SIX);
        database.addRating("Philadelphia", SEVENTY_SEVEN);
        database.addRating("Forrest Gump", SEVENTY_ONE);
        database.addRating("National Treasure", THIRTY_FIVE);
        database.addRating("Rain Man", NINETY);
        database.addRating("Kramer vs. Kramer", EIGTHY_EIGTH);
        database.addRating("Hannibal", THIRTY_NINE);
        database.addRating("The Edge", SIXTY);
        database.addRating("Proof", SIXTY_TWO);
        System.out.println("The best actor is: ");
        System.out.println(database.getBestActor());
        System.out.println("The best movie is: ");
        System.out.println(database.getBestMovie());
    }
}
