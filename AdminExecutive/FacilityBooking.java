/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminExecutive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 60192
 */
public class FacilityBooking extends FacilityManagement {

    private String bookingDate;
    private int startTime;
    private int endTime;
    private String bookedBy;
    public static final String FILE_NAME3 = "C:\\Users\\60192\\Documents\\NetBeansProjects\\PropertyManagementSystem\\src\\AdminExecutive\\facilitybooking.txt";
    ArrayList<FacilityBooking> facilityB = new ArrayList<>(10);

    public FacilityBooking() {
        super();
    }

    public FacilityBooking(String facilityName, int capacity, String bookingDate, int startTime, int endTime, String bookedBy) {
        super();
        this.facilityName = facilityName;
        this.capacity = capacity;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookedBy = bookedBy;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public void newFacilityB() {
        System.out.println("Enter facility name(gym, basketball court, pool, snooker): ");
        facilityName = input.nextLine();
        System.out.println("Enter booking date: ");
        bookingDate = input.nextLine();
        System.out.println("Enter start time: ");
        startTime = input.nextInt();
        System.out.println("Enter end time: ");
        endTime = input.nextInt();
        input.nextLine();
        System.out.println("Booked by? : ");
        bookedBy = input.nextLine();
    }

    public void showBookingInfo() {
        System.out.println("Booking Information:");
        System.out.println("Facility Name: " + getFacilityName());
        System.out.println("Date: " + getBookingDate());
        System.out.println("Start Time: " + getStartTime());
        System.out.println("End Time: " + getEndTime());
        System.out.println("Booked By: " + getBookedBy());
        System.out.println("\n");

    }

    public void runFacilityBooking() {

        do {
            System.out.println("1.New booking\n2.View bookings\n3.Update booking\n4.Delete booking");
            choice = input.nextInt();

            //add or new resident/tenant details
            switch (choice) {
                case 1 -> {
                    FacilityBooking add = new FacilityBooking();
                    add.addFacilityB();

                }

                case 2 -> {
                    FacilityBooking view = new FacilityBooking();
                    view.viewFacilityB();

                }
                case 3 -> {
                    FacilityBooking update = new FacilityBooking();
                    update.updateFacilityB();

                }
                case 4 -> {
                    FacilityBooking delete = new FacilityBooking();
                    delete.deleteFacilityB();
                }

                default ->
                    System.out.println("\nWrong input! Please try again!");
            }

            System.out.println("\nPlease Press 1 to Return to Back and Press 0 for Return to Main Menu.");
            cont = input.nextInt();

        } while (cont != 0);
    }

    public void addFacilityB() {
        try {
            Scanner scan = new Scanner(new File(FILE_NAME3));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(" ");
                FacilityBooking newFacb = new FacilityBooking();
                if (parts.length >= 5) {
                    newFacb.setFacilityName(parts[0]);
                    newFacb.setBookingDate(parts[1]);
                    newFacb.setStartTime(Integer.parseInt(parts[2]));
                    newFacb.setEndTime(Integer.parseInt(parts[3]));
                    newFacb.setBookedBy(parts[4]);
                }
                facilityB.add(newFacb);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file 'facilitybooking.txt' was not found.");
        }

        FacilityBooking newFacb2 = new FacilityBooking();
        newFacb2.newFacilityB();

        int count = 0;
        for (FacilityBooking fb : facilityB) {
            if (fb.getFacilityName().equals(newFacb2.getFacilityName())) {
                count++;
            }
        }

        if (count >= FacilityManagement.MAX_CAPACITY) {
            System.out.println("Sorry, the facility is fully booked.");
            return;
        }

        facilityB.add(newFacb2);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME3, true));
            writer.write(newFacb2.getFacilityName() + " "
                    + newFacb2.getBookingDate() + " "
                    + newFacb2.getStartTime() + " "
                    + newFacb2.getEndTime() + " "
                    + newFacb2.getBookedBy() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while updating the file.");
        }
    }

    public void viewFacilityB() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME3))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    FacilityBooking newFacb = new FacilityBooking();
                    if (parts.length >= 5) {
                        newFacb.setFacilityName(parts[0]);
                        newFacb.setBookingDate(parts[1]);
                        newFacb.setStartTime(Integer.parseInt(parts[2]));
                        newFacb.setEndTime(Integer.parseInt(parts[3]));
                        newFacb.setBookedBy(parts[4]);
                    }
                    facilityB.add(newFacb);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'facilitybooking.txt' was not found.");
        }

        for (int x = 0; x < facilityB.size(); x++) {
            facilityB.get(x).showBookingInfo();
        }
    }

    public void updateFacilityB() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME3))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    FacilityBooking newFacb = new FacilityBooking();
                    if (parts.length >= 5) {
                        newFacb.setFacilityName(parts[0]);
                        newFacb.setBookingDate(parts[1]);
                        newFacb.setStartTime(Integer.parseInt(parts[2]));
                        newFacb.setEndTime(Integer.parseInt(parts[3]));
                        newFacb.setBookedBy(parts[4]);
                    }

                    facilityB.add(newFacb);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'facilitybooking.txt' was not found.");
        }

        System.out.print("Booked by? : ");
        String checkName = search2.nextLine();
        boolean found = false;
        for (int a = 0; a < facilityB.size(); a++) {
            if (facilityB.get(a).getBookedBy().equalsIgnoreCase(checkName)) {
                found = true;
                System.out.println("Select the field you want to modify");
                System.out.println("1. Facility Name");
                System.out.println("2. Booking Date");
                System.out.println("3. Start Time");
                System.out.println("4. End Time");
                System.out.println("5. Cancel");
                System.out.print("Enter choice: ");
                int choice = input.nextInt();
                input.nextLine();
                FacilityBooking facb = facilityB.get(a);
                switch (choice) {

                    case 1 -> {
                        System.out.print("Enter new facility name: ");
                        String facilityName = input.nextLine();
                        facb.setFacilityName(facilityName);
                    }
                    case 2 -> {

                        System.out.print("Enter new Booking Date: ");
                        String bookingDate = input.nextLine();
                        facb.setBookingDate(bookingDate);
                    }
                    case 3 -> {
                        System.out.print("Enter new Start Time: ");
                        int startTime = input.nextInt();
                        facb.setStartTime(startTime);
                    }
                    case 4 -> {
                        System.out.print("Enter new End Time: ");
                        int endTime = input.nextInt();
                        facb.setEndTime(endTime);
                    }

                    default ->
                        System.out.println("Invalid input.");
                }

                facilityB.set(a, facb);
                System.out.println("Update successful!");
                break;
            }
        }
        if (!found) {
            System.out.println("Person not found.");
        } else {
            try {
                try (FileWriter infile = new FileWriter(FILE_NAME3)) {
                    for (int i = 0; i < facilityB.size(); i++) {
                        infile.append(facilityB.get(i).getFacilityName() + " "
                                + facilityB.get(i).getBookingDate() + " "
                                + facilityB.get(i).getStartTime() + " "
                                + facilityB.get(i).getEndTime() + " "
                                + facilityB.get(i).getBookedBy() + "\n");
                    }
                }
            } catch (IOException ev) {
                System.out.println("An error occured when writing into the file.");
            }
        }
    }

    public void deleteFacilityB() {
        System.out.print("Enter person's name to be deleted: ");
        Scanner scan = new Scanner(System.in);
        String personNameToDelete = scan.nextLine();

        StringBuilder contentBuilder = new StringBuilder();
        boolean residentFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME3))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] parts = currentLine.split(" ");
                String name = (parts[4]);
                if (name.equals(personNameToDelete)) {
                    residentFound = true;
                } else {
                    contentBuilder.append(currentLine).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!residentFound) {
            System.out.println("Person with name " + personNameToDelete + " was not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME3))) {
            bw.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Deleted the person with name: " + personNameToDelete);
    }

}

