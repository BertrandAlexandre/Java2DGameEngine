package fr.alexandrebertrand.game.component.graphic.collider;

import fr.alexandrebertrand.game.collider.Collider;
import fr.alexandrebertrand.game.GameObject;
import fr.alexandrebertrand.game.component.Component;
import fr.alexandrebertrand.game.component.graphic.GraphicComponent;
import java.awt.Shape;
import java.util.stream.Collectors;

/**
 * Component containing collider
 * 
 * @author Alexandre Bertrand
 */
public abstract class ColliderComponent extends GraphicComponent {

    /*
     * Attributes
     */

    /** Collider of the component */
    protected final Collider collider;

    /*
     * Constructors
     */

    /**
     * Create a collider component from shape an game object
     * 
     * @param shape  Shape of the collider
     * @param parent Parent game object ofthe collider
     */
    public ColliderComponent(Shape shape, GameObject parent) {
        this.collider = new Collider(shape, parent);
    }

    /*
     * Methods
     */

    /**
     * Get collider of the component
     * 
     * @return Collider of the component
     */
    public Collider getCollider() {
        return this.collider;
    }

    @Override
    public boolean isCollider() {
        return true;
    }

    /**
     * Check if parent game object have at least one component of specified component class
     * 
     * @param parent         Parent game object
     * @param componentClass Component class to search components
     * @return true if parent contains component with specified class,
     *         else false
     */
    protected final boolean asComponentClass(GameObject parent, Class componentClass) {
        return parent.getAllComponents().stream().anyMatch(c -> c.getClass().equals(componentClass));
    }

    /**
     * Get parent game object component corresponding to a specifoed class
     * 
     * @param parent         Parent game object
     * @param componentClass Component class to get components
     * @return Searched components from parent
     */
    protected final Component getComponentByClass(GameObject parent, Class componentClass) {
        return parent.getAllComponents().stream()
                .filter(c -> c.getClass().equals(componentClass))
                .collect(Collectors.toList()).get(0);
    }

}
