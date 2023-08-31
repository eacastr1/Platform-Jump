package Scripts;

public class Scene {

    private int rows;
    private int cols;
    private GameObject background;

    /**
     * Sets the scene.
     * @param map Rows and Columns of the map.
     */
    public Scene(String[][] map) {
        this.rows = map.length;
        this.cols = map[0].length;

        int width = cols * 32;
        int height = rows * 32;
        this.background = new GameObject(0, 0, width, height, "../Assets/background.png");

        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < cols; x++) {
                String tile = map[y][x];
            }
        }

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0.0, width);
        StdDraw.setYscale(height, 0.0);
    }

    public void draw() {
        background.draw();
    }
}
