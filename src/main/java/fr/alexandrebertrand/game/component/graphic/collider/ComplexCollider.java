package fr.alexandrebertrand.game.component.graphic.collider;

import fr.alexandrebertrand.game.GameObject;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.List;

/**
 * Collider with complex shape
 * 
 * @author Alexandre Bertrand
 */
public class ComplexCollider extends ColliderComponent {

    /*
     * Attributes
     */

    /** Point reference of the shape */
    private int refPoint;

    /*
     * Constructors
     */

    /**
     * Create a complex collider
     * 
     * @param shape  Shape of the complex collider
     * @param parent Parent of the collider
     */
    public ComplexCollider(Shape shape, GameObject parent) {
        super(shape, parent);
        this.refPoint = 0;
    }

    /**
     * Create a complex collider with point reference
     * 
     * @param shape    Shape of the complex collider
     * @param refPoint Point reference of the shape
     * @param parent   Parent of the collider
     */
    public ComplexCollider(Shape shape, int refPoint, GameObject parent) {
        super(shape, parent);
        this.refPoint = refPoint;
    }

    /*
     * Methods
     */

    /**
     * Get shape from points
     * 
     * @param points Points of the shape
     * @param parent Parent of the collider
     * @return Created shape from points
     */
    public final static Shape pointsToShape(List<Point> points, GameObject parent) {
        int[] x = new int[points.size()];
        int[] y = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            x[i] = parent.getTransform().getLocation().x + points.get(i).x ;
            y[i] = parent.getTransform().getLocation().y + points.get(i).y;
        }
        return new Polygon(x, y, points.size());
    }

    @Override
    public final void move(int x, int y) {
        Polygon p = (Polygon) collider.getShape();
        for (int i = 0; i < p.npoints; i++) {
            p.xpoints[i] += x;
            p.ypoints[i] += y;
        }
        collider.setShape(p);
    }

    @Override
    public final void move(Point movement) {
        move(movement.x, movement.y);
    }

    @Override
    public final void setLocation(int x, int y) {
        Polygon p = (Polygon) collider.getShape();
        if (refPoint < 0 && p.npoints <= refPoint) {
            refPoint = 0;
        }
        int refx = x - p.xpoints[refPoint];
        int refy = y - p.ypoints[refPoint];
        for (int i = 0; i < p.npoints; i++) {
            p.xpoints[i] += refx;
            p.ypoints[i] += refy;
        }
        collider.setShape(p);
    }

    @Override
    public final void setLocation(Point location) {
        setLocation(location.x, location.y);
    }

}
