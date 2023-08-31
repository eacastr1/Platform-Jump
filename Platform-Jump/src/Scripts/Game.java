/**
 * <h1></h1>
 * <p></p>
 *
 * @author Eddie Castro
 */
package Scripts;

public class Game {

    private World world;
    private boolean over;
    private int level;
    private Scene scene;
    private Controller controller;

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
