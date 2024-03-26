package com.adepuu.exercises.session6;

import java.util.Scanner;

public class Exercise1 {
    /*
     * Write a Java Program to Enter numbers to calculate average and enter 'q' to finish.
     *
     * Input: 1, 2, 3, 4, 5, q
     * Output: 3
     *
     * Input: 1, 2, 3, a, b, 4, 5, q
     * Output: 3
     *
     * Explanation: print “Invalid input. Please enter a valid number or 'q' to finish.” if user not inserting the expected number or character.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        System.out.println("Enter numbers to calculate average and enter 'q' to finish:");

        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("q")) {
                if (count == 0) {
                    System.out.println("No numbers entered. Exiting...");
                } else {
                    double average = (double) sum / count;
                    System.out.println("Average: " + average);
                }
                break;
            } else {
                try {
                    int number = Integer.parseInt(input);
                    sum += number;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number or 'q' to finish.");
                }
            }
        }

        scanner.close();
    }
}
