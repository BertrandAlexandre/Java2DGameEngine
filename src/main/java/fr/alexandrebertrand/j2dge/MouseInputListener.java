package fr.alexandrebertrand.j2dge;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mouse input listener
 * 
 * @author Alexandre Bertrand
 */
public class MouseInputListener implements MouseListener {
	
	/*
	 * Attributes
	 */
	
	private int button;
	private Point cursor;
	private boolean pressed;
	
	/*
	 * Methods
	 */

	@Override
	public void mouseClicked(MouseEvent event) {
	}

	@Override
	public void mousePressed(MouseEvent event) {
		button = event.getButton();
		cursor = event.getPoint();
		pressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		button = MouseEvent.NOBUTTON;
		cursor = null;
		pressed = false;
	}

	@Override
	public void mouseEntered(MouseEvent event) {
	}

	@Override
	public void mouseExited(MouseEvent event) {
	}
	
	/*
	 * Getters & Setters
	 */
	
	/**
	 * Indicate if the cursor intersects a shape
	 * when a mouse button is pressed
	 * 
	 * @param shape Shape to analyze
	 * @return true if mouse button is pressed and cursor
	 *         intersects a shape,
	 *         else false
	 */
	public boolean intersects(Shape shape) {
		if (!pressed) {
			return pressed;
		} // else
		return shape.contains(cursor);
	}
	
	/**
	 * Get pressed button
	 * 
	 * @return pressed button
	 */
	public int getButton() {
		return button;
	}

}
