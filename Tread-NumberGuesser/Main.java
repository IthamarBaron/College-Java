import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Timer timer = new Timer();
        timer.start();

        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);
        int guess = 0;

        System.out.println("Guess the number between 1 and 100!");
        while (guess != randomNumber) {

            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            if (guess < randomNumber)
                System.out.println("Higher!");
            else if (guess > randomNumber)
                System.out.println("Lower!");
            else {
                System.out.println("Congratulations! You've guessed the number!");
                System.out.println("The number was: " + randomNumber);
                timer.stopTimer();
            }
        }

        scanner.close();
    }
}
