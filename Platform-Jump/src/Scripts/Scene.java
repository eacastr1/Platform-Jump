/**
 * <h1>Scene.java</h1>
 * <p>Sets up the scene of the game.</p>
 *
 * @author Eddie Castro
 */
package Scripts;

import java.util.ArrayList;
public class Scene {

    private int rows;
    private int cols;
    private GameObject background;
    private ArrayList<Block> blocks;
    private Player player;

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
        this.blocks = new ArrayList<Block>();

        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < cols; x++) {
                String tile = map[y][x];
                setTile(x, y, tile);
            }
        }

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0.0, width);
        StdDraw.setYscale(height, 0.0);
    }

    public void draw() {
        background.draw();
        for(Block block : this.blocks) {
            block.draw();
        }
        player.draw();
    }

    private void setTile(int x, int y, String tile) {
        if(tile.equals("#")) {
            Block block = new Block(x, y);
            this.blocks.add(block);
        }
        else if(tile.equals("@")) {
            this.player = new Player(x, y);
        }
    }
}
