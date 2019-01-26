package fr.alexandrebertrand.game;

import fr.alexandrebertrand.game.util.Transform;
import fr.alexandrebertrand.game.collider.Collider;
import fr.alexandrebertrand.game.location.Location;
import fr.alexandrebertrand.game.component.Component;
import fr.alexandrebertrand.game.component.graphic.GraphicComponent;
import fr.alexandrebertrand.game.component.graphic.renderer.GraphicRenderingComponent;
import fr.alexandrebertrand.game.component.graphic.collider.ColliderComponent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import javax.swing.JPanel;

/**
 * Structure of any game object that can be instantiate into a scene
 * 
 * @author Alexandre Bertrand
 */
public abstract class GameObject extends JPanel {

    /*
     * Attributes
     */

    /** Graphic informations of the object */
    protected Transform transform;

    /** Parent object */
    protected GameObject parent;

    /** Children game objects */
    private final List<GameObject> children;

    /** Components of the Game Object */
    private final List<Component> components;

    /*
     * Constructors
     */

    /**
     * Construct a new object
     */
    public GameObject() {
        transform = new Transform(new Point(0, 0), new Dimension(10, 10), 0d);
        children = new CopyOnWriteArrayList<>();
        components = new CopyOnWriteArrayList<>();
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
     * Do game object upate
     */
    void doUpdate() {
        update();
        children.forEach(o -> o.doUpdate());
    }

    /**
     * Do game object repaint
     * 
     * @param g2d Graphic context
     */
    void doPaint(Graphics2D g2d) {
        paintRenderers(g2d);
        paint(g2d);
        children.forEach(o -> o.doPaint(g2d));
    }

    /**
     * Repaint renderers
     * 
     * @param g2d Graphic context
     */
    private void paintRenderers(Graphics2D g2d) {
        getRenderers().forEach(r -> r.paint(g2d));
    }

    /**
     * Check collisions of current object
     */
    void checkCollisions() {
        getColliders().forEach(c -> {
            List<Collider> entry = c.searchCollisions(false, true);
            List<Collider> stay = c.searchCollisions(true, true);
            List<Collider> exit = c.searchCollisions(true, false);

            if (entry.size() > 0)
                onCollisionEntry(entry);
            if (stay.size() > 0)
                onCollisionStay(stay);
            if (exit.size() > 0)
                onCollisionExit(exit);
        });
        children.forEach(o -> o.checkCollisions());
    }

    @Override
    public final void move(int x, int y) {
        move(new Point(x, y));
    }

    /**
     * Move current object
     * 
     * @param movement Movement of the object
     */
    public final void move(Point movement) {
        transform.setLocation(Location.add(movement, transform.getLocation()));
        components.stream().filter(c -> c.isGraphic())
                .forEach(c -> ((GraphicComponent) c).move(movement));
        children.forEach(g -> g.move(movement));
    }

    /**
     * Move current object without moving children objects
     * 
     * @param x Movement on x axis
     * @param y Movement on y axis
     */
    public final void moveWithoutChildren(int x, int y) {
        moveWithoutChildren(new Point(x, y));
    }

    /**
     * Move current object without moving children objects
     * 
     * @param movement Movement of the object
     */
    public final void moveWithoutChildren(Point movement) {
        transform.setLocation(Location.add(movement, transform.getLocation()));
        components.stream().filter(c -> c.isGraphic())
                .forEach(c -> ((GraphicComponent) c).move(movement));
    }

    @Override
    public final void setLocation(int x, int y) {
        setLocation(new Point(x, y));
    }

    @Override
    public final void setLocation(Point location) {
        Point movement = Location.subtract(location, transform.getLocation());
        transform.setLocation(location);
        children.forEach(g -> g.move(movement));
        components.stream().filter(c -> c.isGraphic())
                .forEach(c -> ((GraphicComponent) c).move(movement));
    }

    /**
     * Set loation of current object without moving children objects
     * 
     * @param x New location on x axis
     * @param y New location on y axis
     */
    public final void setLocationWithoutChildren(int x, int y) {
        setLocationWithoutChildren(new Point(x, y));
    }

    /**
     * Set loation of current object without moving children objects
     * 
     * @param location New location of the object
     */
    public final void setLocationWithoutChildren(Point location) {
        Point movement = Location.subtract(location, transform.getLocation());
        transform.setLocation(location);
        components.stream().filter(c -> c.isGraphic())
                .forEach(c -> ((GraphicComponent) c).move(movement));
    }

    /**
     * Add game object under current game object
     * 
     * @param child Child to add
     */
    public final void addGameObject(GameObject child) {
        child.setParent(this);
        children.add(child);
    }

    /**
     * Remove child game object
     * 
     * @param child Child game object to remove
     */
    public final void removeGameObject(GameObject child) {
        children.remove(child);
    }

    /*
     * Getters & Setters
     */

    /**
     * Get colliders of the object
     * 
     * @return Colliders of the object
     */
    public final List<Collider> getColliders() {
        return components.stream()
                .filter(c -> c.isCollider())
                .map(c -> ((ColliderComponent) c).getCollider())
                .collect(Collectors.toList());
    }

    /**
     * Get current object graphic renderer components
     * 
     * @return Current object graphic renderer components
     */
    public final List<GraphicRenderingComponent> getRenderers() {
        return components.stream()
                .filter(c -> c.isGraphicRenderer())
                .map(c -> (GraphicRenderingComponent) c)
                .collect(Collectors.toList());
    }

    /**
     * Get all children of current object
     * 
     * @return Children of current object
     */
    public final List<GameObject> getAllChildren() {
        List<GameObject> ac = new ArrayList<>();
        children.forEach(c -> {
            c.getAllChildren().forEach(cc -> ac.add(cc));
        });
        ac.add(this);
        return ac;
    }

    /**
     * Set parent object of current object
     * 
     * @param parent Parent object of current
     */
    private void setParent(GameObject parent) {
        this.parent = parent;
    }

    /**
     * Get all components of current object
     * 
     * @return Components of current object
     */
    public final List<Component> getAllComponents() {
        return this.components;
    }

    /**
     * Get transform of current object
     * 
     * @return Transform of current object
     */
    public Transform getTransform() {
        return transform;
    }

    /**
     * Set transform of current object
     * 
     * @param transform New transform of current object
     */
    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    /**
     * Add component to current object
     * 
     * @param component New component to add
     */
    public void addComponent(Component component) {
        this.components.add(component);
    }

    /**
     * Get component of current object specifing class
     * 
     * @param componentClass Component class
     * @return Components searched
     */
    public List<Component> getComponentsByClass(Class componentClass) {
        return components.stream()
                .filter(c -> c.getClass().equals(componentClass))
                .collect(Collectors.toList());
    }

}
