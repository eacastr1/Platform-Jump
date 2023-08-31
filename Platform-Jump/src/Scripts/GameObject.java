/**
 * <h1></h1>
 * <p></p>
 *
 * @author Eddie Castro
 */
package Scripts;

public class GameObject {

    public static final int SIZE = 32;
    private double x;
    private double y;
    private int  width;
    private int height;
    private String image;

    /**
     * Creates a GameObject instance.
     * @param x The x coordinate of the GameObject.
     * @param y The y coordinate of the GameObject.
     * @param width The width of the GameObject.
     * @param height The height of the GameObject.
     * @param image The image of the GameObject.
     */
    public GameObject(double x, double y, int width, int height, String image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void draw() {
        double screenX = x + width / 2;
        double screenY = y + height / 2;
        StdDraw.picture(screenX, screenY, image, width, height);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
