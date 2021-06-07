package base;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Marc-Anthony Cross
 */

/*
 * Working with multiple inputs and currency can introduce some tricky precision issues.
 *
 * Create a simple self-checkout system. Prompt for the prices and quantities of three items. Calculate the subtotal of
 * the items. Then calculate the tax using a tax rate of 5.5%. Print out the line items with the quantity and total,
 * and then print out the subtotal, tax amount, and total.
 * Example Output
 *
 * Enter the price of item 1: 25
 * Enter the quantity of item 1: 2
 * Enter the price of item 2: 10
 * Enter the quantity of item 2: 1
 * Enter the price of item 3: 4
 * Enter the quantity of item 3: 1
 * Subtotal: $64.00
 * Tax: $3.52
 * Total: $67.52
 *
 * Constraints
 *
 *     Keep the input, processing, and output parts of your program separate. Collect the input, then do the math operations and string building, and then print out the output.
 *     Be sure you explicitly convert input to numerical data before doing any calculations.
 *
 * Challenges
 *
 *     Revise the program to ensure that prices and quantities are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
 *     Alter the program so that an indeterminate number of items can be entered. The tax and total are computed when there are no more items to be entered.
 *
 */

public class App {
    static Scanner in = new Scanner(System.in);
    static final double TAX_RATE = 0.055;

    public static void main(String[] args) {
        App myApp = new App();

        String firstPrice = myApp.getFirstPrice();
        String firstQuantity = myApp.getFirstQuantity();
        String firstTotal = myApp.calcFirstTotal(firstPrice, firstQuantity);

        String secondPrice = myApp.getSecondPrice();
        String secondQuantity = myApp.getSecondQuantity();
        String secondTotal = myApp.calcSecondTotal(secondPrice, secondQuantity);

        String thirdPrice = myApp.getThirdPrice();
        String thirdQuantity = myApp.getThirdQuantity();
        String thirdTotal = myApp.calcThirdTotal(thirdPrice, thirdQuantity);

        String subtotal = myApp.calcSubtotal(firstTotal, secondTotal, thirdTotal);
        String tax = myApp.calcTax(subtotal);
        String total = myApp.calcTotal(subtotal, tax);

        String outputString = myApp.generateOutput(subtotal, tax, total);
        myApp.printOutput(outputString);
    }


    private void printOutput(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutput(String subtotal, String tax, String total) {
        return "Subtotal: $" + subtotal + "\nTax: $" + tax + "\nTotal: $" + total;
    }

    private String getFirstPrice() {
        System.out.print("Enter the price of item 1: ");
        String firstPrice = in.nextLine();
        return firstPrice;
    }

    private String getFirstQuantity() {
        System.out.print("Enter the quantity of item 1: ");
        String firstQuantity = in.nextLine();
        return firstQuantity;
    }

    private String calcFirstTotal(String firstPrice, String firstQuantity) {
        double firstTotal = Double.parseDouble(firstPrice) * Double.parseDouble(firstQuantity);
        return String.valueOf(firstTotal);
    }

    private String getSecondPrice() {
        System.out.print("Enter the price of item 2: ");
        String secondPrice = in.nextLine();
        return secondPrice;
    }

    private String getSecondQuantity() {
        System.out.print("Enter the quantity of item 2: ");
        String secondQuantity = in.nextLine();
        return secondQuantity;
    }

    private String calcSecondTotal(String secondPrice, String secondQuantity) {
        double secondTotal = Double.parseDouble(secondPrice) * Double.parseDouble(secondQuantity);
        return String.valueOf(secondTotal);
    }

    private String getThirdPrice() {
        System.out.print("Enter the price of item 3: ");
        String thirdPrice = in.nextLine();
        return thirdPrice;
    }

    private String getThirdQuantity() {
        System.out.print("Enter the quantity of item 3: ");
        String thirdQuantity = in.nextLine();
        return thirdQuantity;
    }

    private String calcThirdTotal(String thirdPrice, String thirdQuantity) {
        double thirdTotal = Double.parseDouble(thirdPrice) * Double.parseDouble(thirdQuantity);
        return String.valueOf(thirdTotal);
    }

    private String calcSubtotal(String firstTotal, String secondTotal, String thirdTotal) {
        double subtotal = Double.parseDouble(firstTotal) + Double.parseDouble(secondTotal) + Double.parseDouble(thirdTotal);
        return String.valueOf(subtotal);
    }

    private String calcTax(String subtotal) {
        double tax = Double.parseDouble(subtotal) * TAX_RATE;
        return String.valueOf(tax);
    }

    private String calcTotal(String subtotal, String tax) {
        double total = Double.parseDouble(subtotal) + Double.parseDouble(tax);
        return String.valueOf(total);
    }
}
