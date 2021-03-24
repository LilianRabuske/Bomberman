import com.sun.org.apache.bcel.internal.generic.RETURN;
/* FAZER MAIS MAPS CONFORME NECESSIDADE, FORAM USADOS ATÉ 5. O PROBLEMA
ESTÁ ACONTECENDO É POR QUE SE ESTÁ EDITANDO O MESMO MAP SEMPRE*/



public class Bomberman {
    private char grid [][];
    public Bomberman (int row, int column){
        this.grid = new char[row][column];
    }

    public char[][] placeBombs(int row, int column){
        int numMax = row*column;
        double numBomb = Math.floor(Math.random() * (numMax - 1)) + 1;
        for(int i = 0; i<numBomb; i++) {
            double rowPosition = Math.floor(Math.random() * (row - 0)) + 0;
            double columnPosition = Math.floor(Math.random() * (column - 0)) + 0;
            grid[(int) rowPosition][(int) columnPosition] = '*';

        }
        return grid;
    }

    public char [][] completeGrid (int row, int column){
        char newGrid[][] = grid;
        for(int i = 0; i<row; i++){
            for (int j = 0; j< column;j++){
                newGrid[i][j] = '*';
            }
        }
        return newGrid;
    }

    public char[][] explodeBombs (char [][] gridBomb){
        System.out.println("grid: " + toString(gridBomb));
        char[][] newGrid = completeGrid(3,3);
        System.out.println("Entrada: " + toString(newGrid));
        for(int i = 0; i<gridBomb.length; i++) {
            for (int j = 0; j < gridBomb.length; j++) {
                char matrix = gridBomb[i][j];
                if (matrix == '*') {
                    if (i == 0 && j == 0) {
                        newGrid[i + 1][j] = ' ';
                        newGrid[i][j+1] = ' ';
                        newGrid[i][j] = ' ';
                    } else if (i == 0 && j < grid.length - 1) {
                        newGrid[i+1][j] = ' ';
                        newGrid[i][j+1] = ' ';
                        newGrid[i][j-1] = ' ';
                        newGrid[i][j] = ' ';
                    }else if(i == 0 && j == grid.length - 1){
                        newGrid[i+1][j] = ' ';
                        newGrid[i][j-1] = ' ';
                        newGrid[i][j] = ' ';
                    }else if(j==0 && i < grid.length - 1){
                        newGrid[i][j+1] = ' ';
                        newGrid[i+1][j] = ' ';
                        newGrid[i-1][j] = ' ';
                        newGrid[i][j] = ' ';
                    }
                    else if(j == 0 && i == grid.length - 1){
                        newGrid[i][j+1] = ' ';
                        newGrid[i-1][j] = ' ';
                        newGrid[i][j] = ' ';
                    }
                    else if(i == grid.length-1 && j == grid.length-1){
                        newGrid[i][j-1] = ' ';
                        newGrid[i-1][j] = ' ';
                        newGrid[i][j] = ' ';
                    }
                    else if(j == grid.length - 1){
                        newGrid[i+1][j] = ' ';
                        newGrid[i][j-1] = ' ';
                        newGrid[i-1][j] = ' ';
                        newGrid[i][j] = ' ';
                }
                    else if(i == grid.length - 1){
                        newGrid[i][j+1] = ' ';
                        newGrid[i][j-1] = ' ';
                        newGrid[i-1][j] = ' ';
                        newGrid[i][j] = ' ';
                }

                    else{
                        newGrid[i][j+1] = ' ';
                        newGrid[i][j-1] = ' ';
                        newGrid[i+1][j] = ' ';
                        newGrid[i-1][j] = ' ';
                        newGrid[i][j] = ' ';
                    }
                }
            }
        }
       // System.out.println("Saída: " + toString(newGrid));

        return newGrid;
    }

    public String toString(char [][] grid) {
        String gridSituation= "";
        for (int i = 0; i < grid.length; i++) {
            gridSituation += "\n" + "| ";
            for (int j = 0; j < grid.length; j++) {
                String gridRepresentation = grid[i][j] != '*'  ? " " : String.valueOf(grid[i][j]);
                gridSituation += gridRepresentation+ " | ";

            }
        }
        return gridSituation;
    }




}
