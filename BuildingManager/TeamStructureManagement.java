/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BuildingManager;

/**
 *
 * @author 60192
 */
import java.io.*;
import java.util.*;

public class TeamStructureManagement {

    private List<Team> teams;
    private String fileName;

    public TeamStructureManagement(String fileName) {
        this.fileName = fileName;
        teams = new ArrayList<>();
        loadTeams();
    }

    public void createTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        System.out.print("Enter team description: ");
        String description = scanner.nextLine();
        Team team = new Team(name, description);
        teams.add(team);
        saveTeams();
        System.out.println("Team created successfully.");
    }

    public void viewTeams() {
        for (Team team : teams) {
            System.out.println("Name: " + team.getName());
            System.out.println("Description: " + team.getDescription());
            System.out.println();
        }
    }

    public void updateTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter team name to update: ");
        String name = scanner.nextLine();
        boolean teamFound = false;
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equals(name)) {
                System.out.print("Enter new team description: ");
                String description = scanner.nextLine();
                teams.get(i).setDescription(description);
                saveTeams();
                System.out.println("Team updated successfully.");
                teamFound = true;
                break;
            }
        }
        if (!teamFound) {
            System.out.println("Team not found with name: " + name);
        }
    }

    private void saveTeams() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Team team : teams) {
                writer.write(team.getName() + "," + team.getDescription() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private void loadTeams() {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] teamDetails = scanner.nextLine().split(",");
                    teams.add(new Team(teamDetails[0], teamDetails[1]));
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

class Team {

    private String name;
    private String description;

    public Team(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
