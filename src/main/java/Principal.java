import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("     B.O.M.B.E.R.M.A.N     ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o numero de linhas do campo: ");
        int row = scanner.nextInt();
        System.out.println("Informe o numero de colunas do campo: ");
        int column = scanner.nextInt();
        System.out.println("Informe o tempo de jogo: ");
        int time = scanner.nextInt();

        Bomberman grid = new Bomberman(row, column);
        Bomberman secondGrid = new Bomberman(row, column);
        char [][] firstGrid = grid.placeBombs(row, column);
        System.out.println(grid.toString(firstGrid));
        Thread.sleep(1000);
        int timePassed = 0;
        while(timePassed != time) {
            char[][] completeGrid = secondGrid.completeGrid(row, column);
            System.out.println("grade completa: " + secondGrid.toString(completeGrid));
            Thread.sleep(2000);
            System.out.println("grade antiga: " + grid.toString(firstGrid));
            firstGrid = grid.explodeBombs(firstGrid);
            System.out.println("Resultado final: \n" + grid.toString(firstGrid));
            timePassed += 3;


        }
    }
}
