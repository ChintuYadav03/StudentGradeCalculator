
package Student_Grade_Calculator;

import java.util.Scanner;

public class AverageGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Welcome to the Student Grade Calculator ***");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("*** Enter marks for five subjects ***");

        // Input marks for five subjects
        double[] subjectMarks = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextDouble();
        }

        // Calculate average
        double average = calculateAverage(subjectMarks);

        // Determine grade based on average
        char grade = calculateGrade(average);

        // Display results
        System.out.println("\nDear " + name + ",");
        System.out.println("Your average marks are: " + average);
        System.out.println("Your grade is: " + grade);
        if (grade == 'F') {
            System.out.println("Unfortunately, you failed. Don't lose hope, try harder next time!");
        } else {
            System.out.println("Congratulations! You passed.");
            displayMotivationalQuote(grade);
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    private static double calculateAverage(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.length;
    }

    private static char calculateGrade(double average) {
        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        return grade;
    }

    private static void displayMotivationalQuote(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("You're doing excellent! Keep up the good work!");
                break;
            case 'B':
                System.out.println("Well done! Your hard work is paying off.");
                break;
            case 'C':
                System.out.println("You're doing good, but there's always room for improvement. Keep pushing!");
                break;
            case 'D':
                System.out.println("You're close to the passing mark. Keep striving for better!");
                break;
            default:
                // No motivational quote for failing grade
                break;
        }
    }
}

