/**
 * <h1></h1>
 * <p></p>
 *
 * @author Eddie Castro
 */
package Scripts;

public class Player extends GameObject {

    private Physics physics;
    private boolean jumping;

    public Player(double x, double y) {
        super(x*SIZE, y*SIZE, SIZE, SIZE, "../Assets/link-down.png");
        this.physics = new Physics(4);
        this.jumping = false;
    }

    public void move() {
        double dx = this.getX() + physics.getVelocityX();
        double dy = this.getY() + physics.getVelocityY();
        super.move(dx,dy);
    }

    public void jump() {
        if(this.jumping == false) {
            physics.jump();
            jumping = true;
        }
    }

    public void update() {
        physics.update();;
        this.move();
    }
}
