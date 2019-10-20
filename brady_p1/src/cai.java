//computer-assisted instruction

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class cai {

    private static Random rand = new SecureRandom();
    private static Scanner scan = new Scanner(System.in);

    private static int session = 1, totalQuestions = 10;
    private static int arithmetic, difficulty, qtyCorrect, qtyIncorrect;
    private static double correctAns;

    public static void main(String[] args) {

        while (session >= 1) {
            determineDifficulty();
            problemType();

            for (int i = 0; i < totalQuestions; i++) {
                generateQuestion();
            }

            calculateAccuracy();
            newSession();
        }
    }

    private static void determineDifficulty() {
        System.out.println("Enter your difficulty: 1, 2, 3, or 4");
        difficulty = scan.nextInt();
    }

    private static void problemType() {
        System.out.println("Enter 1 for addition problems only, 2 for multiplication only, 3 means subtraction only, 4 means division only, and 5 for a mix of addition, subtraction, multiplication, division!");
        arithmetic = scan.nextInt();
    }

    private static void generateQuestion() {
        int x = rand.nextInt(10 ^ difficulty);
        int y = rand.nextInt(10 ^ difficulty);
        int type = arithmetic;

        if (arithmetic == 5) {
            type = rand.nextInt(3) + 1;
        }

        switch (type) {
            case 1:
                System.out.println("How much is " + x + " + " + y + "? ");
                correctAns = x + y;
                break;
            case 2:
                System.out.println("How much is " + x + " * " + y + "? ");
                correctAns = x * y;
                break;
            case 3:
                System.out.println("How much is " + x + " - " + y + "? ");
                correctAns = x - y;
                break;
            case 4:
                if (y == 0) {
                    y = y + 1;
                }
                System.out.println("How much is " + x + " / " + y + " in decimal form? ");
                correctAns = (double) x / (double) y;
                break;
            default:
                break;
        }

        checkAnswer(type);
    }

    private static void checkAnswer(int type) {
        double answer = scan.nextDouble();

        if (type == 4) { //if division, just check if it's within accuracy
            if (Math.abs(answer - correctAns) <= Math.pow(10, -2)) {
                answer = correctAns;
            }
        }
        if (answer == correctAns) {
            qtyCorrect++;
            affirmation(true);
        } else {
            qtyIncorrect++;
            affirmation(false);
        }
    }

    private static void affirmation(boolean correct) {
        int response = rand.nextInt(4);

        if (correct) {
            switch (response) {
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
        } else {
            switch (response) {
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Not quite, but you'll get there!");
                    break;
                case 2:
                    System.out.println("Don’t give up!");
                    break;
                case 3:
                    System.out.println("You've got this, try again!");
                    break;
            }
        }
    }

    private static void calculateAccuracy() {

        double score = ((double) qtyCorrect / totalQuestions) * 100;

        System.out.printf("\nYou're score: %.2f%%\n", score);
        System.out.println("Correct Answers: " + qtyCorrect + " Incorrect Answers: " + qtyIncorrect);

        if (score >= 75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
        } else {
            System.out.println("Please ask your teacher for extra help.");
        }
    }

    private static void newSession() {
        System.out.print("\nWould you like begin a new session?\n");
        System.out.println("1 = One more session, 0 = No more sessions");
        session = scan.nextInt();
    }

}