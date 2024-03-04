import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 01;
        int maxRange = 100;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number!");

        while (playAgain) 
        {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guess;
            attempts = 0;
            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ". Guess it!");
            while (true) 
            {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber)
                {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += calculateScore(attempts);
                    break;
                } else if (guess < randomNumber)
                {
                    System.out.println("Too low! Try again.");
                } else 
                {
                    System.out.println("Too high! Try again.");
                }

                if (attempts >= 5)
                {
                    System.out.println("You have reached the maximum number of attempts.");
                    break;
                }
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            if (!playAgainInput.equalsIgnoreCase("yes")) 
            {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing Guess the Number! Your final score is: " + score);
        scanner.close();
    }

    // Calculate score based on the number of attempts
    private static int calculateScore(int attempts) 
    {
        if (attempts <= 4) 
        {
            return 10;
        } else if (attempts <= 6) 
        {
            return 5;
        } else {
            return 1;
        }
    }
}
