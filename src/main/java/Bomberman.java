import com.sun.org.apache.bcel.internal.generic.RETURN;
/* FAZER MAIS MAPS CONFORME NECESSIDADE, FORAM USADOS ATÉ 5. O PROBLEMA
ESTÁ ACONTECENDO É POR QUE SE ESTÁ EDITANDO O MESMO MAP SEMPRE*/



public class Bomberman {
    private char grid [][];
    private char gridComplete [][];
    int row;
    int column;
    public Bomberman (int row, int column){
        this.row = row;
        this.column = column;
        this.grid = new char[row][column];
        this.gridComplete = new char[row][column];
    }

    public char[][] placeBombs(){
        int numMax = row*column;
        double numBomb = Math.floor(Math.random() * (numMax - 1)) + 1;
        for(int i = 0; i<numBomb; i++) {
            double rowPosition = Math.floor(Math.random() * (row - 0)) + 0;
            double columnPosition = Math.floor(Math.random() * (column - 0)) + 0;
            grid[(int) rowPosition][(int) columnPosition] = '*';

        }
        return grid;
    }

    public char [][] completeGrid (){
        char newGrid[][] = gridComplete;
        for(int i = 0; i<row; i++){
            for (int j = 0; j< column;j++){
                newGrid[i][j] = '*';
            }
        }
        return newGrid;
    }

    public char[][] explodeBombs (char [][] gridBomb, char [][] gridComplete){
        for(int i = 0; i<row; i++) {
            for (int j = 0; j < column; j++) {
                char matrix = gridBomb[i][j];
                if (matrix == '*') {
                    if (i == 0 && j == 0) {
                        gridComplete[i + 1][j] = ' ';
                        gridComplete[i][j+1] = ' ';
                        gridComplete[i][j] = ' ';
                    } else if (i == 0 && j < column - 1) {
                        gridComplete[i+1][j] = ' ';
                        gridComplete[i][j+1] = ' ';
                        gridComplete[i][j-1] = ' ';
                        gridComplete[i][j] = ' ';
                    }else if(i == 0 && j == column - 1){
                        gridComplete[i+1][j] = ' ';
                        gridComplete[i][j-1] = ' ';
                        gridComplete[i][j] = ' ';
                    }else if(j==0 && i < row - 1){
                        gridComplete[i][j+1] = ' ';
                        gridComplete[i+1][j] = ' ';
                        gridComplete[i-1][j] = ' ';
                        gridComplete[i][j] = ' ';
                    }
                    else if(j == 0 && i == row - 1){
                        gridComplete[i][j+1] = ' ';
                        gridComplete[i-1][j] = ' ';
                        gridComplete[i][j] = ' ';
                    }
                    else if(i == row-1 && j == column-1){
                        gridComplete[i][j-1] = ' ';
                        gridComplete[i-1][j] = ' ';
                        gridComplete[i][j] = ' ';
                    }
                    else if(j == column - 1){
                        gridComplete[i+1][j] = ' ';
                        gridComplete[i][j-1] = ' ';
                        gridComplete[i-1][j] = ' ';
                        gridComplete[i][j] = ' ';
                }
                    else if(i == row - 1){
                        gridComplete[i][j+1] = ' ';
                        gridComplete[i][j-1] = ' ';
                        gridComplete[i-1][j] = ' ';
                        gridComplete[i][j] = ' ';
                }

                    else{
                        gridComplete[i][j+1] = ' ';
                        gridComplete[i][j-1] = ' ';
                        gridComplete[i+1][j] = ' ';
                        gridComplete[i-1][j] = ' ';
                        gridComplete[i][j] = ' ';
                    }
                }
            }
        }
       // System.out.println("Saída: " + toString(newGrid));

        return gridComplete;
    }

    public char[][] gridAtualization (char [][] gridBomb, char [][] gridComplete) {
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < column; b++) {
                gridBomb[a][b] = ' ';
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (gridComplete[i][j] == '*') {
                    gridBomb[i][j] = '*';
                }
            }
        }
        return gridBomb;
    }


    public String toString(char [][] grid) {
        String gridSituation= "";
        for (int i = 0; i < row; i++) {
            gridSituation += "\n" + "| ";
            for (int j = 0; j < column; j++) {
                String gridRepresentation = grid[i][j] != '*'  ? " " : String.valueOf(grid[i][j]);
                gridSituation += gridRepresentation+ " | ";

            }
        }
        return gridSituation;
    }




}
