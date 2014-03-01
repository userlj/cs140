package assignment04;

import java.util.Scanner;

public class GameOfLife {
    public static final int ROWS = 30;
    public static final int COLUMNS = 40;
// isAlive[i][j] IS true IF THE CELL in ROW i, COLUMN j IS ALIVE
    private boolean[][] isAlive = new boolean[ROWS][COLUMNS];
// liveNeighborCount[i][j] IS THE NUMBER OF CELLS THAT TOUCH
// THE CELL in ROW i, COLUMN j ARE ALIVE
    private int[][] liveNeighborCount = new int[ROWS][COLUMNS];

    public void updateNbrCount() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
            	liveNeighborCount[i][j] = 0;
                if(i > 0 && j > 0) {
                	if(isAlive[i-1][j-1])
                		liveNeighborCount[i][j]++;
                }
                if(i > 0) {
                	if(isAlive[i-1][j])
                		liveNeighborCount[i][j]++;
                }
                if(i > 0 && j < COLUMNS-1) {
                	if(isAlive[i-1][j+1])
                		liveNeighborCount[i][j]++;
                }
                if(j > 0) {
                	if(isAlive[i][j-1])
                		liveNeighborCount[i][j]++;
                }
                if(i < ROWS-1 && j > 0) {
                	if(isAlive[i+1][j-1])
                		liveNeighborCount[i][j]++;
                }
                if(i < ROWS-1) {
                	if(isAlive[i+1][j])
                		liveNeighborCount[i][j]++;
                }
                if(j < COLUMNS-1) {
                	if(isAlive[i][j+1])
                		liveNeighborCount[i][j]++;
                }
                if(i < ROWS-1 && j < COLUMNS-1) {
                	if(isAlive[i+1][j+1])
                		liveNeighborCount[i][j]++;
                }
            }
        }
// IN NESTED FOR-LOOPS COMPUTE liveNeighborCount[i][j]
// FOR THIS, YOU USE THE FOLLOWING
// FOR THE CELL in ROW i, COLUMN j THE NEIGHBORS ARE GIVEN BY:
// IF(i > 0 && j > 0) THE CELL in ROW i-1, COLUMN j-1 IS A NEIGHBOR
// IF(i > 0) THE CELL in ROW i-1, COLUMN j IS A NEIGHBOR
// IF(i > 0 && j < COLUMNS-1) THE CELL in ROW i-1, COLUMN j+1 IS A NEIGHBOR
// four more similar lines -- see Figure 21 in the 5th Edition AND Figure 16 in the 4th Edition
// IF(i < ROWS-1 && j < COLUMNS-1) THE CELL in ROW i+1, COLUMN j+1 IS A NEIGHBOR
    }

    public void computeNextGeneration() {
// IN NESTED FOR-LOOPS, USE THE GAME OF LIFE
// RULES TO EITHER CHANGE OR LEAVE THE SAME
// THE VALUE OF isAlive[i][j] TO true OR false
// DEPENDING ON THE VALUE OF liveNeighborCount[i][j]
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
            	if(liveNeighborCount[i][j] == 3)
            		isAlive[i][j] = true;
            	else if(liveNeighborCount[i][j] < 2 || liveNeighborCount[i][j] > 3)
            		isAlive[i][j] = false;
    		}
    	}
    }

    public void drawGame() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                if(isAlive[i][j]) {
                    System.out.print('X');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void demo() {
        Scanner keyboard = new Scanner(System.in);
        isAlive[5][1] = true;
        isAlive[5][2] = true;
        isAlive[6][1] = true;
        isAlive[6][2] = true;
        isAlive[1][25] = true;
        isAlive[2][23] = true;
        isAlive[2][25] = true;
        isAlive[3][13] = true;
        isAlive[3][14] = true;
        isAlive[3][21] = true;
        isAlive[3][22] = true;
        isAlive[3][35] = true;
        isAlive[3][36] = true;
        isAlive[4][12] = true;
        isAlive[4][16] = true;
        isAlive[4][21] = true;
        isAlive[4][22] = true;
        isAlive[4][35] = true;
        isAlive[4][36] = true;
        isAlive[5][11] = true;
        isAlive[5][17] = true;
        isAlive[5][21] = true;
        isAlive[5][22] = true;
        isAlive[6][11] = true;
        isAlive[6][15] = true;
        isAlive[6][17] = true;
        isAlive[6][18] = true;
        isAlive[6][23] = true;
        isAlive[6][25] = true;
        isAlive[7][11] = true;
        isAlive[7][17] = true;
        isAlive[7][25] = true;
        isAlive[8][12] = true;
        isAlive[8][16] = true;
        isAlive[9][13] = true;
        isAlive[9][14] = true;       
/*        isAlive[1][2] = true;
        isAlive[2][3] = true;
        isAlive[3][1] = true;
        isAlive[3][2] = true;
        isAlive[3][3] = true;*/
        drawGame();
        boolean run = true;
        while(run) {
            System.out.println("Press Enter to Continue...");
            String input = keyboard.nextLine();
            if(input.equalsIgnoreCase("STOP")) {
                run = false;
            } else {
                updateNbrCount();
                computeNextGeneration();
                drawGame();
            }
        }        
        keyboard.close();
    }
    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        gol.demo(); // shows a "Gosper Gun"
    }
}