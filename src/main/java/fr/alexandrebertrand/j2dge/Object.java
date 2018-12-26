package fr.alexandrebertrand.j2dge;

import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * Object
 * 
 * @author Alexandre Bertrand
 */
public abstract class Object extends JPanel {
	
	/*
	 * Attributes
	 */
	
	/** Position of the object */
	private Point position;
	
	/** X scale of the object */
	private double xScale;
	
	/** Y scale of the object */
	private double yScale;
	
	/** Rotation of the object */
	private double rotation;
	
	/*
	 * Constructors
	 */
	
	/**
	 * Construct a new object
	 * 
	 * @param position Initial position
	 * @param xScale   Initial X scale
	 * @param yScale   Initial Y scale
	 * @param rotation Initial rotation
	 */
	public Object(Point position, double xScale, double yScale, double rotation) {
		this.position = position;
		this.xScale = xScale;
		this.yScale = yScale;
		this.rotation = rotation;
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
	 * Set position of the object
	 * 
	 * @param position New position of the object
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Get x scale of the object
	 * 
	 * @return x scale of the object
	 */
	public double getXSScale() {
		return xScale;
	}

	/**
	 * Set x scale of the object
	 * 
	 * @param New x scale of the object
	 */
	public void setXScale(double xScale) {
		this.xScale = xScale;
	}

	/**
	 * Get y scale of the object
	 * 
	 * @return y scale of the object
	 */
	public double getYScale() {
		return yScale;
	}

	/**
	 * Set y scale of the object
	 * 
	 * @param New y scale of the object
	 */
	public void setYScale(double yScale) {
		this.yScale = yScale;
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
	 * Set rotation of the object
	 * 
	 * @param rotation New rotation of the object
	 */
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	
}
