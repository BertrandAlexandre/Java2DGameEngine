package fr.alexandrebertrand.j2dge.component;

import fr.alexandrebertrand.j2dge.GameBehaviour;
import fr.alexandrebertrand.j2dge.util.SpriteObserver;
import fr.alexandrebertrand.j2dge.GameObject;
import fr.alexandrebertrand.j2dge.location.Location;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

/**
 * Render a sprite from source
 * 
 * @author Alexandre Bertrand
 */
public class SpriteRenderer extends GraphicRenderingComponent {

    /*
     * Attributes
     */

    /** Preferized dimension of the sprite */
    private Dimension dimension;

    /** Location of the sprite */
    private Point location;

    /** Path to access sprite resource */
    private final String spritePath;

    /** Image of the sprite */
    private Image sprite;

    /*
     * Constructors
     */

    /**
     * Instanciate a sprite renderer with initial dimension and location
     * 
     * @param spritePath Path to access sprite resource
     * @param parent     Parent game object of the component
     */
    public SpriteRenderer(String spritePath, GameObject parent) {
        super(parent);
        this.spritePath = formatSpritePath(spritePath);
        this.location = parent.getTransform().getLocation();
        GameBehaviour.getCurrentScene().getResourcesLoader().addSpriteRenderer(this);
    }

    /**
     * Instanciate a sprite renderer with specified dimension and initial location
     * 
     * @param dimension  Preferized dimension of the sprite
     * @param spritePath Path to access sprite resource
     * @param parent     Parent game object of the component
     */
    public SpriteRenderer(Dimension dimension, String spritePath, GameObject parent) {
        super(parent);
        this.spritePath = formatSpritePath(spritePath);
        this.dimension = dimension;
        this.location = parent.getTransform().getLocation();
        GameBehaviour.getCurrentScene().getResourcesLoader().addSpriteRenderer(this);
    }

    /**
     * Instanciate a sprite renderer with initial dimension and specified location
     * 
     * @param location   Preferized location of the sprite
     * @param spritePath Path to access sprite resource
     * @param parent     Parent game object of the component
     */
    public SpriteRenderer(Point location, String spritePath, GameObject parent) {
        super(parent);
        this.spritePath = formatSpritePath(spritePath);
        this.location = Location.add(location, parent.getTransform().getLocation());
        GameBehaviour.getCurrentScene().getResourcesLoader().addSpriteRenderer(this);
    }

    /**
     * Instanciate a sprite renderer with specified dimension and location
     * 
     * @param dimension  Preferized dimension of the sprite
     * @param location   Preferized location of the sprite
     * @param spritePath Path to access sprite resource
     * @param parent     Parent game object of the component
     */
    public SpriteRenderer(Dimension dimension, Point location, String spritePath, GameObject parent) {
        super(parent);
        this.spritePath = formatSpritePath(spritePath);
        this.dimension = dimension;
        this.location = Location.add(location, parent.getTransform().getLocation());
        GameBehaviour.getCurrentScene().getResourcesLoader().addSpriteRenderer(this);
    }

    /*
     * Methods
     */

    /**
     * Format sprite path to avoid string path errors
     * 
     * @param spritePath Path to te sprite resource
     * @return Formated sprite path
     */
    private String formatSpritePath(String spritePath) {
        char separator = '/';
        String formatedSpritePath = (spritePath.charAt(0) == separator)
                ? spritePath.substring(1, spritePath.length() - 1) : spritePath;
        return formatedSpritePath;
    }

    @Override
    public final void paint(Graphics2D g2d) {
        Dimension d = (dimension != null) ? dimension :
                new Dimension(sprite.getHeight(SpriteObserver.getInstance()),
                        sprite.getHeight(SpriteObserver.getInstance()));
        g2d.drawImage(sprite, location.x, location.y, d.width, d.height,
                SpriteObserver.getInstance());
    }

    @Override
    public final void move(int x, int y) {
        move(new Point(x, y));
    }

    @Override
    public final void move(Point movement) {
        this.location = Location.add(this.location, movement);
    }

    /*
     * Getters & Setters
     */

    /**
     * Get dimension of the sprite into the renderer
     * 
     * @return Dimension of the sprite into the renderer
     */
    public final Dimension getDimension() {
        if (dimension == null) {
            if (sprite == null) {
                return new Dimension(20, 20);
            }
            dimension = new Dimension(sprite.getHeight(SpriteObserver.getInstance()),
                    sprite.getHeight(SpriteObserver.getInstance()));
        }
        return dimension;
    }

    /**
     * Set dimension of the sprite
     * 
     * @param dimension New sprite dimension
     */
    public final void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Get location of the sprite
     * 
     * @return Location of the sprite
     */
    public final Point getLocation() {
        return this.location;
    }

    @Override
    public final void setLocation(int x, int y) {
        setLocation(new Point(x, y));
    }

    @Override
    public final void setLocation(Point location) {
        this.location = location;
    }

    /**
     * Get sprite path to access resource location
     * 
     * @return Sprite path
     */
    public final String getSpritePath() {
        return this.spritePath;
    }

    /**
     * Get sprite of the renderer
     * 
     * @return The sprite
     */
    public final Image getSprite() {
        return sprite;
    }

    /**
     * Set sprite of the renderer
     * 
     * @param sprite New sprite to render
     */
    public final void setSprite(Image sprite) {
        this.sprite = sprite;
    }

}
