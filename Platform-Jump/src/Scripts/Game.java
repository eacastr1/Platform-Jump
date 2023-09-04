/**
 * <h1>Game.java</h1>
 * <p>The Runner class for Platform Jump.</p>
 *
 * @author Eddie Castro
 */
package Scripts;

public class Game {

    private World world;
    private Scene scene;
    private Controller controller;
    private boolean over;
    private int level;

    /**
     * Create a new Platform Game
     */
    public Game() {
        this.over = false;
        this.level = 0;
        world = new World();
        String[][] map = world.getLevel(level);
        this.scene = new Scene(map);
        Player player = scene.getPlayer();
        this.controller = new Controller(player);
    }

    /**
     * Game update code
     */
    public void update() {
        controller.update();
        scene.update();
        this.over = scene.isPlayerDead();
        if(scene.getExit().isTouching(scene.getPlayer())) {
            this.level++;
            if(this.level < world.getLength()) {
                String[][] map = world.getLevel(this.level);
                this.scene = new Scene(map);
                this.controller = new Controller(this.scene.getPlayer());
            }
            else {
                this.over = true;
            }
        }
    }

    /**
     * Game draws/renders code
     */
    public void render() {
        scene.draw();
        StdDraw.show(10);
    }

    /**
     * The main game loop
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Game game = new Game();
        while(game.over == false) {
            game.update();
            game.render();
        }
    }
}
