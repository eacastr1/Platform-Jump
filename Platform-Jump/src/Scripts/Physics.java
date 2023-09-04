/**
 *<h1>Physics.java</h1>
 * <p>Physics class, used to apply physics to the Player.</p>
 *
 * @Eddie Castro
 */
package Scripts;

import java.util.ArrayList;

public class Physics {

    private int speed;
    private double gravity;
    private double terminal;
    private double velocityX;
    private double velocityY;
    private double friction;

    /**
     * Creates a Physics instance.
     * @param speed The speed of the Player.
     */
    public Physics(int speed) {
        this.speed = speed;
        this.gravity = 0.3;
        this.terminal = 8;
        this.velocityX = 0.0;
        this.velocityY = 0.0;
        this.friction = 0.8;
    }

    /**
     * Applies gravity to the Player.
     */
    public void applyGravity() {
        if(velocityY < terminal) {
            velocityY += gravity;
        }
    }

    /**
     * Applies friction to the Player.
     */
    public void applyFriction() {
        velocityX *= friction;
    }

    public double getVelocityX() {
        return this.velocityX;
    }

    public double getVelocityY() {
        return this.velocityY;
    }

    public void jump() {
        velocityY = -speed * 2;
    }

    public void moveLeft() {
        if(velocityX > -speed) {
            velocityX--;
        }
    }

    public void moveRight() {
        if(velocityX < speed) {
            velocityX++;
        }
    }

    public void checkCollisions(ArrayList<Block> blocks, Player player) {
        for(Block block : blocks) {
            if(block.isTouching(player) ) {
                checkCollisionFloor(block, player);
                checkCollisionCeiling(block, player);
                checkCollisionRight(block, player);
                checkCollisionLeft(block, player);
            }
        }
    }

    public void checkCollisionFloor(Block block, Player player) {
        // player higher than block and falling
        if(player.getY() < block.getY() && velocityY > 0) {
            // ensure player and block on same column
            if(block.isTouchingX(player, 0.5)) {
                this.velocityY = 0;
                player.isJumping(false);
            }
        }
    }

    public void checkCollisionCeiling(Block block, Player player) {
        // player lower than block and jumping towards the block
        if(player.getY() > block.getY() && velocityY < 0) {
            // player will get pushed down
            this.velocityY *= -0.5;
        }
    }

    public void checkCollisionRight(Block block, Player player) {
        // player is right of block and moving left towards the block
        if(player.getX() < block.getX() && velocityX > 0) {
            // ensures player and block are on the same row
            if(block.isTouchingY(player, 0.5)) {
                this.velocityX *= -1;
            }
        }
    }

    public void checkCollisionLeft(Block block, Player player) {
        // player is left of the block, and is moving right towards the block
        if(player.getX() > block.getX() && velocityX < 0) {
            // ensures player and block on the same row
            if(block.isTouchingY(player, 0.5)) {
                this.velocityX *= -1;
            }
        }
    }



    /**
     * Updates gravity's effect on the Player.
     */
    public void update(ArrayList<Block> blocks, Player player) {
        applyGravity();
        applyFriction();
        checkCollisions(blocks, player);
    }
}
