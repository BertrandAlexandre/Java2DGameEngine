package fr.alexandrebertrand.j2dge;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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
    private static final int FRAMES_PER_SECOND = 60; // TODO use setting manager
    
    /*
     * Attributes
     */
    
    /** Last loop of the scene */
    private LocalDateTime lastLoop;
    
    /** Time between last and current loops */
    public static long deltaTime;
    
    /** Timer of the scene */
    private final Timer timer;
    
    /** Objects of the scene */
    protected final List<ObjectBehaviour> objects;
    
    /** Collision detector of the scene */
    private final CollisionDetector collisionDetector;
    
    /*
     * Constructors
     */
    
    /**
     * Initialize a new Scene and start scene management
     */
    public SceneBehaviour() {
        collisionDetector = new CollisionDetector();
        objects = new ArrayList<>();
        int ms = (int) Math.round(1000d / FRAMES_PER_SECOND);
        timer = new Timer(ms, this);
        timer.start();
    }
    
    /*
     * Methods
     */

    @Override
    public void actionPerformed(ActionEvent arg0) {
        setDeltaTime();
        checkCollisions();
        repaint();
    }
    
    /**
     * Set delta time of the scene
     */
    private void setDeltaTime() {
        deltaTime = lastLoop.until(LocalTime.now(), ChronoUnit.MILLIS);
        lastLoop = LocalDateTime.now();
    }
    
    /**
     * Check collisions of scene objects
     */
    private void checkCollisions() {
        collisionDetector.updateCollisions();
        objects.forEach(o -> {
            o.getColliders().forEach((k, v) -> {
                List<Collider> entry = k.searchCollisions(false, true);
                List<Collider> stay = k.searchCollisions(true, true);
                List<Collider> exit = k.searchCollisions(true, false);
                if (entry.size() > 0)
                    o.onCollisionEntry(entry);
                if (stay.size() > 0)
                    o.onCollisionStay(stay);
                if (exit.size() > 0)
                    o.onCollisionExit(exit);
            });
        });
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        objects.forEach((o) -> o.paint(g2d));
    }
    
    /**
     * Add an object to the scene
     * 
     * @param object Object to add
     */
    public void addObject(ObjectBehaviour object) {
        objects.add(object);
    }
    
    /*
     * Getters & Setters
     */
    
    /**
     * Get delta time of the scene
     * 
     * @return Delta time of the scene
     */
    public long getDeltaTime() {
        return deltaTime;
    }
    
    /**
     * Get collision detector of the scene
     * 
     * @return Collision detector of the scene
     */
    CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

}
