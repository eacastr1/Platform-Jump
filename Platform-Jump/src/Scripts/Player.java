/**
 * <h1>Player.java</h1>
 * <p>The Player class, involves the main controllable character in Platform Jump.</p>
 *
 * @author Eddie Castro
 */
package Scripts;

import java.util.ArrayList;

public class Player extends GameObject {

    private Physics physics;
    private boolean jumping;
    private Pose currentPose;

    /**
     * Creates a Player instance.
     * @param x X coordinate of the Player.
     * @param y Y coordinate of the Player.
     */
    public Player(double x, double y) {
        super(x*SIZE, y*SIZE, SIZE, SIZE, "../Assets/link-down.png");
        this.physics = new Physics(4);
        this.jumping = false;
        this.currentPose = Pose.RIGHT;
        super.setImage(currentPose.getImage());
    }

    /**
     * Moves the Player.
     */
    public void move() {
        double dx = this.getX() + physics.getVelocityX();
        double dy = this.getY() + physics.getVelocityY();
        super.move(dx,dy);
    }

    /**
     * Launches the Player, or jumping.
     */
    public void jump() {
        if(this.jumping == false) {
            physics.jump();
            jumping = true;
        }
    }

    /**
     * Moves the Player left.
     */
    public void moveLeft() {
        physics.moveLeft();
        this.currentPose = Pose.LEFT;
    }

    /**
     * Moves the Player right.
     */
    public void moveRight() {
        physics.moveRight();
        this.currentPose = Pose.RIGHT;
    }

    public void isJumping(boolean isJumping) {
        this.jumping = isJumping;
    }

    public void draw() {
        super.setImage(currentPose.getImage());
        super.draw();
    }

    /**
     * Updates the Player's location.
     */
    public void update(ArrayList<Block> blocks) {
        physics.update(blocks, this);
        this.move();
    }
}
