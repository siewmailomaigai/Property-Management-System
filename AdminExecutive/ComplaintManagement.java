/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminExecutive;

/**
 *
 * @author 60192
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ComplaintManagement {

    private String complaintID, name, date, complaintType, complaintStatus;
    Scanner input = new Scanner(System.in);
    Scanner search4 = new Scanner(System.in);
    int choice, cont;
    public static final String FILE_NAME5 = "C:\\Users\\60192\\Documents\\NetBeansProjects\\PropertyManagementSystem\\src\\AdminExecutive\\complaints.txt";
    ArrayList<ComplaintManagement> complaint = new ArrayList<>(10);

    public ComplaintManagement() {
    }

    public ComplaintManagement(String complaintID, String name, String date, String complaintType, String complaintStatus) {
        this.complaintID = complaintID;
        this.name = name;
        this.date = date;
        this.complaintType = complaintType;
        this.complaintStatus = complaintStatus;
    }

    public String getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(String complaintID) {
        this.complaintID = complaintID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public void newComplaint() {
        System.out.println("Enter complaintID: ");
        complaintID = input.nextLine();
        System.out.println("Enter customer name: ");
        name = input.nextLine();
        System.out.println("Enter date of complaint: ");
        date = input.nextLine();
        System.out.println("Enter complaint type: ");
        complaintType = input.nextLine();
        System.out.println("Enter complaint status: ");
        complaintStatus = input.nextLine();

    }

    public void showComplaintInfo() {
        System.out.println("Complaints: ");
        System.out.println("Complaint ID: " + getComplaintID());
        System.out.println("Customer Name: " + getName());
        System.out.println("Date of complaint: " + getDate());
        System.out.println("Type of complaint: " + getComplaintType());
        System.out.println("Complaint Status: " + getComplaintStatus());

    }

    public void runComplaint() {

        do {
            System.out.println("1.Add New Complaint\n2.View Complaint\n3.Update Complaint");
            choice = input.nextInt();

            //add or new resident/tenant details
            switch (choice) {
                case 1 -> {
                    ComplaintManagement add = new ComplaintManagement();
                    add.addComplaint();

                }
                case 2 -> {
                    ComplaintManagement view = new ComplaintManagement();
                    view.viewComplaint();

                }
                case 3 -> {
                    ComplaintManagement update = new ComplaintManagement();
                    update.updateComplaint();

                }

                default ->
                    System.out.println("\nWrong input! Please try again!");
            }

            System.out.println("\nPlease Press 1 to Return to Back and Press 0 for Return to Main Menu.");
            cont = input.nextInt();

        } while (cont != 0);
    }

    public void addComplaint() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME5))) {

                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    ComplaintManagement newC = new ComplaintManagement();
                    if (parts.length >= 5) {
                        newC.setComplaintID(parts[0]);
                        newC.setName(parts[1]);
                        newC.setDate(parts[2]);
                        newC.setComplaintType(parts[3]);
                        newC.setComplaintStatus(parts[4]);
                    }
                    complaint.add(newC);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'complaints.txt' was not found.");
        }

        ComplaintManagement newC2 = new ComplaintManagement();
        newC2.newComplaint();
        complaint.add(newC2);

        //newRT.addToFile();
        try {
            try (FileWriter infile = new FileWriter(FILE_NAME5)) {
                for (int i = 0; i < complaint.size(); i++) {
                    infile.append(complaint.get(i).getComplaintID() + " "
                            + complaint.get(i).getName() + " "
                            + complaint.get(i).getDate() + " "
                            + complaint.get(i).getComplaintType() + " "
                            + complaint.get(i).getComplaintStatus() + "\n");
                }
            }
        } catch (IOException ev) {
            System.out.println("An error occured when writing into the file.");
        }
    }

    public void viewComplaint() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME5))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    ComplaintManagement newC = new ComplaintManagement();
                    newC.setComplaintID(parts[0]);
                    newC.setName(parts[1]);
                    newC.setDate(parts[2]);
                    newC.setComplaintType(parts[3]);
                    newC.setComplaintStatus(parts[4]);
                    complaint.add(newC);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'complaints.txt' was not found.");
        }

        for (int x = 0; x < complaint.size(); x++) {
            complaint.get(x).showComplaintInfo();
        }
    }

    public void updateComplaint() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME5))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    ComplaintManagement newC = new ComplaintManagement();
                    if (parts.length >= 5) {
                        newC.setComplaintID(parts[0]);
                        newC.setName(parts[1]);
                        newC.setDate(parts[2]);
                        newC.setComplaintType(parts[3]);
                        newC.setComplaintStatus(parts[4]);
                    }
                    complaint.add(newC);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'complaints.txt' was not found.");
        }

        System.out.print("Enter the complaintID: ");
        String checkComplaintID = search4.nextLine();
        boolean found = false;
        for (int a = 0; a < complaint.size(); a++) {
            if (complaint.get(a).getComplaintID().equalsIgnoreCase(checkComplaintID)) {
                found = true;
                System.out.println("Select the field you want to modify");
                System.out.println("1. Customer Name");
                System.out.println("2. Date");
                System.out.println("3. Type of Complaint");
                System.out.println("4. Status of Complaint");
                System.out.println("5. Cancel");
                System.out.print("Enter choice: ");
                int choice = input.nextInt();
                input.nextLine();
                ComplaintManagement c = complaint.get(a);
                switch (choice) {
                    case 1 -> {

                        System.out.print("Enter new customer name: ");
                        String name = input.nextLine();
                        c.setName(name);
                    }
                    case 2 -> {
                        System.out.print("Enter new date: ");
                        String date = input.nextLine();
                        c.setDate(date);
                    }
                    case 3 -> {
                        System.out.print("Enter new type of complaint: ");
                        String complaintType = input.nextLine();
                        c.setComplaintType(complaintType);
                    }

                    case 4 -> {
                        System.out.print("Enter new status of complaint: ");
                        String complaintStatus = input.nextLine();
                        c.setComplaintStatus(complaintStatus);
                    }

                    default ->
                        System.out.println("Invalid input.");
                }

                complaint.set(a, c);
                System.out.println("Update successful!");
                break;
            }
        }
        if (!found) {
            System.out.println("Complaint not found.");
        } else {
            try {
                try (FileWriter infile = new FileWriter(FILE_NAME5)) {
                    for (int i = 0; i < complaint.size(); i++) {
                        infile.append(complaint.get(i).getComplaintID() + " "
                                + complaint.get(i).getName() + " "
                                + complaint.get(i).getDate() + " "
                                + complaint.get(i).getComplaintType() + " "
                                + complaint.get(i).getComplaintStatus() + "\n");
                    }
                }
            } catch (IOException ev) {
                System.out.println("An error occured when writing into the file.");
            }
        }

    }
}

