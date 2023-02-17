/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminExecutive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author 60192
 */
public class FacilityManagement {

    public String facilityName;
    public int capacity;
    private String facilityLocation;
    private double hourlyRate;
    Scanner input = new Scanner(System.in);
    Scanner search2 = new Scanner(System.in);
    public static final String FILE_NAME2 = "C:\\Users\\60192\\Documents\\NetBeansProjects\\PropertyManagementSystem\\src\\AdminExecutive\\facilitymanagement.txt";
    ArrayList<FacilityManagement> facility = new ArrayList<>(10);
    final static int MAX_CAPACITY = 2;
    int choice, cont;

    //default constructor
    public FacilityManagement() {
    }

    public FacilityManagement(String facilityName, int capacity, String facilityLocation, double hourlyRate) {
        this.facilityName = facilityName;
        this.capacity = capacity;
        this.facilityLocation = facilityLocation;
        this.hourlyRate = hourlyRate;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFacilityLocation() {
        return facilityLocation;
    }

    public void setFacilityLocation(String facilityLocation) {
        this.facilityLocation = facilityLocation;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void newFacility() {
        System.out.println("Enter facility name: ");
        facilityName = input.nextLine();
        System.out.println("Enter facility capacity: ");
        capacity = input.nextInt();
        input.nextLine();
        System.out.println("Enter facility location: ");
        facilityLocation = input.nextLine();
        System.out.println("Enter hourly rate: ");
        hourlyRate = input.nextDouble();

    }

    public void showFacilityInfo() {
        System.out.println("Facility Information:");
        System.out.println("Facility Name: " + getFacilityName());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Facility Location: " + getFacilityLocation());
        System.out.println("Hourly Rate: " + getHourlyRate());
        System.out.println("\n");
    }

    public void runFacility() {

        do {
            System.out.println("1.Add facility\n2.View facilities\n3.Update\n4.Delete information");
            choice = input.nextInt();

            //add or new resident/tenant details
            switch (choice) {
                case 1 -> {
                    FacilityManagement add = new FacilityManagement();
                    add.addFacility();

                }

                case 2 -> {
                    FacilityManagement view = new FacilityManagement();
                    view.viewFacility();

                }
                case 3 -> {
                    FacilityManagement update = new FacilityManagement();
                    update.updateFacility();

                }
                case 4 -> {
                    FacilityManagement delete = new FacilityManagement();
                    delete.deleteFacility();
                }

                default ->
                    System.out.println("\nWrong input! Please try again!");
            }

            System.out.println("\nPlease Press 1 to Return to Back and Press 0 for Return to Main Menu.");
            cont = input.nextInt();

        } while (cont != 0);
    }

    public void addFacility() {
        try {
            Scanner scan = new Scanner(new File(FILE_NAME2));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(" ");
                FacilityManagement newFac = new FacilityManagement();
                if (parts.length >= 5) {
                    newFac.setFacilityName(parts[0]);
                    newFac.setCapacity(Integer.parseInt(parts[1]));
                    newFac.setFacilityLocation(parts[2]);
                    newFac.setHourlyRate(Double.parseDouble(parts[3]));
                }
                facility.add(newFac);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file 'facilitymanagement.txt' was not found.");
        }

        FacilityManagement newFac2 = new FacilityManagement();
        newFac2.newFacility();
        facility.add(newFac2);

        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME2, true); // Set the second argument to true to append to the end of the file.
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(newFac2.getFacilityName() + " " + newFac2.getCapacity() + " " + newFac2.getFacilityLocation() + " " + newFac2.getHourlyRate());
            printWriter.close();
        } catch (IOException ev) {
            System.out.println("An error occured when writing into the file.");
        }
    }

    public void viewFacility() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME2))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    FacilityManagement newFac = new FacilityManagement();
                    if (parts.length >= 4) {
                        newFac.setFacilityName(parts[0]);
                        newFac.setCapacity(Integer.parseInt(parts[1]));
                        newFac.setFacilityLocation(parts[2]);
                        newFac.setHourlyRate(Double.parseDouble(parts[3]));
                    }
                    facility.add(newFac);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'facilitymanagament.txt' was not found.");
        }

        for (int x = 0; x < facility.size(); x++) {
            facility.get(x).showFacilityInfo();
        }
    }

    public void updateFacility() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME2))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    FacilityManagement newFac = new FacilityManagement();
                    if (parts.length >= 4) {
                        newFac.setFacilityName(parts[0]);
                        newFac.setCapacity(Integer.parseInt(parts[1]));
                        newFac.setFacilityLocation(parts[2]);
                        newFac.setHourlyRate(Double.parseDouble(parts[3]));
                    }
                    facility.add(newFac);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'facilitymanagement.txt' was not found.");
        }

        System.out.print("Enter the facility name: ");
        String checkFacilityName = search2.nextLine();
        boolean found = false;
        for (int a = 0; a < facility.size(); a++) {
            if (facility.get(a).getFacilityName().equalsIgnoreCase(checkFacilityName)) {
                found = true;
                System.out.println("Select the field you want to modify");
                System.out.println("1. Capacity");
                System.out.println("2. Facility Location");
                System.out.println("3. Hourly Rate");
                System.out.println("4. Cancel");
                System.out.print("Enter choice: ");
                int choice = input.nextInt();
                input.nextLine();
                FacilityManagement fac = facility.get(a);
                switch (choice) {
                    case 1 -> {

                        System.out.print("Enter new capacity: ");
                        int capacity = input.nextInt();
                        fac.setCapacity(capacity);
                    }
                    case 2 -> {
                        System.out.print("Enter new facility location: ");
                        String facilitylocation = input.nextLine();
                        fac.setFacilityLocation(facilitylocation);
                    }
                    case 3 -> {
                        System.out.print("Enter new hourly rate: ");
                        double hourlyRate = input.nextDouble();
                        fac.setHourlyRate(hourlyRate);
                    }

                    default ->
                        System.out.println("Invalid input.");
                }

                facility.set(a, fac);
                System.out.println("Update successful!");
                break;
            }
        }
        if (!found) {
            System.out.println("Facility not found.");
        } else {
            try {
                try (FileWriter infile = new FileWriter(FILE_NAME2)) {
                    for (int i = 0; i < facility.size(); i++) {
                        infile.append(facility.get(i).getFacilityName() + " "
                                + facility.get(i).getCapacity() + " "
                                + facility.get(i).getFacilityLocation() + " "
                                + facility.get(i).getHourlyRate() + "\n");

                    }
                }
            } catch (IOException ev) {
                System.out.println("An error occured when writing into the file.");
            }
        }
    }

    public void deleteFacility() {
        System.out.print("Enter the facility name to be deleted: ");
        Scanner scan = new Scanner(System.in);
        String facilityNameToDelete = scan.nextLine();

        StringBuilder contentBuilder = new StringBuilder();
        boolean residentFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME2))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] parts = currentLine.split(" ");
                String name = (parts[0]);
                if (name.equals(facilityNameToDelete)) {
                    residentFound = true;
                } else {
                    contentBuilder.append(currentLine).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!residentFound) {
            System.out.println("Facility with name " + facilityNameToDelete + " was not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME2))) {
            bw.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Deleted the facility: " + facilityNameToDelete);
    }

}

