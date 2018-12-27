package fr.alexandrebertrand.j2dge;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

/**
 * Struvture of any game object that can be instantiate into a scene
 * 
 * @author Alexandre Bertrand
 */
public abstract class ObjectBehaviour extends JPanel {
    
    /*
     * Attributes
     */
    
    /** Position of the object */
    protected Point position;
    
    /** Dimension of the object */
    protected Dimension dimension;
    
    /** Scale of the object */
    protected Dimension scale;
    
    /** Rotation of the object */
    protected double rotation;
    
    /** Colliders of the object */
    private final Map<Collider, Class> colliders;
    
    /*
     * Constructors
     */
    
    /**
     * Construct a new object
     */
    public ObjectBehaviour() {
        position = new Point(0, 0);
        dimension = new Dimension(10, 10);
        scale = new Dimension(1, 1);
        rotation = 0d;
        colliders = new HashMap<>();
        start();
    }
    
    /*
     * Methods
     */
    
    /**
     * Object management at creation of the object
     */
    public void start() {
    }
    
    /**
     * Object management at update of the object
     */
    public void update() {
    }
    
    /**
     * Repaint the object
     * 
     * @param g2d Graphic context
     */
    public void paint(Graphics2D g2d) {
    }
    
    /**
     * Object management at start of new collision
     * 
     * @param colliders Colliders that collide this object
     */
    public void onCollisionEntry(List<Collider> colliders) {
    }
    
    /**
     * Object management for a collision
     * 
     * @param colliders Colliders that collide this object
     */
    public void onCollisionStay(List<Collider> colliders) {
    }
    
    /**
     * Object management at end of a collision
     * 
     * @param colliders Colliders that collide this object
     */
    public void onCollisionExit(List<Collider> colliders) {
    }
    
    /**
     * Add a box collider to the object
     * 
     * @param dimension Dimensions of the collider
     */
    public void addBoxCollider(Dimension dimension) {
        Rectangle r = new Rectangle(dimension);
        colliders.put(new Collider(r, this), r.getClass());
    }
    
    /**
     * Add a box collider to the object with initial position
     * 
     * @param position  Position of the collider
     * @param dimension Dimensions of the collider
     */
    public void addBoxCollider(Point position, Dimension dimension) {
        Rectangle r = new Rectangle(position, dimension);
        colliders.put(new Collider(r, this), r.getClass());
    }
    
    /**
     * Add a circle collider to the object
     * 
     * @param size Size of the collider
     */
    public void addCircleCollider(Double size) {
        Ellipse2D.Double e = new Ellipse2D.Double(0, 0, size, size);
        colliders.put(new Collider(e, this), e.getClass());
    }
    
    /**
     * Add a circle collider to the object with initial position
     * 
     * @param position Position of the collider
     * @param size     Size of the collider
     */
    public void addCircleCollider(Point position, Double size) {
        Ellipse2D.Double e = new Ellipse2D.Double(position.x, position.y, size, size);
        colliders.put(new Collider(e, this), e.getClass());
    }
    
    /**
     * Add a polygon collider to the object
     * 
     * @param points Points of the polygon
     */
    public void addPolygonCollider(List<Point> points) {
        int[] x = new int[points.size()];
        int[] y = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            x[i] = points.get(i).x;
            y[i] = points.get(i).y;
        }
        Polygon p = new Polygon(x, y, points.size());
        colliders.put(new Collider(p, this), p.getClass());
    }
    
    /*
     * Getters & Setters
     */

    /**
     * Get position of the object
     * 
     * @return Position of the object
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Get dimension of the object
     * 
     * @return Dimension of the object
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * Get scale of the object
     * 
     * @return Scale of the object
     */
    public Dimension getScale() {
        return scale;
    }

    /**
     * Get rotation of the object
     * 
     * @return Rotation of the object
     */
    public double getRotation() {
        return rotation;
    }

    /**
     * Get colliders of the object
     * 
     * @return Colliders of the object
     */
    public Map<Collider, Class> getColliders() {
        return colliders;
    }
    
}
