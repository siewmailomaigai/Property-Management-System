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
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author 60192
 */
public class ResidentTenantManagement {

    String id;
    private String name;
    private int age;
    private int floor;
    private int unit;
    private String username;
    private String password;
    public static final String FILE_NAME = "C:\\Users\\60192\\Documents\\NetBeansProjects\\PropertyManagementSystem\\src\\AdminExecutive\\residentfile.txt";
    ArrayList<ResidentTenantManagement> resident_tenant = new ArrayList<>(10);

    Scanner input = new Scanner(System.in);
    Scanner search = new Scanner(System.in);
    int choice, cont;

    //default constructor
    ResidentTenantManagement() {

    }

    //constructor with arguments
    ResidentTenantManagement(String id, String name, int age, int floor, int unit) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.floor = floor;
        this.unit = unit;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getFloor() {
        return floor;
    }

    public int getUnit() {
        return unit;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ResidentTenant{id=" + id + ", name=" + name + ", age=" + age + ", floor=" + floor + ", unit=" + unit + "}";
    }

    public void runResident() {

        do {
            System.out.println("1.Add New Resident/Tenant\n2.Modify Resident/Tenant\n3.Search\n4.View");
            choice = input.nextInt();

            //add or new resident/tenant details
            switch (choice) {
                case 1 -> {
                    ResidentTenantManagement add = new ResidentTenantManagement();
                    add.addResident();

                }
                case 2 -> {
                    ResidentTenantManagement modify = new ResidentTenantManagement();
                    modify.modifyResident();

                }
                case 3 -> {
                    ResidentTenantManagement searchRT = new ResidentTenantManagement();
                    searchRT.searchResident();

                }
                case 4 -> {
                    ResidentTenantManagement view = new ResidentTenantManagement();
                    view.viewResident();

                }

                default ->
                    System.out.println("\nWrong input! Please try again!");
            }

            System.out.println("\nPlease Press 1 to Return to Back and Press 0 for Return to Main Menu.");
            cont = input.nextInt();

        } while (cont != 0);
    }

    public void newResident_Tenant() {
        System.out.println("Enter Resident/Tenant ID: ");
        id = input.nextLine();
        System.out.println("Enter Resident/Tenant name: ");
        name = input.nextLine();
        System.out.println("Enter Resident/Tenant age: ");
        age = input.nextInt();
        input.nextLine();
        System.out.println("Enter Resident/Tenant floor: ");
        floor = input.nextInt();
        input.nextLine();
        System.out.println("Enter Resident/Tenant unit: ");
        unit = input.nextInt();

    }

    public void showResidentInfo() {
        System.out.println("Resident Information:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Floor: " + getFloor());
        System.out.println("Unit: " + getUnit());
    }

