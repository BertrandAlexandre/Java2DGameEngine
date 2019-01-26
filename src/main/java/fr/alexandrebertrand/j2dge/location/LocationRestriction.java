package fr.alexandrebertrand.j2dge.location;

import fr.alexandrebertrand.j2dge.graphic.util.Zone;

/**
 * Restrict a locate object
 * 
 * @author Alexandre Bertrand
 */
public class LocationRestriction {

    /*
     * Attributes
     */

    /** The locate object reference */
    private LocateObject parent;

    /** Restriction zone to move the object */
    private Zone zone;

    /*
     * Constructors
     */

    /**
     * Initialize a new restriction for an object
     * 
     * @param parent Restricted object
     */
    public LocationRestriction(LocateObject parent) {
        this.parent = parent;
        zone = new Zone();
    }

    /*
     * Methods
     */

    /**
     * Update location of the locate object if it doesn't respects restriction
     */
    public void updateLocation() {
        if (parent.location.x < zone.getMinX()) {
            parent.location.x = zone.getMinX();
        }
        if (zone.getMaxX() < parent.location.x) {
            parent.location.x = zone.getMaxX();
        }
        if (parent.location.y < zone.getMinY()) {
            parent.location.y = zone.getMinY();
        }
        if (zone.getMaxY() < parent.location.y) {
            parent.location.y = zone.getMaxY();
        }
    }

    /*
     * Getters & Setters
     */

    /**
     * Get the restriction zone
     * 
     * @return Restriction zone
     */
    public Zone getZone() {
        return this.zone;
    }

    /**
     * Set the restriction zone
     * 
     * @param zone New restriction zone
     */
    public void setZone(Zone zone) {
        this.zone = zone;
    }

}
