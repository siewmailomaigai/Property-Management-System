/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BuildingManager;

/**
 *
 * @author 60192
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Budget {

    private int year;
    private double[] budgets;
    private double[] maintenance;

    public Budget(int year) throws IOException {
        this.year = year;
        budgets = new double[12];
        maintenance = new double[12];

        // Load budgets from budgets.txt file
        Scanner budgetsScanner = new Scanner(new File("budgets.txt"));
        while (budgetsScanner.hasNextLine()) {
            String[] budgetDetails = budgetsScanner.nextLine().split(",");
            if (Integer.parseInt(budgetDetails[0]) == year) {
                for (int i = 0; i < 12; i++) {
                    budgets[i] = Double.parseDouble(budgetDetails[i + 1]);
                }
                break;
            }
        }
        budgetsScanner.close();

        // Load maintenance from maintenance.txt file
        Scanner maintenanceScanner = new Scanner(new File("maintenance.txt"));
        while (maintenanceScanner.hasNextLine()) {
            String[] maintenanceDetails = maintenanceScanner.nextLine().split(",");
            if (Integer.parseInt(maintenanceDetails[0]) == year) {
                for (int i = 0; i < 12; i++) {
                    maintenance[i] = Double.parseDouble(maintenanceDetails[i + 1]);
                }
                break;
            }
        }
        maintenanceScanner.close();
    }

    // Method to calculate the total amount spent on maintenance for a specific year
    public double calculateMaintenanceCost() {
        double total = 0;
        for (double m : maintenance) {
            total += m;
        }
        return total;
    }

    // Method to calculate the total amount allocated for a specific month
    public double calculateAllocation(int month) {
        return budgets[month - 1];
    }

    // Method to set the budget for a specific month
    public void setBudget(int month, double budget) throws IOException {
        budgets[month - 1] = budget;

        // Save the updated budget to budgets.txt file
        FileWriter writer = new FileWriter("budgets.txt");
        writer.write(Integer.toString(year) + ",");
        for (double b : budgets) {
            writer.write(Double.toString(b) + ",");
        }
        writer.close();
    }

    // Method to set the maintenance cost for a specific month
    public void setMaintenance(int month, double cost) throws IOException {
        maintenance[month - 1] = cost;

        // Save the updated maintenance cost to maintenance.txt file
        FileWriter writer = new FileWriter("maintenance.txt");
        writer.write(Integer.toString(year) + ",");
        for (double m : maintenance) {
            writer.write(Double.toString(m) + ",");
        }
        writer.close();
    }
}
