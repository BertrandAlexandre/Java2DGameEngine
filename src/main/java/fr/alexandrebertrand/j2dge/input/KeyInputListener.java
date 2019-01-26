package fr.alexandrebertrand.j2dge.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Key input listener
 * 
 * @author Alexandre Bertrand
 */
public class KeyInputListener implements KeyListener {

    /*
     * Attributes
     */

    /** Keys status */
    private final boolean[] keys = new boolean[256];

    /** Time since last key inputs */
    private final LocalDateTime[] lastInputs = new LocalDateTime[256];

    /*
     * Methods
     */

    @Override
    public void keyPressed(KeyEvent event) {
        keys[event.getKeyCode()] = true;
        lastInputs[event.getKeyCode()] = LocalDateTime.now();
    }

    @Override
    public void keyReleased(KeyEvent event) {
        keys[event.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    /**
     * Indicate time in seconds since last input
     * 
     * @param key Key to analyze
     * @return Time since last input of the key
     */
    public double sinceLastInput(int key) {
        return lastInputs[key].until(LocalTime.now(), ChronoUnit.MILLIS) / 1000d;
    }

    /*
     * Getters & Setters
     */

    /**
     * Indicate if a key is currently pressed
     * 
     * @param key Key to analyze
     * @return true if the key is pressed,
     *         else false
     */
    public boolean isPressed(int key) {
        return keys[key];
    }

    /**
     * Indicate if a key is currently released
     * 
     * @param key Key to analyze
     * @return true if the key is released,
     *         else false
     */
    public boolean isReleased(int key) {
        return !keys[key];
    }

}
