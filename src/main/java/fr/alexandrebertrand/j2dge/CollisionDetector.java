package fr.alexandrebertrand.j2dge;

import java.awt.geom.Area;

/**
 * Update collisions status between colliders
 *
 * @author Alexandre Bertrand
 */
class CollisionDetector {
    
    /**
     * Add a new collider to other colliders
     * and add other colliders to the new collider
     * 
     * @param collider Collider to add to other colliders
     */
    void addCollider(Collider collider) {
        SceneBehaviour s = GameBehaviour.getCurrentScene();
        s.objects.forEach(o -> {
            o.getColliders().forEach((k, v) -> {
                if (k != collider) {
                    collider.initColision(k);
                    k.initColision(collider);
                }
            });
        });
    }
    
    /**
     * Update collisions between colliders
     */
    void updateCollisions() {
        SceneBehaviour s = GameBehaviour.getCurrentScene();
        s.objects.forEach(o -> {
            o.getColliders().forEach((k, v) -> {
                k.updatePrevCollisions();
                Area a = (Area) k.getShape();
                k.getNewCollisons().forEach((k2, v2) -> {
                    if (k.getObject() != k2.getObject()) {
                        Area b = (Area) k2.getShape();
                        b.intersect(a);
                        k.updateCollision(k2, !b.isEmpty());
                    }
                });
            });
        });
    }
    
}
