/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asg;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}
