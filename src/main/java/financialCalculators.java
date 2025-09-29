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
                """);

        int whichCalc = input.nextInt();
        input.nextLine();

        switch (whichCalc) {
            case 1:
                mortageCalc();
                break;
            case 2:
                interestCalc();
                break;
            case 3:
                annuityCalc();
                break;
            default:
                System.out.println("Incorrect selection, please rerun program.");
        }

        }

    }




}
