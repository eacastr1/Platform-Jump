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

}
