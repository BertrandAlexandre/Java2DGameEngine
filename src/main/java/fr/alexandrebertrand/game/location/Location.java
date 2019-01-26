package fr.alexandrebertrand.game.location;

import java.awt.Point;

/**
 * Utility class to transform locations with basic operations
 * 
 * @author Alexandre Bertrand
 */
public final class Location {

    /*
     * Constructors
     */

    /**
     * Private empty constructor to disable instanciation
     */
    private Location() {
    }

    /*
     * Methods
     */

    /**
     * Added two locations
     * 
     * @param a First location
     * @param b Second location
     * @return Created location
     */
    public static Point add(Point a, Point b) {
        return new Point(a.x + b.x, a.y + b.y);
    }

    /**
     * Subtract a location to another
     * 
     * @param a First location
     * @param b Second location (to subtract)
     * @return Created location
     */
    public static Point subtract(Point a, Point b) {
        return new Point(a.x - b.x, a.y - b.y);
    }

    /**
     * Multiply a location with a number
     * 
     * @param a Location to modify
     * @param m Multiplier
     * @return Created location
     */
    public static Point multiply(Point a, double m) {
        return new Point((int) (a.x * m), (int) (a.y * m));
    }

    /**
     * Divide a location by a number
     * 
     * @param a Location to modify
     * @param d Divider
     * @return Created location
     */
    public static Point divide(Point a, double d) {
        return new Point((int) (a.x / d), (int) (a.y / d));
    }

}
