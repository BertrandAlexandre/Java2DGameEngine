package fr.alexandrebertrand.j2dge.component;

import java.awt.Point;

/**
 * Component with graphic context
 * 
 * @author Alexandre Bertrand
 */
public abstract class GraphicComponent extends Component {

    /*
     * Methods
     */

    @Override
    public boolean isGraphic() {
        return true;
    }

    /**
     * Move the component
     * 
     * @param x Move on the x axis
     * @param y Move on the y axis
     */
    public abstract void move(int x, int y);

    /**
     * Move the component
     * 
     * @param movement Movement of the component
     */
    public abstract void move(Point movement);

    /**
     * Set a new component location
     * 
     * @param x New x location of the component
     * @param y New y location of the component
     */
    public abstract void setLocation(int x, int y);

    /**
     * Set a new component location
     * 
     * @param location New location of the component
     */
    public abstract void setLocation(Point location);

}
