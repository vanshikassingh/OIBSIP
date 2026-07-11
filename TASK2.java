# -------------------------------
# NUMBER GUESSING GAME
# -------------------------------

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("===== GUESS THE NUMBER GAME =====");

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 10;
            boolean guessed = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessed = true;

                    int score = attempts * 10;
                    totalScore += score;

                    System.out.println("Score this round: " + score);
                    break;
                } else if (guess < number) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                attempts--;
                System.out.println("Attempts Left: " + attempts);
            }

            if (!guessed) {
                System.out.println("Game Over!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThank you for playing!");
        sc.close();
    }
}
