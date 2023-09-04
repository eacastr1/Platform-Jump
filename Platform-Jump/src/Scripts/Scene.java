/**
 * <h1>Scene.java</h1>
 * <p>The Scene class, sets how the objects appear in the scene.</p>
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
    private ArrayList<Block> monsters;
    private Player player;
    private Exit exit;

    /**
     * Initializes the Scene's initial state and its GameObjects.
     * @param map Rows and Columns of the map.
     */
    public Scene(String[][] map) {
        this.rows = map.length;
        this.cols = map[0].length;

        int width = cols * 32;
        int height = rows * 32;
        this.background = new GameObject(0, 0, width, height, "../Assets/background.png");
        this.blocks = new ArrayList<Block>();
        this.monsters = new ArrayList<Block>();

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

    /**
     * Draws the GameObjects into the Scene.
     */
    public void draw() {
        background.draw();
        for(Block block : this.blocks) {
            block.draw();
        }
        for(Block spike : this.monsters) {
            spike.draw();
        }
        exit.draw();
        player.draw();
    }

    /**
     * Sets GameObjects according to their respective map symbols.
     * @param x X coordinate of the GameObject.
     * @param y Y coordinate of the GameObject.
     * @param tile The image or tile of the GameObject.
     */
    private void setTile(int x, int y, String tile) {
        if(tile.equals("#")) {
            Block block = new Block(x, y);
            this.blocks.add(block);
        }
        else if(tile.equals("@")) {
            this.player = new Player(x, y);
        }
        else if(tile.equals("A")) {
            FloorHazard spike = new FloorHazard(x, y);
            this.monsters.add(spike);
        }
        else if(tile.equals("V")) {
            CeilingHazard spike = new CeilingHazard(x, y);
            this.monsters.add(spike);
        }
        else if(tile.equals("!")) {
            this.exit = new Exit(x,y);
        }
    }

    /**
     * Gets the player of the Scene.
     * @return The Scene's Player field.
     */
    public Player getPlayer() {
        return this.player;
    }

    public Exit getExit() {
        return this.exit;
    }

    public boolean isPlayerDead() {
        for(Block hazard : monsters) {
            if(hazard.isTouching(player)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Appropriately Updates the player location and sprite in the Scene.
     */
    public void update() {
        player.update(blocks);
    }
}
