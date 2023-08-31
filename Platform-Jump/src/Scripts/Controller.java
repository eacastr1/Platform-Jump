package Scripts;

public class Controller {
    private Player player;

    public Controller(Player player) {
        this.player = player;
    }

    public void keyboard() {
        if((StdDraw.isKeyPressed(38) || StdDraw.isKeyPressed(32))) {
            player.jump();
        }
    }

    public void update() {
        keyboard();
    }
}
