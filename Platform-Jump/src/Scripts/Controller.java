/**
 * <h1>Controller.java</h1>
 * <p>The Controller class, used to manipulate the movement of a Player class instance.</p>
 *
 * @author Eddie Andres Castro
 */
package Scripts;

public class Controller {
    private Player player;

    /**
     * Creates a Controller instance.
     * @param player The Player to be controlled.
     */
    public Controller(Player player) {
        this.player = player;
    }

    /**
     * Takes keyboard inputs and manipulates Player movement.
     */
    public void keyboard() {
        if((StdDraw.isKeyPressed(38) || StdDraw.isKeyPressed(32))) {
            player.jump();
        }
        if(StdDraw.isKeyPressed(37)){
            player.moveLeft();
        }
        if(StdDraw.isKeyPressed(39)) {
            player.moveRight();
        }
    }

    /**
     * Update for new keyboard inputs.
     */
    public void update() {
        keyboard();
    }
}
