//   A number guessing game
import java.util.Scanner;

public class Game {

    // Function that implements the number guessing game
    public static void
    GuessGame()
    {
        // Scanner Class   for taking input
        Scanner sc = new Scanner(System.in);

        // Generate the numbers
        int number = 1 + (int) (100* Math.random());

        // Given T trials
        int T = 4 ;

        int i, guess;

        System.out.println("A number is chosen"+ " between 1 to 100."+ "Guess the number"+ " within 4 trials.");

        // Iterate over T Trials
        for (i = 0; i < T; i++) {

            System.out.println("Guess the number:");

            // Take input for guessing
            guess = sc.nextInt();

            // If the number is guessed
            if (number == guess) {
                System.out.println("Congratulations!"+ " You guessed the number.");
                break;
            }
            else if (number > guess
                    && i != T - 1) {
                System.out.println("The number is "+ "greater than " + guess);
            }
            else if (number < guess && i != T - 1) {
                System.out.println("The number is"+ " less than " + guess);
            }
        }

        if (i == T) {
            System.out.println("You have used all "+ " T trials.");

            System.out.println("The number was " + number);
        }
    }

    // Driver Code
    public static void main(String arg[])
    {
        // Function Call();
        GuessGame();
    }
}
