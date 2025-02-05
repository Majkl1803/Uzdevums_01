import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String guessName = "Mike";
        int maxAttempts = 5;

        System.out.println("Welcome to the guess a name!");
        System.out.println("Hint: The secret name has " + guessName.length() + " letters.");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + " - Enter your guess: ");
            String guess = scanner.nextLine().trim();


            if (guess.equalsIgnoreCase(guessName)) {
                System.out.println(" Congratulations, you guess name correctly!");
                scanner.close();
                return;
            }


            int matchingLetters = countMatchingCharacters(guessName, guess);
            System.out.println("Wrong guess! Hint: You have " + matchingLetters + " letter(s) in the correct position.");

            if (attempt == maxAttempts) {
                System.out.println("Game Over!" + guessName);
            }
        }

        scanner.close();
    }

    public static int countMatchingCharacters(String secret, String guess) {
        int count = 0;
        int minLength = Math.min(secret.length(), guess.length());

        for (int i = 0; i < minLength; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                count++;
            }
        }
        return count;



    }
}