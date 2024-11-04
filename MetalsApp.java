package Week10;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MetalsApp {
    static Scanner userInput = new Scanner(System.in);
    //  Temp conversions
    static double convertToCelsius(String from, double temp) {
        return switch (from.toLowerCase().charAt(0)) {
            case 'f' -> (5.0 / 9) * (temp - 32);
            case 'r' -> (5.0 / 9) * (temp - 492);
            case 'k' -> temp - 273;
            default -> temp; 
        };
    }

    static double convertFromCelsius(String to, double temp) {
        return switch (to.toLowerCase().charAt(0)) {
            case 'f' -> (9.0 / 5) * temp + 32;
            case 'r' -> (9.0 / 5) * temp + 492;
            case 'k' -> temp + 273;
            default -> temp;
        };
    }
    //  Get user inputs for density, melting point, boiling point, hardness, and name of the metal
    public static void main(String[] args) {
        ArrayList<Metal> metals = new ArrayList<>();
        System.out.println("Welcome to the Metal Information Program!");

        do {
            System.out.print("\nEnter metal name: ");
            String name = userInput.nextLine();

            double density = promptForNumber("Density (g/cm³): ");
            double meltingPoint = promptForNumber("Melting point (°C): ");
            double boilingPoint = promptForNumber("Boiling point (°C): ");
            int hardness = (int) promptForNumber("Hardness (0-10): ", 0, 10);

            metals.add(new Metal(name, density, meltingPoint, boilingPoint, hardness));
        } while (promptForYesOrNo("Add another metal (y/n)? ").equals("y"));

        displayMetalsTable(metals);
    }
    //  Fool proofing
    private static double promptForNumber(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return userInput.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                userInput.next();
            }
        }
    }
    
    private static double promptForNumber(String prompt, int min, int max) {
        while (true) {
            double number = promptForNumber(prompt);
            if (number >= min && number <= max) {
                return number;
            }
            System.out.printf("Please enter a number between %d and %d.%n", min, max);
        }
    }

    private static String promptForYesOrNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String choice = userInput.next().toLowerCase();
            userInput.nextLine(); 
            if (choice.equals("y") || choice.equals("n")) {
                return choice;
            }
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }
    //  Displaying the metal data
    private static void displayMetalsTable(ArrayList<Metal> metals) {
        System.out.printf("\n%-15s %-10s %-20s %-20s %-10s%n", "Name", "Density", "Melting Point (°F)", "Boiling Point (°F)", "Hardness");
        System.out.println("--------------------------------------------------------------------------------------");

        for (Metal metal : metals) {
            double meltingF = convertFromCelsius("f", metal.meltingPoint);
            double boilingF = convertFromCelsius("f", metal.boilingPoint);
            System.out.printf("%-15s %-10.2f %-20.2f %-20.2f %-10d%n", metal.name, metal.density, meltingF, boilingF, metal.hardness);
        }
        System.out.println("Thank you for using the Metal Information Program!");
    }
}
//  Creating and storing variable information
class Metal {
    String name;
    double density;
    double meltingPoint;
    double boilingPoint;
    int hardness;

    public Metal(String name, double density, double meltingPoint, double boilingPoint, int hardness) {
        this.name = name;
        this.density = density;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.hardness = hardness;
    }
}
