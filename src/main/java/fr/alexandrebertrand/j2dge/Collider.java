package fr.alexandrebertrand.j2dge;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Collider of an object containing collisions with other colliders
 *
 * @author Alexandre Bertrand
 */
public class Collider {
    
    /*
     * Attributes
     */
    
    /** Shape of the collider */
    private final Shape shape;
    
    /** Parent object of the collider */
    private final ObjectBehaviour object;
    
    /** Collisions at the previous frame */
    private Map<Collider, Boolean> prevCollisons;
    
    /** Collisions at current frame */
    private final Map<Collider, Boolean> newCollisons;
    
    /*
     * Constructors
     */
    
    /**
     * Construct a new collider and initialise collisions
     * 
     * @param shape  Shape of the collider
     * @param object Parent object of the collider
     */
    public Collider(Shape shape, ObjectBehaviour object) {
        this.shape = shape;
        this.object = object;
        prevCollisons = new HashMap<>();
        newCollisons = new HashMap<>();
        GameBehaviour.getCurrentScene().getCollisionDetector().addCollider(this);
    }
    
    /*
     * Methods
     */
    
    /**
     * Initialize collision with another collider
     * 
     * @param collider Other collider
     */
    public void initColision(Collider collider) {
        prevCollisons.put(collider, false);
        newCollisons.put(collider, false);
    }
    
    /**
     * Update previous collisions
     */
    public void updatePrevCollisions() {
        prevCollisons = newCollisons;
    }
    
    /**
     * Update a collision status with another collider
     * 
     * @param collider Other collider
     * @param collide  Status of collision
     */
    public void updateCollision(Collider collider, boolean collide) {
        newCollisons.put(collider, collide);
    }
    
    /**
     * Search specific collisions
     * 
     * @param before Was there a collision at previous frame ?
     * @param after  Is there a collision at current frame ?
     * @return Finded colliders
     */
    public List<Collider> searchCollisions(boolean before, boolean after) {
        List<Collider> s = new ArrayList<>();
        newCollisons.forEach((k, v) -> {
            if (v == before && prevCollisons.get(k) == after)
                s.add(k);
        });
        return s;
    }
    
    /*
     * Getters & Setters
     */
    
    /**
     * Get the shape of the collider
     * 
     * @return Shape of the collider
     */
    public Shape getShape() {
        return shape;
    }
    
    /**
     * Get parent object of the collider
     * 
     * @return Parent object of the collider
     */
    public ObjectBehaviour getObject() {
        return object;
    }
    
    /**
     * Get new collisions for update
     * 
     * @return New collisions
     */
    public Map<Collider, Boolean> getNewCollisons() {
        return newCollisons;
    }
    
}
