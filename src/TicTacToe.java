import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] array = new char[3][3];
        Scanner input = new Scanner(System.in);
        int row = 0,col =0;
        System.out.println("\n***** Tic Tac Toe *****");
        printBoard(array);
        int i = 0;
        while(i<9){
            System.out.print(i%2==0?"\nX's turn : ":"\nO's turn : ");
            int number = input.nextInt();

            row = (number%3 == 0)?number/3-1:number/3;
            col = (number%3 == 0)?2:number%3-1;
            if(number <1 || number > 9 || Character.isAlphabetic(array[row][col])){
                System.out.println("Invalid position : ");
                continue;
            }
            array[row][col] = (i%2==0)?'X':'O';
            printBoard(array);
            if( checkVert(array[row][col],array,row)||
                checkHor(array[row][col],array,col)||
                checkDia(array[row][col],array,row,col)||
                checkDiag(array[row][col],array,row,col)
            ) {
                System.out.println("\n"+array[row][col]+" Won the Game !!!");
                return;
            }
            i++;
        }
        System.out.println("\nMatch Draw !!! ");
    }
    public static void printBoard(char[][] array){
        System.out.println();
        System.out.println("\n\t+---+---+---+");
        for(int i = 0;i<3;i++){
            System.out.print("\t|");
            for(int j = 0;j<3;j++){
                if(!Character.isAlphabetic(array[i][j]))
                    System.out.print("   |");
                else
                    System.out.print(" "+array[i][j]+" |");
            }
            System.out.println("\n\t+---+---+---+");
        }
    }
    public static boolean checkVert(char c,char[][] array, int i){
        return array[i][0] == c && array[i][1] == c && array[i][2] == c;
    }
    public static boolean checkHor(char c,char[][] array, int i){
        return array[0][i] == c && array[1][i] == c && array[2][i] == c;
    }
    public static boolean checkDia(char c,char[][] array, int i,int j){
        if(i!=j)
            return false;
        return array[0][0] == c && array[1][1] == c && array[2][2] == c;
    }

    public static boolean checkDiag(char c,char[][] array, int i,int j){
        if(i+j!=2)
            return false;
        return array[0][2] == c && array[1][1] == c && array[2][0] == c;
    }
}
