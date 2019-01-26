package fr.alexandrebertrand.game.component.graphic.collider;

import fr.alexandrebertrand.game.GameObject;
import fr.alexandrebertrand.game.location.Location;
import fr.alexandrebertrand.game.component.graphic.renderer.ShapeRenderer;
import fr.alexandrebertrand.game.component.graphic.renderer.SpriteRenderer;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Collider with rectangle shape
 * 
 * @author Alexandre Bertrand
 */
public class BoxCollider extends ColliderComponent {

    /*
     * Constructors
     */

    /**
     * Create a box collider from parent
     * 
     * @param parent Parent of the collider
     */
    public BoxCollider(GameObject parent) {
        super(new Rectangle(), parent);
        Rectangle r = (Rectangle) collider.getShape();
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
     * Create a box collider with dimension
     * 
     * @param dimension Dimension of the box collider
     * @param parent    Parent of the collider
     */
    public BoxCollider(Dimension dimension, GameObject parent) {
        super(new Rectangle(parent.getTransform().getLocation(), dimension),
                parent);
    }

    /**
     * Create a box collider with location and dimension
     * 
     * @param location  Location of the box collider
     * @param dimension Dimension of the box collider
     * @param parent    Parent of the collider
     */
    public BoxCollider(Point location, Dimension dimension, GameObject parent) {
        super(new Rectangle(Location.add(parent.getTransform().getLocation(), location), dimension),
                parent);
    }

    /*
     * Methods
     */

    @Override
    public final void move(int x, int y) {
        move(new Point(x, y));
    }

    @Override
    public final void move(Point movement) {
        Rectangle r = (Rectangle) collider.getShape();
        r.setLocation(Location.add(r.getLocation(), movement));
        collider.setShape(r);
    }

    @Override
    public final void setLocation(int x, int y) {
        setLocation(new Point(x, y));
    }

    @Override
    public final void setLocation(Point location) {
        Rectangle r = (Rectangle) collider.getShape();
        r.setLocation(location);
        collider.setShape(r);
    }

}
