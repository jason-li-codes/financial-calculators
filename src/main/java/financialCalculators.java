import java.util.Scanner;

public class financialCalculators {

    // an application that provides a set of financial calculators
    // the screen will prompt the user to select which calculator they would like to use:
    // mortgage, compound interest, annuity value

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("""
                Hello, which financial calculator would you like to use?
                (1) Mortgage calculator
                (2) Compound interest calculator
                (3) Annuity value calculator
                (4) More info
                """);

        int whichCalc = input.nextInt();
        input.nextLine();

        switch (whichCalc) {
            case 1:
                mortgageCalc(input);
                break;
            case 2:
                interestCalc(input);
                break;
            case 3:
                annuityCalc(input);
                break;
            case 4:
                System.out.println("""
                        Mortgage calculator will determine how much a monthly payment for a loan would be (minus any
                        insurance or taxes), as well as how much interest you would pay over the life of the loan.
                        Interest calculator will determines the future value of a one-time deposit assuming compound
                        interest.
                        Annuity value calculator will determines the present value of an ordinary annuity.
                        To go back to main menu, rerun program.
                        """);
            default:
                System.out.println("Incorrect selection, please rerun program.");
        }

    }

    public static void mortgageCalc(Scanner input) {

        System.out.println("What will the principal of the mortgage be?");
        double principal = input.nextDouble();
        System.out.println("What will the annual interest rate percentage be?");
        double interestAnnual = input.nextDouble();
        System.out.println("What will the loan length  be in years?");
        double loanLengthYears = input.nextDouble();

        double interest = interestAnnual / 100 / 12;
        double loanLengthMonths = loanLengthYears * 12;

        double monthPayment = principal * ((interest * Math.pow((1 + interest), loanLengthMonths)) /
                (Math.pow((1 + interest), loanLengthMonths) - 1));

        double totalInterest = monthPayment * loanLengthMonths - principal;

        System.out.printf("""
                        Your expected monthly payments would be $.2f, for %d months.
                        Your total interest paid would be $.2f.
                        """,
                monthPayment, loanLengthMonths, totalInterest);

    }

    public static void interestCalc(Scanner input) {

        System.out.println("What will the deposit be?");
        double deposit = input.nextDouble();
        System.out.println("What will the annual interest rate percentage be?");
        double interestAnnualPercentage = input.nextDouble();
        System.out.println("What will the loan length  be in years?");
        double CDLengthYears = input.nextDouble();

        double interestAnnual = interestAnnualPercentage / 100;

        double futureValue = deposit * Math.pow(1 + (interestAnnual / 365), 365 * CDLengthYears);

        double totalInterest = futureValue - deposit;

        System.out.printf("""
                        The future value of your deposit would be $%.2f.
                        The total interest earned would be $.2f.
                        """,
                futureValue, totalInterest);

    }

    public static void annuityCalc(Scanner input) {

        System.out.println("What is the monthly payout of the annuity?");
        double monthlyPayout = input.nextDouble();
        System.out.println("What is the expected monthly interest rate percentage?");
        double monthlyInterestPercentage = input.nextDouble();
        System.out.println("What is the length of the annuity in years?");
        double annuityLengthYears = input.nextDouble();

        double monthlyInterest = monthlyInterestPercentage / 100;
        double annuityLengthMonths = annuityLengthYears * 12;

        double presentValue = monthlyPayout *
                ((1 - Math.pow(1 + monthlyInterest, annuityLengthMonths * -1)) / monthlyInterest);

        System.out.printf("The present value of the annuity would be $%.2f.", presentValue);

    }

}
