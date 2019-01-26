package fr.alexandrebertrand.game.component.graphic.collider;

import fr.alexandrebertrand.game.GameObject;
import fr.alexandrebertrand.game.component.graphic.renderer.ShapeRenderer;
import fr.alexandrebertrand.game.component.graphic.renderer.SpriteRenderer;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * Collider with ellipse shape
 * 
 * @author Alexandre Bertrand
 */
public class OvalCollider extends ColliderComponent {

    /*
     * Constructors
     */

    /**
     * Create an oval collider from parent
     * 
     * @param parent Parent of the collider
     */
    public OvalCollider(GameObject parent) {
        super(new Ellipse2D.Double(), parent);
        Ellipse2D.Double r = (Ellipse2D.Double) collider.getShape();
        if (asComponentClass(parent, SpriteRenderer.class)) {
            SpriteRenderer s = (SpriteRenderer) getComponentByClass(parent, SpriteRenderer.class);
            r.x = s.getLocation().x;
            r.y = s.getLocation().y;
            Dimension dim = s.getDimension();
            r.width = dim.width;
            r.height = dim.height;
            collider.setShape(r);
        } else if (asComponentClass(parent, ShapeRenderer.class)) {
            ShapeRenderer s = (ShapeRenderer) getComponentByClass(parent, ShapeRenderer.class);
            Point pos = s.getLocation();
            r.x = pos.x;
            r.y = pos.y;
            Dimension dim = s.getDimension();
            r.width = dim.width;
            r.height = dim.height;
            collider.setShape(r);
        }
    }

    /**
     * Create an oval collider with dimension
     * 
     * @param dimension Dimension of the oval collider
     * @param parent    Parent of the collider
     */
    public OvalCollider(Dimension dimension, GameObject parent) {
        super(new Ellipse2D.Double(parent.getTransform().getLocation().x,
                parent.getTransform().getLocation().y,
                dimension.width, dimension.height), parent);
    }

    /**
     * Create an oval collider with location and dimension
     * 
     * @param location  Location of the oval collider
     * @param dimension Dimension of the oval collider
     * @param parent    Parent of the collider
     */
    public OvalCollider(Point location, Dimension dimension, GameObject parent) {
        super(new Ellipse2D.Double(parent.getTransform().getLocation().x + location.x,
                parent.getTransform().getLocation().y + location.y,
                dimension.width,dimension.height), parent);
    }

    /*
     * Methods
     */

    @Override
    public final void move(int x, int y) {
        Ellipse2D.Double e = (Ellipse2D.Double) collider.getShape();
        e.x += x;
        e.y += y;
        collider.setShape(e);
    }

    @Override
    public final void move(Point movement) {
        move(movement.x, movement.y);
    }

    @Override
    public final void setLocation(int x, int y) {
        Ellipse2D.Double e = (Ellipse2D.Double) collider.getShape();
        e.x = x;
        e.y = y;
        collider.setShape(e);
    }

    @Override
    public final void setLocation(Point location) {
        setLocation(location.x, location.y);
    }

}
