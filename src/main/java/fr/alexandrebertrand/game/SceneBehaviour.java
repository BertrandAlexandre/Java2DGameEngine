package fr.alexandrebertrand.game;

import fr.alexandrebertrand.game.manager.ResourcesLoader;
import fr.alexandrebertrand.game.util.DeltaTime;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Scene containing and managing objects
 * 
 * @author Alexandre Bertrand
 */
public abstract class SceneBehaviour extends JPanel implements ActionListener {

    /*
     * Constants
     */

    /** Preferred number of frames per second */
    private static final int FRAMES_PER_SECOND = 1000; // TODO use setting manager

    /*
     * Attributes
     */

    /** Timer of the scene */
    private final Timer timer;

    /** Objects of the scene */
    private final List<GameObject> gameObjects;

    /** Ressources loader of the scene */
    private final ResourcesLoader resourcesLoader;

    /** Default Game objects color */
    private Color defaultObjectColor;

    /*
     * Constructors
     */

    /**
     * Initialize a new Scene and start scene management
     */
    public SceneBehaviour() {
        gameObjects = new CopyOnWriteArrayList<>();
        resourcesLoader = new ResourcesLoader();

        setVisible(true);
        setOpaque(true);
        setBackground(Color.BLACK);
        defaultObjectColor = Color.WHITE;

        DeltaTime.init();
        int ms = (int) Math.round((double) (1000d / FRAMES_PER_SECOND));
        timer = new Timer(ms, this);
        timer.start();
    }

    /*
     * Methods
     */

    /**
     * Initialize this scene
     */
    public void initScene() {
    }

    /**
     * Initialize game objects of this scene
     */
    public void initObjects() {
    }

    @Override
    public final void actionPerformed(ActionEvent arg0) {
        DeltaTime.set();
        checkCollisions();
        gameObjects.forEach((o) -> o.doUpdate());
        repaint();
    }

    /**
     * Check collisions of scene objects
     */
    private void checkCollisions() {
        GameBehaviour.collisionDetector.updateCollisions();
        gameObjects.forEach(o -> o.checkCollisions());
    }

    @Override
    public final void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        gameObjects.forEach((o) -> o.doPaint(g2d));
    }

    /**
     * Add a game object to the scene
     * 
     * @param gameObject Game object to add
     */
    public final void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    /**
     * Remove game object from the scene
     * 
     * @param gameObject Game object to remove
     */
    public final void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    /**
     * Get all game objects of the scene
     * 
     * @return All game objects of the scene
     */
    public final List<GameObject> getAllObjects() {
        List<GameObject> go = new ArrayList<>();
        gameObjects.forEach(c -> {
            c.getAllChildren().forEach(cc -> go.add(cc));
        });
        return go;
    }

    /*
     * Getters & Setters
     */

    /**
     * Get scene resource loader
     * 
     * @return Scene resource loader
     */
    public ResourcesLoader getResourcesLoader() {
        return resourcesLoader;
    }

    /**
     * Get scene default object color
     * 
     * @return Default object color
     */
    public final Color getDefaultObjectColor() {
        return defaultObjectColor;
    }

    /**
     * Set scene default object color
     * 
     * @param defaultObjectColor New default object color
     */
    public final void setDefaultObjectColor(Color defaultObjectColor) {
        this.defaultObjectColor = defaultObjectColor;
    }

}
