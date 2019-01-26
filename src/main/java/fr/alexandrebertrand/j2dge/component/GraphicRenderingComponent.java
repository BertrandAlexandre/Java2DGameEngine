package fr.alexandrebertrand.j2dge.component;

import fr.alexandrebertrand.j2dge.GameObject;
import java.awt.Graphics2D;

/**
 * Component with graphic context and rendering
 * 
 * @author Alexandre Bertrand
 */
public abstract class GraphicRenderingComponent extends GraphicComponent {

    /*
     * Attributes
     */

    /**¨Parent game object of the graphic rendering component */
    protected GameObject parent;

    /*
     * Constructors
     */

    /**
     * Create a graphic rendering component from a parent game object
     * 
     * @param parent Parent game object of the component
     */
    public GraphicRenderingComponent(GameObject parent) {
        this.parent = parent;
    }

    /*
     * Methods
     */

    /**
     * Repaint the component
     * 
     * @param g2d Graphic context
     */
    public abstract void paint(Graphics2D g2d);

    @Override
    public boolean isGraphicRenderer() {
        return true;
    }

}
