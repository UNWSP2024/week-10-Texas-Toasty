package Week10;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AverageApp {

    //  Calculate the average of a list of integers
    public static double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter up to 30 integers to calculate the average.");
        System.out.println("Type 'done' when you are finished entering numbers.");

        //  Get integers from user input.
        while (numbers.size() < 30) {
            System.out.print("Enter an integer: ");
            try {
                int number = userInput.nextInt();
                numbers.add(number);
            } catch (InputMismatchException e) {
                String input = userInput.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer or type 'done' to finish.");
                }
            }
        }

        //  Calculate and display the average
        double average = calculateAverage(numbers);
        System.out.printf("The average of the entered numbers is: %.2f%n", average);

        userInput.close();
    }
}
