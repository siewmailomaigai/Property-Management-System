/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BuildingExecutive;

/**
 *
 * @author 60192
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class View {

    private String schedulesFileName;
    private String complaintsFileName;
    private String employeesFileName;

    public View(String schedulesFileName, String complaintsFileName, String employeesFileName) {
        this.schedulesFileName = schedulesFileName;
        this.complaintsFileName = complaintsFileName;
        this.employeesFileName = employeesFileName;
    }

    public void viewPatrolling() {
        int count = getCount(schedulesFileName);
        System.out.println("Number of patrolling records: " + count);
    }

    public void viewComplaints() {
        int count = getCount(complaintsFileName);
        System.out.println("Number of complaints records: " + count);
    }

    public void viewJobReports() {
        int count = getCount(employeesFileName);
        System.out.println("Number of job report records: " + count);
    }

    private int getCount(String fileName) {
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

}

