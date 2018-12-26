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
 * Scene
 * 
 * @author Alexandre Bertrand
 */
public abstract class Scene extends JPanel implements ActionListener {
    
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
	private long deltaTime;
	
	/** Game timer */
	private Timer timer;
	
	/** Objects of the scene */
	private List<Object> objects;
	
	/*
	 * Constructors
	 */
	
	public Scene() {
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
		for (Object object : objects) {
        	object.update();
        }
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        for (Object object : objects) {
        	object.paint(g2d);
        }
    }
	
    /*
     * Getters & Setters
     */
    
    /**
     * Set delta time of the scene
     */
	private void setDeltaTime() {
		deltaTime = lastLoop.until(LocalTime.now(), ChronoUnit.MILLIS);
		lastLoop = LocalDateTime.now();
	}
	
    /**
     * Get delta time of the scene
     * 
     * @return Delta time of the scene
     */
	public long getDeltaTime() {
		return deltaTime;
	}
	
	/**
	 * Add an object to the scene
	 * 
	 * @param object Object to add
	 */
	public void addObject(Object object) {
		objects.add(object);
	}

}
