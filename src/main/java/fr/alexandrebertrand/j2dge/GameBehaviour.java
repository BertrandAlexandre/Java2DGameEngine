package fr.alexandrebertrand.j2dge;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

/**
 * Entry point of the game initializing main settings
 * 
 * @author Alexandre Bertrand
 */
public abstract class GameBehaviour extends JFrame {
    
    /*
     * Attributes
     */
    
    /** Key listener of the game */
    public static KeyInputListener keyListener;
    
    /** Mouse listener of the game */
    public static MouseInputListener mouseListener;
    
    /** Scenes of the game */
    private static Map<String, SceneBehaviour> scenes;
    
    /** Current scene of the game */
    private static String currentScene;

    /*
     * Constructors
     */

    /**
     * Constructor to initialize the UI view
     * @param title Title of the game
     */
    public GameBehaviour(String title) {
        scenes = new HashMap<>();
        keyListener = new KeyInputListener();
        addKeyListener(keyListener);
        mouseListener = new MouseInputListener();
        addMouseListener(mouseListener);
        
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /*
     * Methods
     */
    
    /**
     * Add a scene to the game and play this scene
     * 
     * @param name  Name of the scene
     * @param scene Scene to add and play
     */
    public void addScene(String name, SceneBehaviour scene) {
        scenes.put(name, scene);
        playScene(name);
    }
    
    /**
     * Play a scene
     * 
     * @param name Scene to play
     */
    public void playScene(String name) {
        try {
            if (currentScene != null) {
                remove(scenes.get(currentScene));
            }
            add(scenes.get(name));
            currentScene = name;
        } catch (Exception e) {
            System.err.println("Scene not found");
        }
    }
    
    /**
     * Reload current scene
     */
    public void reloadScene() {
        playScene(currentScene);
    }
    
    /**
     * Getters & Setters
     */
    
    /**
     * Get current scene of the game
     * 
     * @return Current scene of the game
     */
    static SceneBehaviour getCurrentScene() {
        return scenes.get(currentScene);
    }

}
