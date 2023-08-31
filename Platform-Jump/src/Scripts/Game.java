package Scripts;

public class Game {

    private World world;
    private boolean over;
    private int level;
    private Scene scene;

    /**
     * Create a new Platform Game
     */
    public Game() {
        this.over = false;
        this.level = 0;
        world = new World();
        String[][] map = world.getLevel(level);
        this.scene = new Scene(map);
    }

    /**
     * Game update code
     */
    public void update() {

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
