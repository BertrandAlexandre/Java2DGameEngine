package fr.alexandrebertrand.j2dge.input;

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

    /** Current pressed button */
    private int button;

    /** Location of the mouse cursor */
    private Point cursor;

    /** Is a mouse button pressed */
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

    /*
     * Getters & Setters
     */

    /**
     * Get pressed button
     * 
     * @return pressed button
     */
    public int getButton() {
        return button;
    }

}
