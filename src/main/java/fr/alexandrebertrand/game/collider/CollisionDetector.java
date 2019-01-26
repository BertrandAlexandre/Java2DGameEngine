package fr.alexandrebertrand.game.collider;

import fr.alexandrebertrand.game.GameBehaviour;
import java.awt.geom.Area;

/**
 * Update collisions status between colliders
 * 
 * @author Alexandre Bertrand
 */
public class CollisionDetector {

    /*
     * Methods
     */

    /**
     * Add a new collider to other colliders
     * and add other colliders to the new collider
     * 
     * @param collider Collider to add to other colliders
     */
    public void addCollider(Collider collider) {
        GameBehaviour.getCurrentScene().getAllObjects().forEach(o -> {
            o.getColliders().forEach(c -> {
                if (c != collider) {
                    collider.initColision(c);
                    c.initColision(collider);
                }
            });
        });
    }

    /**
     * Update collisions between colliders
     */
    public void updateCollisions() {
        GameBehaviour.getCurrentScene().getAllObjects().forEach(o -> {
            o.getColliders().forEach(c -> c.updatePrevCollisions());
        });
        GameBehaviour.getCurrentScene().getAllObjects().forEach(o -> {
            o.getColliders().forEach(c -> {
                Area a = new Area(c.getShape());
                c.getNewCollisons().forEach((c2, v) -> {
                    if (c.getGameObject() != c2.getGameObject()) {
                        Area b = new Area(c2.getShape());
                        b.intersect(a);
                        c.updateCollision(c2, !b.isEmpty());
                    }
                });
            });
        });
    }

}
