import java.util.Scanner;

public class rps {

    static Scanner sc = new Scanner(System.in);
    static final int ROCK = 1, PAPER = 2, SCISSORS = 3; 
    static final int WIN  = 1, TIE = 2,   LOSS = 3;

    public static void main(String[] args) {
        //simulates a rock, paper, scissors game vs. a computer opponent.

        int wins = 0, losses = 0, ties = 0;
        int humanChoice, computerChoice;
        System.out.println("RPS 1.0");
        System.out.println("****************************************");
        System.out.println("Good luck, human ...");

        do {
            System.out.print("\nWhat do you throw? [1] Rock, [2] Paper, [3] Scissors ");
            humanChoice = sc.nextInt();//getChoice(); //
            computerChoice = (int) (Math.random() * 3 + 1);
            printChoices(humanChoice, computerChoice);
            int result = calculateWinner(humanChoice, computerChoice);
            if (result == TIE) {
                System.out.println("Wow, a tie!?");
                ties++;
            } else if (result == LOSS) {
                System.out.println("Haha, I win!");
                losses++;
            } else if (result == WIN) {
                System.out.println("Nooo!  I lost?  But how?");
                wins++;
            }
        } while (wantToPlayAgain());

        printStats(wins, losses, ties);
    }

    public static void printChoices(int humanChoice, int computerChoice) {
        //this method prints out the human's and the computer's throws 

        if (humanChoice == ROCK) 
            System.out.print("You threw Rock!  ");
        else if (humanChoice == PAPER) 
            System.out.print("You threw Paper!  ");
        else if (humanChoice == SCISSORS) 
            System.out.print("You threw Scissors!");

        if (computerChoice == ROCK)     
            System.out.println("I threw Rock!  ");
        else if (computerChoice == PAPER) 
            System.out.println("I threw Paper!  ");
        else if (computerChoice == SCISSORS) 
            System.out.println("I threw Scissors!  ");
    }

    public static int calculateWinner(int humanChoice, int computerChoice) {
        if (humanChoice == computerChoice) {
            return TIE;
        } else if (humanChoice == ROCK && computerChoice == SCISSORS || humanChoice == PAPER && computerChoice == ROCK || humanChoice == SCISSORS && computerChoice == PAPER) {
            return WIN;
        } else {
            return LOSS;
        }
    }

    public static boolean wantToPlayAgain()
    //this method prompts the user if they want to play again and then returns true or false depending on 
    //whether they answer y or n
    {
        System.out.print("Do you want to play again? [y,n]: ");
        String answer = sc.next();

        return (answer.equals("Y") || answer.equals("y"));
    }

    public static void printStats(int w, int l, int t)
    //prints out the win/lose/tie stats at the end of the game.
    {
        System.out.println("\nGood game!");
        System.out.println("****************************************");
        System.out.println("Wins:   " + w);
        System.out.println("Losses: " + l);
        System.out.println("Ties:   " + t);
    }

}
