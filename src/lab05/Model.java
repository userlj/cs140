package lab05;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

public class Model extends Observable {
    private int ROWS = 50;
    private int COLUMNS = 50;
    private boolean animation = true;
    private Timer timer;

    private boolean[][] isAlive;
    private int[][] liveNeighborCount;

    public Model() {
        isAlive =  new boolean[ROWS][COLUMNS];
        liveNeighborCount = new int[ROWS][COLUMNS];
    }

    public void setAnimation(boolean animation) {
        this.animation = animation;
    }

    public void resetArraySizes(int newRows, int newCols) {
        ROWS = newRows;
        COLUMNS = newCols;
        boolean[][] newAlive = new boolean[ROWS][COLUMNS];
        int rowLimit = Math.min(newRows, isAlive.length);
        int colLimit = Math.min(newCols, isAlive[0].length);
        for(int i = 0; i < rowLimit; i++) {
            System.arraycopy(isAlive[i], 0, newAlive[i], 0, colLimit);
        }
        isAlive = newAlive;
        liveNeighborCount = new int[ROWS][COLUMNS];
        setChanged();
        notifyObservers();
    }

    public void resetRows(int newRows) {
        ROWS = newRows;
        boolean[][] newAlive = new boolean[ROWS][COLUMNS];
        int rowLimit = Math.min(newRows, isAlive.length);
        for(int i = 0; i < rowLimit; i++) {
            System.arraycopy(isAlive[i], 0, newAlive[i], 0, COLUMNS);
        }
        isAlive = newAlive;
        liveNeighborCount = new int[ROWS][COLUMNS];
        setChanged();
        notifyObservers();
    }
    
    public void resetColumns(int newCols) {
        COLUMNS = newCols;
        boolean[][] newAlive = new boolean[ROWS][COLUMNS];
        int colLimit = Math.min(newCols, isAlive.length);
        for(int i = 0; i < colLimit; i++) {
            System.arraycopy(isAlive[i], 0, newAlive[i], 0, ROWS);
        }
        isAlive = newAlive;
        liveNeighborCount = new int[ROWS][COLUMNS];
        setChanged();
        notifyObservers();
    }

    public int getMaxRows() {
		return ROWS;
	}

	public int getMaxCols() {
		return COLUMNS;
	}
	
	public void toggleAlive(int row, int col) {
		isAlive[row][col] = !isAlive[row][col];
	}

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
    
    public void step() {
        //compute next live array from the current one
    	updateNbrCount();
    	computeNextGeneration();
    	
        setChanged();
        notifyObservers();
    }

    public boolean[][] getLiveArray() {
        return isAlive;
    }

    /**
     * Generate a random layout of cells that are alive for use when
     * starting the Game of Life simulation
     */
    public void setupRandomStart() {
        java.util.Random random = new java.util.Random();
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                isAlive[i][j] = random.nextBoolean();
            }
        }
    }

    /**
     * Initialize the live cells with a glider to test that
     * it works correctly. Assume there are at least 3x3 cells
     */
    public void setupGlider() {
        isAlive =  new boolean[ROWS][COLUMNS];
        isAlive[ROWS-3][1] = true;
        isAlive[ROWS-3][2] = true;
        isAlive[ROWS-3][3] = true;
        isAlive[ROWS-2][3] = true;
        isAlive[ROWS-1][2] = true;
    }
   
    /**
     * Initialize the live cells with a Gosper gun
     * from http://en.wikipedia.org/wiki/File:Game_of_life_glider_gun.svg
     */
    public void setupGosper() {
        isAlive =  new boolean[ROWS][COLUMNS];
        int cols = Math.max(38, COLUMNS);
        int rows = Math.max(20, ROWS);
        resetArraySizes(rows,cols);
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
    }


    public void startTimer() {
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {              
                if(animation) {
                    step();
                }
            }       
        });
        timer.start();
    }

	public void clear() {
		isAlive = new boolean[ROWS][COLUMNS];
	}
}