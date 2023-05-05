import java.util.Arrays;

public class TurtleGraphics {
    public static final int ROWS = 20;
    public static final int COLS = 20;
    
    private int[][] floor;
    private int currRow;
    private int currCol;
    private boolean penDown;
    private int direction; // 1 = north, 2 = east, 3 = south, 4 = west
    
    public TurtleGraphics() {
        floor = new int[ROWS][COLS];
        currRow = 0;
        currCol = 0;
        penDown = false;
        direction = 2;
    }
    
    public void processCommand(int command) {
        switch (command) {
            case 1: // Pen up
                penDown = false;
                break;
            case 2: // Pen down
                penDown = true;
                floor[currRow][currCol] = 1;
                break;
            case 3: // Turn right
                direction = (direction % 4) + 1;
                break;
            case 4: // Turn left
                direction = (direction + 2) % 4 + 1;
                break;
            case 5: // Move forward
                int spaces = 10; // replace with actual number of spaces from input
                int rowStep = 0;
                int colStep = 0;
                switch (direction) {
                    case 1: // north
                        rowStep = -1;
                        break;
                    case 2: // east
                        colStep = 1;
                        break;
                    case 3: // south
                        rowStep = 1;
                        break;
                    case 4: // west
                        colStep = -1;
                        break;
                }
                for (int i = 0; i < spaces; i++) {
                    int newRow = currRow + rowStep;
                    int newCol = currCol + colStep;
                    if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLS) {
                        break;
                    }
                    currRow = newRow;
                    currCol = newCol;
                    if (penDown) {
                        floor[currRow][currCol] = 1;
                    }
                }
                break;
            case 6: // Display the array
                for (int[] row : floor) {
                    for (int cell : row) {
                        System.out.print(cell == 1 ? "*" : " ");
                    }
                    System.out.println();
                }
                break;
            case 9: // End of data
                break;
            default:
                System.out.println("Invalid command: " + command);
                break;
        }
    }
    
    public static void main(String[] args) {
        TurtleGraphics turtle = new TurtleGraphics();
        int[] commands = {2, 5, 10, 3, 5, 10, 3, 5, 10, 3, 5, 10, 1, 6, 9};
        for (int command : commands) {
            turtle.processCommand(command);
        }
    }
}
