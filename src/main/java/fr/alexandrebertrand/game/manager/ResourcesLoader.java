package fr.alexandrebertrand.game.manager;

import fr.alexandrebertrand.game.component.graphic.renderer.SpriteRenderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Load sprite and audio resources
 * 
 * @author Alexandre Bertrand
 */
public class ResourcesLoader {

    /*
     * Attributes
     */

    /** Path to sprite resources */
    String spritesLocation;

    /** Current sprite renderers */
    private final List<SpriteRenderer> spriteRenderers;

    /** Initialize resources at scene initialisation */
    private boolean initResourcesWithScene;

    /*
     * Construtors
     */

    /**
     * Empty constructor
     */
    public ResourcesLoader() {
        this.spritesLocation = "";
        spriteRenderers = new ArrayList<>();
        initResourcesWithScene = true;
    }

    /**
     * Constructor with sprite resources location
     * 
     * @param spritesLocation Path to sprite resources
     */
    public ResourcesLoader(String spritesLocation) {
        this.spritesLocation = spritesLocation;
        spriteRenderers = new ArrayList<>();
        initResourcesWithScene = true;
    }

    /**
     * Initialize resources
     */
    public void initResources() {
        loadSprites();
        // TODO loadSounds();
    }

    /**
     * Load sprites from sprite renderers
     */
    public void loadSprites() {
        spriteRenderers.forEach(s -> s.setSprite(new ImageIcon(this.getClass()
                .getResource(spritesLocation + s.getSpritePath())).getImage()));
    }

    /**
     * Add sprite renderers to the resources loader
     * 
     * @param spriteRenderer Sprite renderer to add
     */
    public void addSpriteRenderer(SpriteRenderer spriteRenderer) {
        spriteRenderers.add(spriteRenderer);
    }

    /*
     * Getters & Setters
     */

    /**
     * Set sprite resources location
     * 
     * @param spritesLocation Path to sprite resources
     */
    public void setSpritesLocation(String spritesLocation) {
        char separator = '/';
        String sufix = (spritesLocation.charAt(spritesLocation.length() - 1) == separator)
                ? "" : String.valueOf(separator);
        String prefix = (spritesLocation.charAt(0) == separator)
                ? "" : String.valueOf(separator);
        this.spritesLocation = "/resources" + prefix + spritesLocation + sufix;
    }

    /**
     * Is resources initialize with scene initialisation
     * 
     * @return true if resources are initialized with scene initialisation,
     *         else false
     */
    public boolean isInitResourcesWithScene() {
        return initResourcesWithScene;
    }

    /**
     * Set resource initialisation with scenes
     * 
     * @param initResourcesWithScene New initailisation status with scene
     */
    public void setInitResourcesWithScene(boolean initResourcesWithScene) {
        this.initResourcesWithScene = initResourcesWithScene;
    }

}
