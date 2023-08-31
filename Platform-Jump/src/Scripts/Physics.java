package Scripts;

public class Physics {

    private int speed;
    private double gravity;
    private double terminal;
    private double velocityX;
    private double velocityY;

    public Physics(int speed) {
        this.speed = speed;
        this.gravity = 0.3;
        this.terminal = 8;
        this.velocityX = 0.0;
        this.velocityY = 0.0;
    }

    public void applyGravity() {
        if(velocityY < terminal) {
            velocityY += gravity;
        }
    }

    public void update() {
        applyGravity();
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
}
