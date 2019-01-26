package fr.alexandrebertrand.game.component.graphic.renderer;

import fr.alexandrebertrand.game.component.graphic.renderer.GraphicRenderingComponent;
import fr.alexandrebertrand.game.GameBehaviour;
import fr.alexandrebertrand.game.GameObject;
import fr.alexandrebertrand.game.location.Location;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

/**
 * Render a shape
 * 
 * @author Alexandre Bertrand
 */
public class ShapeRenderer extends GraphicRenderingComponent {

    /*
     * Attributes
     */

    /** Color of the shape */
    private Color color;

    /** Shape to render */
    private Shape shape;

    /** Point reference of the shape */
    private int refPoint;

    /*
     * Constructors
     */

    /**
     * Initialize a shape renderer with default color and reference point
     * 
     * @param shape  Shape to render
     * @param parent Parent game object of the component
     */
    public ShapeRenderer(Shape shape, GameObject parent) {
        super(parent);
        this.shape = shape;
        this.refPoint = 0;
        Point p = parent.getTransform().getLocation();
        move(p.x, p.y);
        this.color = GameBehaviour.getCurrentScene().getDefaultObjectColor();
    }

    /**
     * Initialize a shape renderer with specified color and default reference point
     * 
     * @param shape  Shape to render
     * @param color  Preferized color of the shape
     * @param parent Parent game object of the component
     */
    public ShapeRenderer(Shape shape, Color color, GameObject parent) {
        super(parent);
        this.shape = shape;
        this.refPoint = 0;
        Point p = parent.getTransform().getLocation();
        move(p.x, p.y);
        this.color = color;
    }

    /**
     * Initialize a shape renderer with default color and specified reference point
     * 
     * @param shape    Shape to render
     * @param refPoint Preferized point reference
     * @param parent   Parent game object of the component
     */
    public ShapeRenderer(Shape shape, int refPoint, GameObject parent) {
        super(parent);
        this.shape = shape;
        this.refPoint = refPoint;
        Point p = parent.getTransform().getLocation();
        move(p.x, p.y);
        this.color = GameBehaviour.getCurrentScene().getDefaultObjectColor();
    }

    /**
     * Initialize a shape renderer with specified color and reference point
     * 
     * @param shape    Shape to render
     * @param color    Preferized color of the shape
     * @param refPoint Preferized point reference
     * @param parent   Parent game object of the component
     */
    public ShapeRenderer(Shape shape, Color color, int refPoint, GameObject parent) {
        super(parent);
        this.shape = shape;
        this.refPoint = refPoint;
        Point p = parent.getTransform().getLocation();
        move(p.x, p.y);
        this.color = color;
    }

    /*
     * Methods
     */

    @Override
    public final void paint(Graphics2D g2d) {
        g2d.setColor(color);
        if (shape.getClass() == Rectangle.class) {
            Rectangle s = (Rectangle) shape;
            g2d.fillRect(s.x, s.y, s.width, s.height);
        }
        if (shape.getClass() == Ellipse2D.Double.class) {
            Ellipse2D.Double s = (Ellipse2D.Double) shape;
            g2d.fillOval((int) s.x, (int) s.y, (int) s.width, (int) s.height);
        }
        if (shape.getClass() == Arc2D.Double.class) {
            Arc2D.Double s = (Arc2D.Double) shape;
            g2d.fillArc((int) s.x, (int) s.y, (int) s.width,
                    (int) s.height, (int) s.start, (int) s.extent);
        }
        if (shape.getClass() == Polygon.class) {
            g2d.fillPolygon((Polygon) shape);
        }
    }

    @Override
    public final void move(int x, int y) {
        move(new Point(x, y));
    }

    @Override
    public final void move(Point movement) {
        if (shape.getClass() == Rectangle.class) {
            Rectangle s = (Rectangle) shape;
            s.setLocation(Location.add(s.getLocation(), movement));
            shape = s;
        }
        if (shape.getClass() == Ellipse2D.Double.class) {
            Ellipse2D.Double s = (Ellipse2D.Double) shape;
            s.x += movement.x;
            s.y += movement.y;
            shape = s;
        }
        if (shape.getClass() == Arc2D.Double.class) {
            Arc2D.Double s = (Arc2D.Double) shape;
            s.x += movement.x;
            s.y += movement.y;
            shape = s;
        }
        if (shape.getClass() == Polygon.class) {
            Polygon s = (Polygon) shape;
            for(int i = 0; i < s.npoints; i++) {
                s.xpoints[i] += movement.x;
                s.ypoints[i] += movement.y;
            }
            shape = s;
        }
    }

    @Override
    public final void setLocation(int x, int y) {
        setLocation(new Point(x, y));
    }

    @Override
    public final void setLocation(Point location) {
        if (shape.getClass() == Rectangle.class) {
            Rectangle s = (Rectangle) shape;
            s.setLocation(location);
            shape = s;
        }
        if (shape.getClass() == Ellipse2D.Double.class) {
            Ellipse2D.Double s = (Ellipse2D.Double) shape;
            s.x = location.x;
            s.y = location.y;
            shape = s;
        }
        if (shape.getClass() == Arc2D.Double.class) {
            Arc2D.Double s = (Arc2D.Double) shape;
            s.x = location.x;
            s.y = location.y;
            shape = s;
        }
        if (shape.getClass() == Polygon.class) {
            Polygon s = (Polygon) shape;
            if (refPoint < 0 && s.npoints <= refPoint)
                refPoint = 0;
            int refx = location.x - s.xpoints[refPoint];
            int refy = location.y - s.ypoints[refPoint];
            for (int i = 0; i < s.npoints; i++) {
                s.xpoints[i] += refx;
                s.ypoints[i] += refy;
            }
            shape = s;
        }
    }

    /*
     * Getters & Setters
     */

    /**
     * Get dimension of the shape to render
     * 
     * @return Dimension of the shape
     */
    public final Dimension getDimension() {
        Rectangle bounds = shape.getBounds();
        return new Dimension(bounds.width, bounds.height);
    }

    /**
     * Get location of the shape to render
     * 
     * @return Location of the shape
     */
    public final Point getLocation() {
        Rectangle bounds = shape.getBounds();
        return new Point(bounds.x, bounds.y);
    }

    /**
     * Get color of the shape
     * 
     * @return Color of the shape
     */
    public final Color getColor() {
        return color;
    }

    /**
     * Set the color of the shape
     * 
     * @param color New color of the shape
     */
    public final void setColor(Color color) {
        this.color = color;
    }

    /**
     * Get shape to render
     * 
     * @return Shape of the renderer
     */
    public final Shape getShape() {
        return shape;
    }

    /**
     * Set shape to render
     * 
     * @param shape New shape to render
     */
    public final void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Get reference point of the shape
     * 
     * @return Reference point of the shape
     */
    public final int getRefPoint() {
        return refPoint;
    }

    /**
     * Set reference point of the shape
     * 
     * @param refPoint New reference point of the shape
     */
    public final void setRefPoint(int refPoint) {
        this.refPoint = refPoint;
    }

}
