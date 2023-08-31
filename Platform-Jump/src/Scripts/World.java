package Scripts;

import java.io.File;
import java.util.Scanner;

public class World {

    // [count][x][y]
    private String[][][] levels;

    /**
     * Get all map data and save it for later
     */
    public World() {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        levels = new String[count][][];

        for(int lvl = 0; lvl < count; lvl++) {
            int rows = input.nextInt();
            int cols = input.nextInt();
            input.nextLine();

            setLevel(lvl, rows, cols, input);
        }
    }

    /**
     * Set a level in the game.
     * @param lvl Level count of the level.
     * @param rows Amount of rows in the level.
     * @param cols Amount of columns in the level.
     * @param input Scanner object that takes in input.
     */
    private void setLevel(int lvl, int rows, int cols, Scanner input) {
        levels[lvl] = new String[rows][cols];

        input.useDelimiter("");
        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < cols; x++) {
                String tile = input.next();
                levels[lvl][y][x] = tile;
            }
            input.nextLine();
        }
        input.reset();
    }

    /**
     * Gets level.
     * @param level Level to get.
     * @return Level.
     */
    public String[][] getLevel(int level) {
        return levels[level];
    }
}
