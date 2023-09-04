/**
 * <h1></h1>
 * <p></p>
 *
 * @author Eddie Castro
 */
package Scripts;

public class Block extends GameObject {

    /**
     * Creates a Block instance.
     * @param x The x coordinate of the block.
     * @param y The y coordinate of the block.
     */
    public Block(double x, double y) {
        super(x*SIZE, y*SIZE, SIZE, SIZE, "../Assets/tile-brick.png");
    }

    public Block(double x, double y, String image) {
        super(x*SIZE, y*SIZE, SIZE, SIZE, image);
    }

    public boolean isTouchingX(GameObject gameObject, double ratio) {
        double overlap = this.getWidth() * ratio;
        return ( Math.abs( this.getX()-gameObject.getX() ) < overlap );
    }

    public boolean isTouchingY(GameObject gameObject, double ratio) {
        double overlap = this.getHeight() * ratio;
        return ( Math.abs( this.getY()-gameObject.getY() ) < overlap);
    }

    public boolean isTouching(GameObject gameObject) {
        return isTouchingY(gameObject, 1.0) && isTouchingX(gameObject, 0.75);
    }
}
