package fr.alexandrebertrand.j2dge.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Delta time of the game
 * 
 * @author Alexandre Bertrand
 */
public final class DeltaTime {

    /*
     * Attributes
     */

    /** Last loop of the scene */
    private static LocalDateTime lastLoop;

    /** Time between last and current loops */
    private static long deltaTime;

    /*
     * Constructors
     */

    /**
     * Private empty constructor
     */
    private DeltaTime() {
    }

    static {
        lastLoop = LocalDateTime.now();
    }

    /*
     * Methods
     */

    /**
     * Get current delta time
     * 
     * @return Current delta time
     */
    public final static long get() {
        return deltaTime;
    }

    /**
     * Initialize delta time
     */
    public final static void init() {
        deltaTime = 0;
        lastLoop = LocalDateTime.now();
    }

    /**
     * Set current delta time
     */
    public final static void set() {
        deltaTime = lastLoop.until(LocalDateTime.now(), ChronoUnit.MILLIS);
        lastLoop = LocalDateTime.now();
    }

}
