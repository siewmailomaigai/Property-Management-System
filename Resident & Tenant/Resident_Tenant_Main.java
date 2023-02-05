/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Hong Shen
 */
public class Resident_Tenant_Main {
    public static String del;
    static Scanner search=new Scanner(System.in);
    
    
    public static void main(String arg[]){
        int choice, cont,select;
        Scanner input=new Scanner(System.in);
        ArrayList<Resident_Tenant>resident_tenant=new ArrayList<>(10);
     
        try {
            Scanner scan = new Scanner(new File("resident_file.txt"));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(" ");
                Resident_Tenant newRT = new Resident_Tenant();
                newRT.setId(parts[0]);
                newRT.setName(parts[1]);
                newRT.setAge(Integer.parseInt(parts[2]));
                newRT.setFloor(Integer.parseInt(parts[3]));
                newRT.setUnit(Integer.parseInt(parts[4]));
                resident_tenant.add(newRT);
            }
            scan.close();
            } 
            catch (FileNotFoundException e) {
                System.out.println("The file 'resident_file.txt' was not found.");
            }
    
    
        do{
            System.out.println("1.Add New Resident/Tenant\n2.Edit Resident/Tenant\n3.Search\n4.View");
            choice=input.nextInt();
        
            //add or new resident/tenant details
            if(choice==1){
                Resident_Tenant newRT2=new Resident_Tenant();
                newRT2.newResident_Tenant();
                resident_tenant.add(newRT2);
            
                //newRT.addToFile();
                try{
                    try (FileWriter infile = new FileWriter("resident_file.txt")) {
                        for (int i = 0; i < resident_tenant.size(); i++) {
                            infile.append(resident_tenant.get(i).getId()+" "+
                                    resident_tenant.get(i).getName()+" "+
                                    resident_tenant.get(i).getAge()+" "+
                                    resident_tenant.get(i).getFloor()+" "+
                                    resident_tenant.get(i).getUnit()+"\n");}
                    }
                }
                catch (IOException ev) {
                    System.out.println("An error occured when writing into the file.");
                }
            }
            //Edit Resident/tenant details
            else if(choice==2){
                System.out.print("Enter the ID of the resident/tenant: ");
                String id = search.nextLine();
                for(int a=0;a<resident_tenant.size();a++){
                    if(resident_tenant.get(a).getId().equals(id)){
                        System.out.println("1.ID\n2.Name\n3.Age\n4.Floor\n5.Unit");
                        System.out.println("Which details require edit?");
                        System.out.println("Please choose: ");
                        select=input.nextInt();
                        //edit id
                        if(select==1){
                            System.out.println("Enter Resident/Tenant ID: ");
                            String newId=search.nextLine();
                            resident_tenant.get(a).setId(newId);
                            try{
                                try (FileWriter infile = new FileWriter("resident_file.txt")) {
                                    for (int i = 0; i < resident_tenant.size(); i++) {
                                        infile.append(resident_tenant.get(i).getId()+" "+
                                                      resident_tenant.get(i).getName()+" "+
                                                      resident_tenant.get(i).getAge()+" "+
                                                      resident_tenant.get(i).getFloor()+" "+
                                                      resident_tenant.get(i).getUnit()+"\n");}
                                }
                            }
                            catch (IOException ev) {
                                System.out.println("An error occured when writing into the file.");
                            }
                        }
                        else if(select==2){
                            System.out.println("Enter Resident/Tenant Name: ");
                            String newName=search.nextLine();
                            resident_tenant.get(a).setName(newName);
                            try{
                                try (FileWriter infile = new FileWriter("resident_file.txt")) {
                                    for (int i = 0; i < resident_tenant.size(); i++) {
                                        infile.append(resident_tenant.get(i).getId()+" "+
                                                      resident_tenant.get(i).getName()+" "+
                                                      resident_tenant.get(i).getAge()+" "+
                                                      resident_tenant.get(i).getFloor()+" "+
                                                      resident_tenant.get(i).getUnit()+"\n");}
                                }
                            }
                            catch (IOException ev) {
                                System.out.println("An error occured when writing into the file.");
                            }                        
                        }
                        else if(select==3){
                            System.out.println("Enter Resident/Tenant Age: ");
                            String newAge=search.nextLine();
                            resident_tenant.get(a).setName(newAge);
                            try{
                                try (FileWriter infile = new FileWriter("resident_file.txt")) {
                                    for (int i = 0; i < resident_tenant.size(); i++) {
                                        infile.append(resident_tenant.get(i).getId()+" "+
                                                      resident_tenant.get(i).getName()+" "+
                                                      resident_tenant.get(i).getAge()+" "+
                                                      resident_tenant.get(i).getFloor()+" "+
                                                      resident_tenant.get(i).getUnit()+"\n");}
                                }
                            }
                            catch (IOException ev) {
                                System.out.println("An error occured when writing into the file.");
                            }
                        }
                        else if(select==4){
                            System.out.println("Enter Resident/Tenant Floor: ");
                            String newFloor=search.nextLine();
                            resident_tenant.get(a).setName(newFloor);
                            try{
                                try (FileWriter infile = new FileWriter("resident_file.txt")) {
                                    for (int i = 0; i < resident_tenant.size(); i++) {
                                        infile.append(resident_tenant.get(i).getId()+" "+
                                                      resident_tenant.get(i).getName()+" "+
                                                      resident_tenant.get(i).getAge()+" "+
                                                      resident_tenant.get(i).getFloor()+" "+
                                                      resident_tenant.get(i).getUnit()+"\n");}
                                }
                            }
                            catch (IOException ev) {
                                System.out.println("An error occured when writing into the file.");
                            }
                        }
                        else if(select==5){
                            System.out.println("Enter Resident/Tenant Unit: ");
                            String newUnit=search.nextLine();
                            resident_tenant.get(a).setName(newUnit);
                            try{
                                try (FileWriter infile = new FileWriter("resident_file.txt")) {
                                    for (int i = 0; i < resident_tenant.size(); i++) {
                                        infile.append(resident_tenant.get(i).getId()+" "+
                                                      resident_tenant.get(i).getName()+" "+
                                                      resident_tenant.get(i).getAge()+" "+
                                                      resident_tenant.get(i).getFloor()+" "+
                                                      resident_tenant.get(i).getUnit()+"\n");}
                                }
                            }
                            catch (IOException ev) {
                                System.out.println("An error occured when writing into the file.");
                            }
                        }
                    }
                }
            }
        
        
            //search particular resident/tenant details
            else if (choice==3){            
                System.out.print("Enter the ID of the resident/tenant: ");
                String id = search.nextLine();
                for(int a=0;a<resident_tenant.size();a++){
                    if(resident_tenant.get(a).getId().equals(id)){
                        resident_tenant.get(a).showResidentInfo();
                    }
                }
            }
        
            //view all resident/tenant details
            else if(choice==4){
                System.out.printf("%-1s %7s %2s %2s %2s\n","ID","Name","Age","Floor","Unit");
                for(int x=0;x<resident_tenant.size();x++){
                    resident_tenant.get(x).showResidentInfo();
                }
            }
            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
            cont = input.nextInt();
            while(cont != 1 && cont != 0) {
                    System.out.println("Please Press 1 to Return to Back and Press 0 for Return to Main Menu.");
                    cont = input.nextInt();
            }
        }while(cont!=0);
    }
}
