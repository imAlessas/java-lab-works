import java.util.Random;
import java.util.Scanner;


public class TrisTester {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        char first, second, c;
        int row, column;
        boolean round = true;

        if((new Random()).nextBoolean()){
            first = 'x';
            second = 'o';
        }
        else{
            first = 'o';
            second = 'x';
        }

        System.out.println("First to go will be: "+ first);
        System.out.println("Second to go will be: "+ second);
        
        Tris game = new Tris();       
        
        while(!game.isWinning('o') && !game.isWinning('x') && game.getCount() < 9){
            if(round)
                c = first;
            else
                c = second;
            
            
            boolean done = false;
            while(!done){
                System.out.println(game.toString());
                System.out.print(c+", insert the coordinates (row column): ");
                row = keyboard.nextInt();
                column = keyboard.nextInt();
    
                try{
                    if(!game.setCharInPosition(row, column, c))
                        System.out.println("The cell is already taken. Try again!");
                    else
                        done = true;
                }catch(IllegalArgumentException e){
                    System.out.println("You must insert a valid row/column value (0, 1 or 2)! Try again!");
                }
            }

            round = !round;
        }

        System.out.println(game);

        if(game.isWinning('x'))
            System.out.println("X won the game.");
        else if(game.isWinning('o'))
            System.out.println("O won the game.");
        else 
            System.out.println("Tie. No player won.");

        


        keyboard.close();
    }
    
}
