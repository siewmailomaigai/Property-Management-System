/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountExecutive;

/**
 *
 * @author 60192
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OutstandingFee {

    public void addOutstanding() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("1. Resident");
        System.out.println("2. Vendor");
        int option = scanner.nextInt();
        String filename;
        String idType;
        String fileType;
        switch (option) {
            case 1:
                System.out.println("Adding outstanding fee for a resident:");
                idType = "Resident ID";
                fileType = "resident";
                break;
            case 2:
                System.out.println("Adding outstanding fee for a vendor:");
                idType = "Vendor ID";
                fileType = "vendor";
                break;
            default:
                System.out.println("Invalid option selected.");
                return;
        }

        System.out.println("Select an option:");
        System.out.println("1. Add invoice");
        System.out.println("2. Add statement");
        System.out.println("3. Add receipt");
        int option2 = scanner.nextInt();
        String id;
        switch (option2) {
            case 1:
                System.out.println("Adding an invoice:");
                filename = fileType + "_invoice.txt";
                break;
            case 2:
                System.out.println("Adding a statement:");
                filename = fileType + "_statement.txt";
                break;
            case 3:
                System.out.println("Adding a receipt:");
                filename = fileType + "_receipt.txt";
                break;
            default:
                System.out.println("Invalid option selected.");
                return;
        }

        System.out.printf("Enter %s: ", idType);
        scanner.nextLine(); // consume the newline character left by scanner.nextInt()
        id = scanner.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean found = false;
            StringBuilder record = new StringBuilder();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(": ");
                if (fields.length >= 2 && fields[1].equals(id)) {
                    found = true;
                    record.append(line).append("\n\n");
                    while ((line = br.readLine()) != null && !line.isEmpty()) {
                        record.append(line).append("\n");
                    }
                    record.append("\n");
                }
            }
            if (!found) {
                System.out.println("No record found with " + idType + " " + id);
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("outstandingFee.txt", true))) {
                bw.write(record.toString());
                System.out.println("Records added to outstandingFee.txt.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public void viewOutstanding() {
        try (BufferedReader br = new BufferedReader(new FileReader("outstandingFee.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

}
