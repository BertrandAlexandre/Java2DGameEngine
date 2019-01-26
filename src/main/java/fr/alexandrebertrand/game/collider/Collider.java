package fr.alexandrebertrand.game.collider;

import fr.alexandrebertrand.game.GameBehaviour;
import fr.alexandrebertrand.game.GameObject;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
    private Shape shape;

    /** Parent game object of the collider */
    private final GameObject gameObject;

    /** Collisions at the previous frame */
    private Map<Collider, Boolean> prevCollisons;

    /** Collisions at current frame */
    private final Map<Collider, Boolean> newCollisons;

    /*
     * Constructors
     */

    /**
     * Instanciate a new collider and initialize collisions
     * 
     * @param shape      Shape of the collider
     * @param gameObject Parent game object of the collider
     */
    public Collider(Shape shape, GameObject gameObject) {
        this.shape = shape;
        this.gameObject = gameObject;
        prevCollisons = new ConcurrentHashMap<>();
        newCollisons = new ConcurrentHashMap<>();
        GameBehaviour.collisionDetector.addCollider(this);
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
        newCollisons.forEach((k, v) -> prevCollisons.put(k, v));
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
            if (prevCollisons.get(k) == before && v == after)
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
     * Set shape of the collider
     * 
     * @param shape New shape of the collider
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Get new collisions for update
     * 
     * @return New collisions
     */
    public Map<Collider, Boolean> getNewCollisons() {
        return newCollisons;
    }

    /**
     * Get parent game object of this collider
     * 
     * @return Parent game object
     */
    public GameObject getGameObject() {
        return gameObject;
    }

}
