package fr.alexandrebertrand.j2dge.graphic.util;

import java.awt.Point;

/**
 * Zone defined by min and max locations
 * 
 * @author Alexandre Bertrand
 */
public class Zone {

    /*
     * Attributes
     */

    /** Min x axis location */
    private int minX;

    /** Max x axis location */
    private int maxX;

    /** Min y axis location */
    private int minY;

    /** Max y axis location */
    private int maxY;

    /*
     * Constructors
     */

    /**
     * Initilize a zone with max dimensions
     */
    public Zone() {
        this.minX = this.minY = Integer.MIN_VALUE;
        this.maxX = this.maxY = Integer.MAX_VALUE;
    }

    /**
     * Initilize a zone with specified locations
     * 
     * @param min Min location value of the zone
     * @param max Max location value of the zone
     */
    public Zone(int min, int max) {
        this.minX = this.minY = min;
        this.maxX = this.maxY = max;
    }

    /**
     * Initilize a zone with specified locations
     * 
     * @param minX Min x axis location of the zone
     * @param maxX Max x axis location of the zone
     * @param minY Min y axis location of the zone
     * @param maxY Max y axis location of the zone
     */
    public Zone(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    /**
     * Initilize a zone with specified locations
     * 
     * @param min Min location point of the zone
     * @param max Max location point of the zone
     */
    public Zone(Point min, Point max) {
        this.minX = min.x;
        this.maxX = max.x;
        this.minY = min.y;
        this.maxY = max.y;
    }

    /*
     * Getters & Setters
     */

    /**
     * Get min x axis location
     * 
     * @return Min x axis location
     */
    public int getMinX() {
        return minX;
    }

    /**
     * Set min x axis location
     * 
     * @param minX New min x axis location
     */
    public void setMinX(int minX) {
        this.minX = minX;
    }

    /**
     * Get max x axis location
     * 
     * @return Max x axis location
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Set max x axis location
     * 
     * @param maxX New max x axis location
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    /**
     * Get min y axis location
     * 
     * @return Min y axis location
     */
    public int getMinY() {
        return minY;
    }

    /**
     * Set min y axis location
     * 
     * @param minY New min y axis location
     */
    public void setMinY(int minY) {
        this.minY = minY;
    }

    /**
     * Get max y axis location
     * 
     * @return Max y axis location
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Set max y axis location
     * 
     * @param maxY New max y axis location
     */
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    /**
     * Get min location of the zone
     * 
     * @return Min location of the zone
     */
    public Point getMin() {
        return new Point(this.minX, this.minY);
    }

    /**
     * Set min location of the zone
     * 
     * @param min New min location point of the zone
     */
    public void setMin(Point min) {
        this.minX = min.x;
        this.minY = min.y;
    }

    /**
     * Set min location of the zone
     * 
     * @param min New min location value of the zone
     */
    public void setMin(int min) {
        this.minX = min;
        this.minY = min;
    }

    /**
     * Set min location of the zone
     * 
     * @param minX New min x axis location of the zone
     * @param minY New min y axis location of the zone
     */
    public void setMin(int minX, int minY) {
        this.minX = minX;
        this.minY = minY;
    }

    /**
     * Get max location of the zone
     * 
     * @return Max location of the zone
     */
    public Point getMax() {
        return new Point(this.maxX, this.maxY);
    }

    /**
     * Set max location of the zone
     * 
     * @param max New max location point of the zone
     */
    public void setMax(Point max) {
        this.maxX = max.x;
        this.maxY = max.y;
    }

    /**
     * Set max location of the zone
     * 
     * @param max New max location value of the zone
     */
    public void setMax(int max) {
        this.maxX = max;
        this.maxY = max;
    }

    /**
     * Set max location of the zone
     * 
     * @param maxX New max x axis location of the zone
     * @param maxY New max y axis location of the zone
     */
    public void setMax(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

}
