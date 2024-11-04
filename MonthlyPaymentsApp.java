package Week10;
import java.util.Scanner;

public class MonthlyPaymentsApp {
    static Scanner userInput = new Scanner(System.in);

    //  Compute the monthly payment
    static double computePayment(double loanAmt, double yearlyRate, int years) {
        double monthlyRate = (yearlyRate / 100) / 12; // Convert to monthly interest rate as a decimal
        int numPeriods = years * 12; // Total number of monthly payments

        //  Monthly payment formula
        double monthlyPayment = (loanAmt * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numPeriods));
        return monthlyPayment;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Monthly Mortgage Calculator");

        //  Input loan amount
        System.out.print("\nEnter loan amount: ");
        double loanAmount = userInput.nextDouble();

        //  Input yearly interest rate
        System.out.print("Enter yearly interest rate (without a %): ");
        double yearlyInterestRate = userInput.nextDouble();

        //  Input loan length in years
        System.out.print("Enter number of years: ");
        int years = userInput.nextInt();

        //  Calculate and display the monthly payment
        double monthlyPayment = computePayment(loanAmount, yearlyInterestRate, years);
        System.out.printf("\nThe monthly payment is: $%.2f%n", monthlyPayment);
    }
}
