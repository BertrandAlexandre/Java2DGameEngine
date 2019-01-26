
package fr.alexandrebertrand.game.util;

import fr.alexandrebertrand.game.GameBehaviour;
import fr.alexandrebertrand.game.GameObject;

/**
 * Utility class to instancate game object copies
 * 
 * @author Alexandre Bertrand
 */
public class Instanciate {

    /*
     * Constructors
     */

    /**
     * Initialize a new game object from another
     * 
     * @param gameObject Existing object you want to copy
     */
    public void Instanciate(GameObject gameObject) {
        GameObject o = initialize(gameObject);
        if (o != null) {
            o.setTransform(new Transform());
            GameBehaviour.getCurrentScene().addGameObject(o);
        }
    }

    /**
     * Initialize a new game object from another with new parent
     * 
     * @param gameObject Existing object you want to copy
     * @param parent     Parent obejct of the new one
     */
    public void Instanciate(GameObject gameObject, GameObject parent) {
        GameObject o = initialize(gameObject);
        if (o != null) {
            o.setTransform(new Transform());
            parent.addGameObject(o);
        }
    }

    /**
     * Initialize a new game object from another with new transform component
     * 
     * @param gameObject Existing object you want to copy
     * @param transform  Transform component of the new object
     */
    public void Instanciate(GameObject gameObject, Transform transform) {
        GameObject o = initialize(gameObject);
        if (o != null) {
            o.setTransform(new Transform(transform));
            GameBehaviour.getCurrentScene().addGameObject(o);
        }
    }

    /**
     * Initialize a new game object from another with new parent and transform component
     * 
     * @param gameObject Existing object you want to copy
     * @param transform  Transform component of the new object
     * @param parent     Parent obejct of the new one
     */
    public void Instanciate(GameObject gameObject, Transform transform, GameObject parent) {
        GameObject o = initialize(gameObject);
        if (o != null) {
            o.setTransform(new Transform(transform));
            parent.addGameObject(o);
        }
    }

    /*
     * Methods
     */

    /**
     * Initialize the new game object
     * 
     * @param gameObject Existing object you want to copy
     * @return The new object created
     */
    private GameObject initialize(GameObject gameObject) {
        GameObject o = null;
        try {
            o = gameObject.getClass().newInstance(); // TODO see Cloneable
            o.setName(o.getName() + " (copy)");
        } catch (InstantiationException | IllegalAccessException ex) {
            System.err.println(ex.getMessage());
        }
        return o;
    }

}
