package fr.alexandrebertrand.game.location;

import java.awt.Point;

/**
 * Object with location
 * 
 * @author Alexandre Bertrand
 */
public class LocateObject {

    /*
     * Attributes
     */

    /** Location of the object */
    protected Point location;

    /** Location restriction of the object */
    protected LocationRestriction locationRestriction;

    /*
     * Constructors
     */

    /**
     * Initialize an object to location (0, 0)
     */
    public LocateObject() {
        this.location = new Point();
    }

    /**
     * Initialize an object to a specified location
     * 
     * @param location Initial location of the object
     */
    public LocateObject(Point location) {
        this.location = location;
    }

    /*
     * Methods
     */

    /**
     * Move object using a movement
     * 
     * @param movement Movement of the object
     */
    public void move(Point movement) {
        location = Location.add(location, movement);
    }

    /**
     * Move object using a movement
     * 
     * @param x Movement of the object on x axis
     * @param y Movement of the object on y axis
     */
    public void move(int x, int y) {
        move(new Point(x, y));
    }

    /*
     * Getters & Setters
     */

    /**
     * Get current location of the object
     * 
     * @return Current lcoation of the object
     */
    public Point getLocation() {
        return this.location;
    }

    /**
     * Set new location of the object
     * 
     * @param location New location of the object
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * Set new location of the object
     * 
     * @param x New x coordinate of the object
     * @param y New y coordinate of the object
     */
    public void setLocation(int x, int y) {
        this.location = new Point(x, y);
    }

    /**
     * Get location restriction of the object
     * 
     * @return Location restriction of the object
     */
    public LocationRestriction getLocationRestriction() {
        return this.locationRestriction;
    }

    /**
     * Set location restriction of the object
     * 
     * @param locationRestriction New location restriction of the object
     */
    public void setLocationRestriction(LocationRestriction locationRestriction) {
        this.locationRestriction = locationRestriction;
    }

}
