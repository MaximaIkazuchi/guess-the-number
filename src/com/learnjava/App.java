package com.learnjava;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("' Guess the Number '");
        System.out.println(" Simple minigame command line built with Java ");
        System.out.println(" by: Ananda Steven Firdaus ");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n");

        Scanner In = new Scanner(System.in);

        System.out.print("Insert your name: ");
        String name = In.next();
        System.out.println("\nHello, " + name);

        boolean start = false;
        while (!start) {
            System.out.print("Should we start? (y/n): ");
            char confirmStart = In.next().charAt(0);
            if (confirmStart == 'y') {
                start = true;
            } else if (confirmStart == 'n') {
                In.close();
                return;
            }
        }

        boolean again = true;
        while (again) {
            Random rand = new Random();
            int max = rand.nextInt(100);
            if (max < 10) {
                max = rand.nextInt(100) + 10;
            }
            int min = max - 10;
            int randomNum = rand.nextInt(max - min - 1) + min + 1;

            System.out.println("\n** Guess the number between " + min + " and " + max + " **\n");
            for (int attempt = 5; attempt > 0; attempt--) {
                System.out.println("Remaining Attempt: " + attempt);
                System.out.print("=> Your answer: ");
                int answer = In.nextInt();
                System.out.print("\n");

                if (answer == randomNum) {
                    System.out.println("Correct!");
                    break;
                } else if (attempt == 1) {
                    System.out.println("Game Over");
                    System.out.println("The answer is: " + randomNum);
                    break;
                } else if (answer < min) {
                    System.out.println("Hint: The minimum of number is " + min + "!");
                } else if (answer > max) {
                    System.out.println("Hint: The maximum of number is " + max + "!");
                } else if (answer > randomNum) {
                    System.out.println("Hint: Try lower!");
                } else if (answer < randomNum) {
                    System.out.println("Hint: Try higher!");
                }
            }
            while (true) {
                System.out.print("Do you want to play again? (y/n): ");
                char againConfirm = In.next().charAt(0);
                if (againConfirm == 'y') {
                    again = true;
                    break;
                } else if (againConfirm == 'n') {
                    again = false;
                    break;
                }
            }

        }
        System.out.println("Thanks for playing! ^_^");
        In.close();
    }
}