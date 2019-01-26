package fr.alexandrebertrand.j2dge.component;

/**
 * Component of a game object
 * 
 * @author Alexandre Bertrand
 */
public abstract class Component {

    /*
     * Methods
     */

    /**
     * Indicate if component is a collider component
     * 
     * @return true if component is a collider component,
     *         else false
     */
    public boolean isCollider() {
        return false;
    }

    /**
     * Indicate if component is graphic
     * 
     * @return true if component is graphic,
     *         else false
     */
    public boolean isGraphic() {
        return false;
    }

    /**
     * Indicate if component is a graphic renderer
     * 
     * @return true if component is a graphic renderer,
     *         else false
     */
    public boolean isGraphicRenderer() {
        return false;
    }

}
