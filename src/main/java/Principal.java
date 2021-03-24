import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("     B.O.M.B.E.R.M.A.N     ");
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int column = 0;
        int time = 0;
        while(column <= 1 || row <= 1 || time <= 0){
            try {
                System.out.println("Informe o numero de linhas do campo: ");
                row = scanner.nextInt();
                System.out.println("Informe o numero de colunas do campo: ");
                column = scanner.nextInt();
                if(row <= 1 || column <= 1){
                    throw new InvalidValueException();
                }
                System.out.println("Informe o tempo de jogo: ");
                time = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Informe apenas valores inteiros.");
                scanner.nextLine();
            } catch (InvalidValueException x){
                System.out.println("Linhas e colunas devem ser maiores que 1");
                scanner.nextLine();
            }
        }

        Bomberman grid = new Bomberman(row, column);
        char [][] bombGrid = grid.placeBombs();
        Thread.sleep(1000);
        int timePassed = 0;

        while(timePassed != time) {
            System.out.println("Grid com bombas: " + grid.toString(bombGrid));
            Thread.sleep(1000);
            timePassed += 1;
            if(timePassed == time){
                System.out.println("\n### TEMPO FINALIZADO ##\n");
                break;
            }
            char[][] completeGrid = grid.completeGrid();
            System.out.println("Grid completo: " + grid.toString(completeGrid));
            Thread.sleep(1000);
            timePassed += 1;
            if(timePassed == time){
                break;
            }
            Thread.sleep(1000);
            timePassed += 1;
            System.out.println(timePassed);
            char [][] secondBombGrid = grid.explodeBombs(bombGrid, completeGrid);
            bombGrid = grid.gridAtualization(bombGrid, secondBombGrid);
            System.out.println("Grid apos explosao: " + grid.toString(bombGrid));
            if(timePassed == time){
                break;
            }

        }
    }
}
