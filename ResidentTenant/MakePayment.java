/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ResidentandTenant;

/**
 *
 * @author 60192
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakePayment {

    public void MakePayment() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter resident ID: ");
        String residentId = scanner.nextLine();

        double totalAmount = 0.0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resident_invoice.txt"));
            String line;
            boolean foundResident = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID: " + residentId)) {
                    foundResident = true;
                } else if (foundResident) {
                    if (line.startsWith("Amount: ")) {
                        totalAmount += Double.parseDouble(line.substring(8));
                    } else if (line.startsWith("ID: ")) {
                        break;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        if (totalAmount == 0.0) {
            System.out.println("No invoices found for resident " + residentId);
            return;
        }

        System.out.printf("Total amount due: %.2f\n", totalAmount);

        while (true) {
            try {
                System.out.print("Enter payment amount: ");
                double paymentAmount = scanner.nextDouble();
                scanner.nextLine(); // consume the remaining newline character

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter card number: ");
                String cardNumber = scanner.nextLine();

                System.out.print("Enter expiry date (MM/YY): ");
                String expiryDate = scanner.nextLine();

                PaymentDetails paymentDetails = new PaymentDetails() {

                    @Override
                    public String getName() {
                        return name;
                    }

                    @Override
                    public String getCardNumber() {
                        return cardNumber;
                    }

                    @Override
                    public String getExpiryDate() {
                        return expiryDate;
                    }
                };

                if (paymentAmount < totalAmount) {
                    System.out.println("Insufficient payment amount!");
                } else {
                    boolean success = Payment.performPayment(paymentAmount, paymentDetails);

                    if (success) {
                        try {
                            FileWriter writer = new FileWriter("residentpayment_history.txt", true);
                            writer.write("Resident ID: " + residentId + "\nAmount charged: " + totalAmount + "\nAmount paid: " + paymentAmount + "\n");
                            writer.write("\n");
                            writer.close();
                        } catch (IOException e) {
                            System.out.println("Error writing to file: " + e.getMessage());
                        }
                        System.out.println("Payment successful.");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter valid input.");
                scanner.nextLine(); // consume the remaining newline character
            }
        }
    }

}

class Payment {

    public static boolean performPayment(double amount, PaymentDetails paymentDetails) {
        // Your payment logic goes here
        // You can use paymentDetails.getCardNumber() and paymentDetails.getExpiryDate() to get the payment card details
        // Return true if payment was successful, false otherwise
        return true;
    }

}
