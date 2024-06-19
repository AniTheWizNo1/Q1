import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;
        final int maxAttempts = 10;
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            roundsPlayed++;
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;
                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    totalScore += attemptsLeft + 1; 
                    System.out.println("Congratulations! You guessed the number correctly.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high. Attempts left: " + attemptsLeft);
                } else
                    System.out.println("Your guess is too low. Attempts left: " + attemptsLeft);
            }
            if (!guessedCorrectly) 
                System.out.println("Sorry, you've run out of attempts. The number was: " + numberToGuess);
            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
            System.out.println("Rounds played: " + roundsPlayed + ", Total score: " + totalScore);
        }
        System.out.println("Thank you for playing! Final score: " + totalScore);
        scanner.close();
    }
}
