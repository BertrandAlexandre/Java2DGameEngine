package fr.alexandrebertrand.game.util;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Graphic information store of an object
 * 
 * @author Alexandre Bertrand
 */
public class Transform {

    /*
     * Attributes
     */

    /** Location of the object */
    protected Point location;

    /** Dimension of the object */
    protected Dimension dimension;

    /** Rotation of the object */
    protected double rotation;

    /*
     * Constructors
     */

    /**
     * Initialize a new Transform component
     */
    public Transform() {
        this.location = new Point(0, 0);
        this.dimension = new Dimension(1, 1);
        this.rotation = 0d;
    }

    /**
     * Initialize a new transform component with another
     * 
     * @param other Other transform used to create this one
     */
    public Transform(Transform other) {
        this.location = other.location;
        this.dimension = other.dimension;
        this.rotation = other.rotation;
    }

    /**
     * Initialize a new Transform component with values
     * 
     * @param location  Location of the object
     * @param dimension Dimension of the object
     * @param rotation  Rotation of the object
     */
    public Transform(Point location, Dimension dimension, double rotation) {
        this.location = location;
        this.dimension = dimension;
        this.rotation = rotation;
    }

    /*
     * Getters & Setters
     */

    /**
     * Get location of the object
     * 
     * @return Location of the object
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Set location of the object
     * 
     * @param location New location of the obejct
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * Get dimension of the object
     * 
     * @return Dimension of the object
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * Set dimension of the object
     * 
     * @param dimension New dimension of the obejct
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Get rotation of the object
     * 
     * @return Rotation of the object
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * Set rotation of the object
     * 
     * @param rotation New rotation of the obejct
     */
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

}
