/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminExecutive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 60192
 */
public class UnitManagement extends ResidentTenantManagement {

    public UnitManagement() {
        super();
    }

    public UnitManagement(String id, String name, int age, int floor, int unit) {
        super(id, name, age, floor, unit);

    }

    public void runUnit() {

        do {
            System.out.println("1.Modify Unit\n2.Search by Unit\n3.View Units occupied\n4.Delete by Units");
            choice = input.nextInt();

            //add or new resident/tenant details
            switch (choice) {
                case 1 -> {
                    UnitManagement modify = new UnitManagement();
                    modify.modifyResident();

                }

                case 2 -> {
                    UnitManagement searchRT = new UnitManagement();
                    searchRT.searchUnit();

                }
                case 3 -> {
                    UnitManagement view = new UnitManagement();
                    view.viewResident();

                }
                case 4 -> {
                    UnitManagement delete = new UnitManagement();
                    delete.deleteResident();
                }

                default ->
                    System.out.println("\nWrong input! Please try again!");
            }

            System.out.println("\nPlease Press 1 to Return to Back and Press 0 for Return to Main Menu.");
            cont = input.nextInt();

        } while (cont != 0);
    }

    public void searchUnit() {
        try {
            try (Scanner scan = new Scanner(new File(FILE_NAME))) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] parts = line.split(" ");
                    UnitManagement newRT = new UnitManagement();
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

        System.out.print("Enter the unit number: ");
        int checkUnit = search.nextInt();
        boolean foundResident = false;
        for (int a = 0; a < resident_tenant.size(); a++) {
            if (resident_tenant.get(a).getUnit() == checkUnit) {
                if (!foundResident) {
                    System.out.println("Residents in Unit " + checkUnit + ":");
                    foundResident = true;
                }
                resident_tenant.get(a).showResidentInfo();
            }
        }
        if (!foundResident) {
            System.out.println("No residents found in Unit " + checkUnit + ".");
        }

    }
}

