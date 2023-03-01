/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BuildingManager;

/**
 *
 * @author 60192
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class View {

    private static final String SCHEDULES_FILE = "schedules.txt";
    private static final String COMPLAINTS_FILE = "complaints.txt";
    private static final String EMPLOYEE_FILE = "employee.txt";
    private static final String RESIDENT_FILE = "residentfile.txt";

    public void viewPatrolling() {
        int count = countLines(SCHEDULES_FILE);
        System.out.println("Total number of patrolling records: " + count);
    }

    public void viewComplaints() {
        int count = countLines(COMPLAINTS_FILE);
        System.out.println("Total number of complaints records: " + count);
    }

    public void viewJobReports() {
        int count = countLines(EMPLOYEE_FILE);
        System.out.println("Total number of job reports records: " + count);
    }

    public void viewResidentTenantReport() {
        int count = countLines(RESIDENT_FILE);
        System.out.println("Total number of residents: " + count);
    }

    private int countLines(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void showOptions() {
        System.out.println("Please select an option:");
        System.out.println("1. View patrolling");
        System.out.println("2. View complaints");
        System.out.println("3. View job reports");
        System.out.println("4. View resident/tenant report");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                viewPatrolling();
                break;
            case 2:
                viewComplaints();
                break;
            case 3:
                viewJobReports();
                break;
            case 4:
                viewResidentTenantReport();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

}
