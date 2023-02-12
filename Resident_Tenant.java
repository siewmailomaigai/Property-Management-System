/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Hong Shen
 */
public class Resident_Tenant {
    String id;
    private String name;
    private int age;
    private int floor;
    private int unit;
    private String username;
    private String password;
    ArrayList<Resident_Tenant>resident_tenant=new ArrayList<>(10);
    
    Scanner input=new Scanner(System.in);
    static Scanner search=new Scanner(System.in);
            
    //default constructor
    Resident_Tenant(){
        this.id=null;
        this.name=null;
        this.age=0;
        this.floor=0;
        this.unit=0;
        this.username=null;
        this.password=null;
    }
    
    //constructor with arguments
    Resident_Tenant(String id,String name, int age, int floor, int unit,String username,String password){
        this.id=id;
        this.name=name;
        this.age=age;
        this.floor=floor;
        this.unit=unit;
        this.username=username;
        this.password=password;
    }
    
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getFloor(){
        return floor;
    }
    public int getUnit(){
        return unit;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setFloor(int floor){
        this.floor=floor;
    }
    public void setUnit(int unit){
        this.unit=unit;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
    public void newResident_Tenant(){
        System.out.println("Enter Resident/Tenant ID: ");
        id=input.nextLine();
        System.out.println("Enter Resident/Tenant name: ");
        name=input.nextLine();
        System.out.println("Enter Resident/Tenant age: ");
        age=input.nextInt();
        input.nextLine();
        System.out.println("Enter Resident/Tenant floor: ");
        floor=input.nextInt();
        input.nextLine();
        System.out.println("Enter Resident/Tenant unit: ");
        unit=input.nextInt();    
        /*System.out.println("Enter Username: ");
        username=input.nextLine();
        System.out.println("Enter Password");
        password=input.nextLine();*/
    }
    
    public void showResidentInfo(){
        System.out.printf("%-5s %-17s %-14d %-9d %-2d\n",id,name,age,floor,unit);
    }
    
    public void addResident(){
        try {
            try (Scanner scan = new Scanner(new File("resident_file.txt"))) {
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
            }
        }
            catch (FileNotFoundException e) {
                System.out.println("The file 'resident_file.txt' was not found.");
            }
            
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
    
    public void editResident(){
        int select;
        try {
            try (Scanner scan = new Scanner(new File("resident_file.txt"))) {
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
            }
        }
            catch (FileNotFoundException e) {
                System.out.println("The file 'resident_file.txt' was not found.");
            }
        
        System.out.print("Enter the ID of the resident/tenant: ");
                String checkId = search.nextLine();
                for(int a=0;a<resident_tenant.size();a++){
                    if(resident_tenant.get(a).getId().equals(checkId)){
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
    public void searchResident(){
        try {
            try (Scanner scan = new Scanner(new File("resident_file.txt"))) {
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
            }
        }
            catch (FileNotFoundException e) {
                System.out.println("The file 'resident_file.txt' was not found.");
            }
                
        System.out.print("Enter the ID of the resident/tenant: ");        
        String checkId = search.nextLine();
                for(int a=0;a<resident_tenant.size();a++){
                    if(resident_tenant.get(a).getId().equals(checkId)){
                        resident_tenant.get(a).showResidentInfo();
                    }
                }
    }
    
    public void viewResident(){
        try {
            try (Scanner scan = new Scanner(new File("resident_file.txt"))) {
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
            }
        }
            catch (FileNotFoundException e) {
                System.out.println("The file 'resident_file.txt' was not found.");
            }
        
        System.out.printf("%-1s %7s %2s %2s %2s\n","ID","Name","Age","Floor","Unit");
                for(int x=0;x<resident_tenant.size();x++){
                    resident_tenant.get(x).showResidentInfo();
                }
    }
}