    public void addResident() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    ResidentTenantManagement newRT = new ResidentTenantManagement();
                    newRT.setId(parts[0]);
                    newRT.setName(parts[1]);
                    newRT.setAge(Integer.parseInt(parts[2]));
                    newRT.setFloor(Integer.parseInt(parts[3]));
                    newRT.setUnit(Integer.parseInt(parts[4]));
                    resident_tenant.add(newRT);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'resident_file.txt' was not found.");
        }

        ResidentTenantManagement newRT2 = new ResidentTenantManagement();
        newRT2.newResident_Tenant();
        resident_tenant.add(newRT2);

        //newRT.addToFile();
        try {
            try (FileWriter infile = new FileWriter(FILE_NAME)) {
                for (int i = 0; i < resident_tenant.size(); i++) {
                    infile.append(resident_tenant.get(i).getId() + " "
                            + resident_tenant.get(i).getName() + " "
                            + resident_tenant.get(i).getAge() + " "
                            + resident_tenant.get(i).getFloor() + " "
                            + resident_tenant.get(i).getUnit() + "\n");
                }
            }
        } catch (IOException ev) {
            System.out.println("An error occured when writing into the file.");
        }
    }

    public void modifyResident() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    ResidentTenantManagement newRT = new ResidentTenantManagement();
                    newRT.setId(parts[0]);
                    newRT.setName(parts[1]);
                    newRT.setAge(Integer.parseInt(parts[2]));
                    newRT.setFloor(Integer.parseInt(parts[3]));
                    newRT.setUnit(Integer.parseInt(parts[4]));
                    resident_tenant.add(newRT);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'resident_file.txt' was not found.");
        }

        System.out.print("Enter the ID of the resident/tenant: ");
        String checkId = search.nextLine();
        boolean found = false;
        for (int a = 0; a < resident_tenant.size(); a++) {
            if (resident_tenant.get(a).getId().equalsIgnoreCase(checkId)) {
                found = true;
                System.out.println("Select the field you want to modify");
                System.out.println("1. Name");
                System.out.println("2. Age");
                System.out.println("3. Floor");
                System.out.println("4. Unit");
                System.out.println("5. Cancel");
                System.out.print("Enter choice: ");
                int choice = input.nextInt();
                input.nextLine();
                ResidentTenantManagement resident = resident_tenant.get(a);
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter new name: ");
                        String name = input.nextLine();
                        resident.setName(name);
                    }
                    case 2 -> {
                        System.out.print("Enter new age: ");
                        int age = input.nextInt();
                        input.nextLine();
                        resident.setAge(age);
                    }
                    case 3 -> {
                        System.out.print("Enter new floor: ");
                        int floor = input.nextInt();
                        input.nextLine();
                        resident.setFloor(floor);
                    }
                    case 4 -> {
                        System.out.print("Enter new unit: ");
                        int unit = input.nextInt();
                        input.nextLine();
                        resident.setUnit(unit);
                    }
                    case 5 -> {
                        System.out.println("Modification canceled.");
                        return;
                    }
                    default ->
                        System.out.println("Invalid input.");
                }

                resident_tenant.set(a, resident);
                System.out.println("Modification successful!");
                break;
            }
        }
        if (!found) {
            System.out.println("Resident/tenant not found.");
        } else {
            try {
                try (FileWriter infile = new FileWriter(FILE_NAME)) {
                    for (int i = 0; i < resident_tenant.size(); i++) {
                        infile.append(resident_tenant.get(i).getId() + " "
                                + resident_tenant.get(i).getName() + " "
                                + resident_tenant.get(i).getAge() + " "
                                + resident_tenant.get(i).getFloor() + " "
                                + resident_tenant.get(i).getUnit() + "\n");
                    }
                }
            } catch (IOException ev) {
                System.out.println("An error occured when writing into the file.");
            }
        }
    }

    public void searchResident() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    ResidentTenantManagement newRT = new ResidentTenantManagement();
                    newRT.setId(parts[0]);
                    newRT.setName(parts[1]);
                    newRT.setAge(Integer.parseInt(parts[2]));
                    newRT.setFloor(Integer.parseInt(parts[3]));
                    newRT.setUnit(Integer.parseInt(parts[4]));
                    resident_tenant.add(newRT);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'resident_file.txt' was not found.");
        }

        System.out.print("Enter the resident name: ");
        String checkName = search.nextLine();
        boolean foundResident = false;
        for (int a = 0; a < resident_tenant.size(); a++) {
            if (checkName.equals(resident_tenant.get(a).getName())) {
                if (!foundResident) {
                    System.out.println("Residents with the name " + checkName + ":");
                    foundResident = true;
                }
                resident_tenant.get(a).showResidentInfo();
            }
        }
        if (!foundResident) {
            System.out.println("No residents with the name " + checkName + ".");
        }

    }

    public void viewResident() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    ResidentTenantManagement newRT = new ResidentTenantManagement();
                    newRT.setId(parts[0]);
                    newRT.setName(parts[1]);
                    newRT.setAge(Integer.parseInt(parts[2]));
                    newRT.setFloor(Integer.parseInt(parts[3]));
                    newRT.setUnit(Integer.parseInt(parts[4]));
                    resident_tenant.add(newRT);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'resident_file.txt' was not found.");
        }

        for (int x = 0; x < resident_tenant.size(); x++) {
            resident_tenant.get(x).showResidentInfo();
        }
    }

    public void deleteResident() {
        System.out.print("Enter the resident unit to be deleted: ");
        Scanner scan = new Scanner(System.in);
        int residentUnitToDelete = scan.nextInt();

        StringBuilder contentBuilder = new StringBuilder();
        boolean residentFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] parts = currentLine.split(" ");
                int unit = Integer.parseInt(parts[4]);
                if (unit == residentUnitToDelete) {
                    residentFound = true;
                } else {
                    contentBuilder.append(currentLine).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!residentFound) {
            System.out.println("Resident living in unit number " + residentUnitToDelete + " was not found.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(contentBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Deleted the resident with the ID: " + residentUnitToDelete);
    }
}

