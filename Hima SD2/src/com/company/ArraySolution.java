package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArraySolution {

    public static void main (String[] args) throws IOException {
        Scanner myScanner = new Scanner(System.in);
        String CustomerName = null;
        int CabinNum = 0;

        String[] Cruise = new String[12];
        initialise(Cruise);
        WhileLoop:
        while (CabinNum < 12){

            //printing menu

            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("SELECT AN OPTION");
            System.out.println("V : View all cabins ");
            System.out.println("A : Add Customer to Cabin");
            System.out.println("E : Display empty cabins");
            System.out.println("D : Delete a customer");
            System.out.println("F : Find cabin from customer name");
            System.out.println("S : Store data to a file");
            System.out.println("L : Load data from file");
            System.out.println("O : Display customer names in alphabetical order");
            System.out.println("Q : To quit");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");

            String Choice = myScanner.next().toUpperCase();


            switch (Choice){

                case "Q":
                    System.out.println("Quiting");
                    break;

                case "A" :
                    try {
                        System.out.println("Enter cabin number: ");
                        CabinNum = myScanner.nextInt();

                    }   catch (Exception e){
                        System.out.println("Sorry. Cabin numbers are integer values between 0 and 11");
                        break WhileLoop;
                    }
                    System.out.println("Enter your name: ");
                    CustomerName = myScanner.next().toLowerCase();
                    Cruise[CabinNum] = CustomerName;
                    AddCustomer( Cruise, CustomerName);
                    break;

                case "V":
                    View( Cruise, CustomerName);
                    break;

                case "E":
                    EmptyCabins( Cruise);
                    break;

                case "D":
                    Delete( Cruise, CabinNum);
                    View( Cruise, CustomerName);
                    break;

                case "F":
                    FindCabin(CustomerName,  Cruise);
                    break;

                case "S":
                    StoreToFile( Cruise, CustomerName);
                    break;

                case "L":
//                    LoadFromFile();
//                    break;

                case "O":
                    NamesInOrder( Cruise);
                    break;

            }
        }
    }


    private static void initialise( String hotelRef[] )
    {
        for (int i = 0; i < 12; i++ )
            hotelRef[i] = "empty";
        System.out.println( "Welcome to my Cruise");
    }

    public static void AddCustomer(String Ship[], String Name){ //to add customer

        for (int i = 0; i < 12; i ++){
            if (Ship[i].equals("empty")){
                System.out.println("Cabin number " + i + " is empty");
            }
            else{
                System.out.println("Cabin number " + i + " is occupied by " + Ship[i]);
            }
        }
    }

    public static void View(String Ship[], String Name){// to view customer

        for (int i = 0; i < 12; i ++){
            if (Ship[i].equals("empty")){
                System.out.println("Cabin number " + i + " is empty");
            }
            else{
                System.out.println("Cabin number " + i + " is occupied by " + Ship[i]);
            }
        }
    }
    public static void Delete(String Ship[], int CabinNumber){ //to delete passenger
        Scanner myS = new Scanner(System.in);
        System.out.println("Enter the cabin number of the customer you want to delete: ");
        CabinNumber = myS.nextInt();
        Ship[CabinNumber] = "empty";
        System.out.println("Deleted");
    }


    public static void EmptyCabins(String Ship[]){  //to display empty cabins
        for (int i = 0; i < 12; i ++){
            if (Ship[i].equals("empty")){
                System.out.println("Cabin number " + i + " is empty");
            }
        }
    }


    public static void FindCabin(String Name, String Ship[]){  //to find cabin from customer name
        Scanner myS = new Scanner(System.in);
        System.out.println("Enter the name of customer: ");
        Name = myS.next();
        for (int i = 0; i < 12; i++){
            if (Ship[i].equals(Name)){
                System.out.println(Ship[i] + " is occupying cabin number " + i);

            }
        }
    }

    public static void StoreToFile(String Ship[], String Name) throws IOException {  //to store data to file
        FileWriter myWriter = new FileWriter("Data.txt");
        for (int i = 0; i < 12; i ++){
            if (Ship[i].equals("empty")){
                myWriter.write("Cabin number " + i + " is empty");
                myWriter.write("\n");
            }
            else{
                myWriter.write("Cabin number " + i + " is occupied by " + Ship[i]);
                myWriter.write("\n");
            }
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }


//    public static void LoadFromFile() throws FileNotFoundException {  //to load data from file
//        File inputFile = new File("C:\\Users\\user\\IdeaProjects\\Shaima's  Sd2 CW\\Data.txt");
//        Scanner readFile = new Scanner(inputFile);
//        String fileLine;
//        while (readFile.hasNext()){
//            fileLine = readFile.nextLine();
//            System.out.println(fileLine);
//        }
//        readFile.close();
//    }

    public static void NamesInOrder(String Ship[]) { //to display names in alphabetical order
        String temp;
        for (int i = 0; i < 12; i++) {
            for (int j = i + 1; j < 12; j++) {

                if (!Ship[i].equals("empty")) {


                    if (Ship[i].compareTo(Ship[j]) > 0) {
                        temp = Ship[i];
                        Ship[i] = Ship[j];
                        Ship[j] = temp;
                    }
                }
            }
        }

        System.out.println("The names in alphabetical order are: ");
        for (int i = 0; i < 12; i++) {
            if (!Ship[i].equals("empty")) {
                System.out.println(Ship[i]);
            }
        }
    }
}
