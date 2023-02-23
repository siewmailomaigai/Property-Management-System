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

public class EmployeeManagement {

    private String name, contactInfo, department, jobTitle, dateOfHire;
    Scanner input = new Scanner(System.in);
    Scanner search3 = new Scanner(System.in);
    int choice, cont;
    public static final String FILE_NAME4 = "employee.txt";
    ArrayList<EmployeeManagement> employee = new ArrayList<>(10);

    public EmployeeManagement() {
    }

    public EmployeeManagement(String name, String contactInfo, String department, String jobTitle, String dateOfHire) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.department = department;
        this.jobTitle = jobTitle;
        this.dateOfHire = dateOfHire;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(String dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public void newEmployee() {
        System.out.println("Enter employee name: ");
        name = input.nextLine();
        System.out.println("Enter contact information: ");
        contactInfo = input.nextLine();
        System.out.println("Enter department: ");
        department = input.nextLine();
        System.out.println("Enter job title: ");
        jobTitle = input.nextLine();
        System.out.println("Enter date of hire: ");
        dateOfHire = input.nextLine();

    }

    public void showEmployeeInfo() {
        System.out.println("Employee Information:");
        System.out.println("Employee Name: " + getName());
        System.out.println("Contact information: " + getContactInfo());
        System.out.println("Department: " + getDepartment());
        System.out.println("Job title: " + getJobTitle());
        System.out.println("Date of hire: " + getDateOfHire());
    }

    public void runEmployee() {

        do {
            System.out.println("1.Add New Employee\n2.View Employee\n3.Update Employee");
            choice = input.nextInt();

            //add or new resident/tenant details
            switch (choice) {
                case 1 -> {
                    EmployeeManagement add = new EmployeeManagement();
                    add.addEmployee();

                }
                case 2 -> {
                    EmployeeManagement view = new EmployeeManagement();
                    view.viewEmployee();

                }
                case 3 -> {
                    EmployeeManagement update = new EmployeeManagement();
                    update.updateEmployee();

                }

                default ->
                    System.out.println("\nWrong input! Please try again!");
            }

            System.out.println("\nPlease Press 1 to Return to Back and Press 0 for Return to Main Menu.");
            cont = input.nextInt();

        } while (cont != 0);
    }

    public void addEmployee() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME4))) {

                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    EmployeeManagement newE = new EmployeeManagement();
                    if (parts.length >= 5) {
                        newE.setName(parts[0]);
                        newE.setContactInfo(parts[1]);
                        newE.setDepartment(parts[2]);
                        newE.setJobTitle(parts[3]);
                        newE.setDateOfHire(parts[4]);
                    }
                    employee.add(newE);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'employee.txt' was not found.");
        }

        EmployeeManagement newE2 = new EmployeeManagement();
        newE2.newEmployee();
        employee.add(newE2);

        //newRT.addToFile();
        try {
            try (FileWriter infile = new FileWriter(FILE_NAME4)) {
                for (int i = 0; i < employee.size(); i++) {
                    infile.append(employee.get(i).getName() + " "
                            + employee.get(i).getContactInfo() + " "
                            + employee.get(i).getDepartment() + " "
                            + employee.get(i).getJobTitle() + " "
                            + employee.get(i).getDateOfHire() + "\n");
                }
            }
        } catch (IOException ev) {
            System.out.println("An error occured when writing into the file.");
        }
    }

    public void viewEmployee() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME4))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    EmployeeManagement newE = new EmployeeManagement();
                    newE.setName(parts[0]);
                    newE.setContactInfo(parts[1]);
                    newE.setDepartment(parts[2]);
                    newE.setJobTitle(parts[3]);
                    newE.setDateOfHire(parts[4]);
                    employee.add(newE);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'employee.txt' was not found.");
        }

        for (int x = 0; x < employee.size(); x++) {
            employee.get(x).showEmployeeInfo();
        }
    }

    public void updateEmployee() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME4))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    EmployeeManagement newE = new EmployeeManagement();
                    if (parts.length >= 5) {
                        newE.setName(parts[0]);
                        newE.setContactInfo(parts[1]);
                        newE.setDepartment(parts[2]);
                        newE.setJobTitle(parts[3]);
                        newE.setDateOfHire(parts[4]);
                    }
                    employee.add(newE);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'employee.txt' was not found.");
        }

        System.out.print("Enter the employee name: ");
        String checkName = search3.nextLine();
        boolean found = false;
        for (int a = 0; a < employee.size(); a++) {
            if (employee.get(a).getName().equalsIgnoreCase(checkName)) {
                found = true;
                System.out.println("Select the field you want to modify");
                System.out.println("1. Contact Information");
                System.out.println("2. Department");
                System.out.println("3. Job Title");
                System.out.println("4. Date of Hire");
                System.out.println("5. Cancel");
                System.out.print("Enter choice: ");
                int choice = input.nextInt();
                input.nextLine();
                EmployeeManagement e = employee.get(a);
                switch (choice) {
                    case 1 -> {

                        System.out.print("Enter new Contact Info: ");
                        String contactInfo = input.nextLine();
                        e.setContactInfo(contactInfo);
                    }
                    case 2 -> {
                        System.out.print("Enter new department: ");
                        String department = input.nextLine();
                        e.setDepartment(department);
                    }
                    case 3 -> {
                        System.out.print("Enter new job title: ");
                        String jobTitle = input.nextLine();
                        e.setJobTitle(jobTitle);
                    }

                    case 4 -> {
                        System.out.print("Enter new date of hire: ");
                        String dateOfHire = input.nextLine();
                        e.setDateOfHire(dateOfHire);
                    }

                    default ->
                        System.out.println("Invalid input.");
                }

                employee.set(a, e);
                System.out.println("Update successful!");
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        } else {
            try {
                try (FileWriter infile = new FileWriter(FILE_NAME4)) {
                    for (int i = 0; i < employee.size(); i++) {
                        infile.append(employee.get(i).getName() + " "
                                + employee.get(i).getContactInfo() + " "
                                + employee.get(i).getDepartment() + " "
                                + employee.get(i).getJobTitle() + " "
                                + employee.get(i).getDateOfHire() + "\n");
                    }
                }
            } catch (IOException ev) {
                System.out.println("An error occured when writing into the file.");
            }
        }

    }
}

