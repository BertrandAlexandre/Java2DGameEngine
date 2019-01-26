package fr.alexandrebertrand.game.util;

import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 * Sprite observer to load sprites
 * 
 * @author Alexandre Bertrand
 */
public final class SpriteObserver implements ImageObserver {

    /*
     * Attributes
     */

    /** Instance unique du sprite renderer */
    private static SpriteObserver instance;

    /*
     * Constructors
     */

    /**
     * Private empty constructor to disable public instanciation
     */
    private SpriteObserver() {
    }

    /*
     * Methods
     */

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return true;
    }

    /*
     * Getters & Setters
     */

    /**
     * Set and get uniq instance of sprite observer
     * 
     * @return Uniq instance of this observer
     */
    public static SpriteObserver getInstance() {
        if (instance == null) {
            instance = new SpriteObserver();
        }
        return instance;
    }

}
