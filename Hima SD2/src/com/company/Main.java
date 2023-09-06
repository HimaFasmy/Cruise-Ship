package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner myS = new Scanner(System.in);
        Cabin[] Cruise = new Cabin[12];

        for (int i = 0; i < 12; i++) {
            Cruise[i] = new Cabin(new Passenger(), new Passenger(), new Passenger());//each cabin object has three passenger objects

        }

        String CustomerName = null;
        String P1expense = "150";
        String P2expense = "300";
        String P3expense = "400";

        int CabinNumber = 0;
        label:
        while (CabinNumber < 12) {

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
            System.out.println("T : Print the expenses per passenger and the total expenses of all passengers.");
            System.out.println("Q : Exit program");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");

            String choice = myS.next().toUpperCase();

            switch (choice) {
                case "Q":
                    System.out.println("Quiting");
                    break label;

                case "V":

                    View(Cruise, CabinNumber);

                    break;


                case "A":
                    System.out.println("Each cabin has three passenger seats. Choose yours.  ");
                    System.out.println("Seat one costs $150");
                    System.out.println("Seat two costs $300");
                    System.out.println("Seat three costs $400");

                    try {
                        System.out.println("Enter cabin number: ");
                        CabinNumber = myS.nextInt();

                    } catch (Exception e) {
                        System.out.println("Sorry. Cabin numbers are integer values between 0 and 11");
                        break label;
                    }
                    Add(Cruise, CabinNumber, P1expense, P2expense, P3expense);
                    break;




                case "E":
                    EmptyCabins(Cruise);
                    break;


                case "D":
                    Delete(Cruise, CabinNumber);
                    break;


                case "F":
                    FindCabinFromName(Cruise);
                    break;

                case "S":
                    StoreToFile(Cruise, CustomerName);
                    break;

                case "L":
//                    LoadFromFile();
//                    break;

                case "O":
                    NamesInOrder(Cruise);
                    break;

                case "T":
                    Expenses(Cruise);
//


            }

        }
    }

    public static void Add(Cabin[] Ship, int CabinNum, String expense1, String expense2, String expense3) {//to add passengers

        Scanner myS = new Scanner(System.in);
        try {
            System.out.println("Enter the passenger seat number you want to occupy: ");
            int seatNum = myS.nextInt();

            Ship[CabinNum].setMainName("not empty");


            if (seatNum == 1) {
                System.out.println("Enter your first name: ");
                String CustomerName = myS.next();
                Ship[CabinNum].getPassenger1().setFirstName(CustomerName);
                System.out.println("Enter your surname: ");
                String Surname = myS.next();
                Ship[CabinNum].getPassenger1().setSurname(Surname);
                Ship[CabinNum].getPassenger1().setExpenses(expense1);

            } else if (seatNum == 2) {
                System.out.println("Enter your first name: ");
                String CustomerName2 = myS.next();
                Ship[CabinNum].getPassenger2().setFirstName(CustomerName2);
                System.out.println("Enter your surname: ");
                String Surname2 = myS.next();
                Ship[CabinNum].getPassenger2().setSurname(Surname2);
                Ship[CabinNum].getPassenger2().setExpenses(expense2);
//              q.show();
            } else if (seatNum == 3) {
                System.out.println("Enter your first name: ");
                String CustomerName3 = myS.next();
                Ship[CabinNum].getPassenger3().setFirstName(CustomerName3);
                System.out.println("Enter your surname: ");
                String Surname3 = myS.next();
                Ship[CabinNum].getPassenger3().setSurname(Surname3);
                Ship[CabinNum].getPassenger3().setExpenses(expense3);
            } else {
                System.out.println("Invalid slot number");
            }

        }catch (Exception e){
            System.out.println("Sorry. Passenger slot numbers are integer values between 1 and 3 inclusive");

        }
    }



    public static void View(Cabin[] Ship , int CabinNumber) {// to view all cabins

        for (int i = 0; i<12;i++){
            if (Ship[CabinNumber].getMainName().equals("empty")) {
                System.out.println("Cabin number " + i + " is empty");
            } else {
                System.out.println("Cabin number " + i + " is occupied by " + "\n" + "seat 1: " + Ship[i].getPassenger1().getFirstName() + "\n" + "seat 2: " + Ship[i].getPassenger2().getFirstName() + "\n" + "seat 3: "+ Ship[i].getPassenger3().getFirstName());
            }

        }


    }

    public static void EmptyCabins(Cabin[] Ship){ //to display empty cabins
        for (int i = 0; i <12; i++){
            if(Ship[i].getPassenger1().getFirstName().equals("empty") && Ship[i].getPassenger2().getFirstName().equals("empty") && Ship[i].getPassenger3().getFirstName().equals("empty") ){
                System.out.println("Cabin number " + i + " is empty");
            }
        }
    }



    public static void Delete(Cabin[] Ship, int CabinNum) { //to delete passenger from cabin
        Scanner myS = new Scanner(System.in);
        while (true) {

            try {

                System.out.println("Enter the cabin number of the passenger you want to delete: ");
                CabinNum = myS.nextInt();

            } catch (Exception e) {
                System.err.println("Enter a number between 0 and 11 inclusive");
                break;
            }


            System.out.println("Enter the slot number (1,2 or 3)  you want to delete in cabin number " + CabinNum);
            int seat = myS.nextInt();
            if (seat == 1) {
                Ship[CabinNum].getPassenger1().setFirstName("empty");
                System.out.println("Deleted");
                break;

            } else if (seat == 2) {
                Ship[CabinNum].getPassenger2().setFirstName("empty");
                System.out.println("Deleted");
                break;

            } else if (seat == 3) {
                Ship[CabinNum].getPassenger3().setFirstName("empty");
                System.out.println("Deleted");
                break;

            } else {
                System.out.println("Invalid seat number");
                break;
            }

        }
    }


    public static void FindCabinFromName( Cabin[] Ship){  //to find cabin from passenger name
        Scanner myS = new Scanner(System.in);
        System.out.println("Enter the name of the passenger: ");
        String Name = myS.next();
        for(int i = 0; i<12; i++){
            if(Ship[i].getPassenger1().getFirstName().equals(Name)){
                System.out.println("Cabin number " + i + " is" + " occupied by " + Name );
            }
            if (Ship[i].getPassenger2().getFirstName().equals(Name)){
                System.out.println("Cabin number " + i + " is" + " occupied by " + Name );
            }
            if(Ship[i].getPassenger3().getFirstName().equals(Name)){
                System.out.println(Name + " is occupying " + " cabin number " + i  );
            }else {
                System.out.println("Cabin number " + i + " is" + " occupied by " + Name );
                break;
            }

        }
    }


    public static void StoreToFile(Cabin[] Ship, String Name) throws IOException {//stores all details of passengers to file
        FileWriter myWriter = new FileWriter("Task2.txt");
        for (int i = 0; i < 12; i ++){

            myWriter.write("Cabin number " + i + " is occupied by " + "\n" + "slot 1: " + Ship[i].getPassenger1().getFirstName() + "\n" + "slot 2: " + Ship[i].getPassenger2().getFirstName() + "\n" + "slot 3: "+ Ship[i].getPassenger3().getFirstName());
            myWriter.write("\n");

            if (!Ship[i].getPassenger1().getFirstName().equals("empty") || !Ship[i].getPassenger2().getFirstName().equals("empty") || !Ship[i].getPassenger3().getFirstName().equals("empty")){
                if (!Ship[i].getPassenger1().getFirstName().equals("empty")) {
                    myWriter.write("SLOT ONE \nFirst name: " + Ship[i].getPassenger1().getFirstName() + " Surname: " + Ship[i].getPassenger1().getSurname() + " Expense: $" + Ship[i].getPassenger1().getExpenses());
                    myWriter.write("\n");
                }
                else {
                    System.out.println("No passenger in slot number one");
                }
                if (!Ship[i].getPassenger2().getFirstName().equals("empty")) {
                    myWriter.write("SLOT TWO \nFirst name: " + Ship[i].getPassenger2().getFirstName() + " Surname: " + Ship[i].getPassenger2().getSurname() + " Expense: $" + Ship[i].getPassenger2().getExpenses());
                    myWriter.write("\n");
                }
                else {
                    System.out.println("No passenger in slot number two");
                }
                if (!Ship[i].getPassenger3().getFirstName().equals("empty")) {
                    myWriter.write("SLOT THREE \nFirst name: " + Ship[i].getPassenger3().getFirstName() + " Surname: " + Ship[i].getPassenger3().getSurname() + " Expense: $" + Ship[i].getPassenger3().getExpenses());
                    myWriter.write("\n");
                }
                else {
                    System.out.println("No passenger in slot number three");
                }

            }

        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }

//    public static void LoadFromFile() throws FileNotFoundException { //reads data from the file
//        int lineCount = 1;
//        File inputFile = new File("C:\\Users\\user\\IdeaProjects\\Shaima's  Sd2 CW\\Task2.txt");
//        Scanner readFile = new Scanner(inputFile);
//        String fileLine;
//        while (readFile.hasNext()){
//            fileLine = readFile.nextLine();
//            System.out.println(fileLine);
//            lineCount++;
//        }
//        readFile.close();
//    }


    public static void NamesInOrder(Cabin[] Ship){ //displays names in alphabetical order
        String temp = null;
        Scanner myS = new Scanner(System.in);

        System.out.println("Enter the passenger slot number of the passengers you want in order: ");
        int slot = myS.nextInt();

        if (slot == 1){
            for (int i = 0; i < 12; i++) {
                for (int j = i + 1; j < 12; j++) {


                    if (Ship[i].getPassenger1().getFirstName().compareTo(Ship[j].getPassenger1().getFirstName()) > 0) {
                        // swapping

                        temp = Ship[i].getPassenger1().getFirstName();
                        Ship[i].getPassenger1().setFirstName(Ship[j].getPassenger1().getFirstName());
                        Ship[j].getPassenger1().setFirstName(temp);

                    }

                }
            }

            System.out.println(
                    "The names in alphabetical order are: ");

            for (int i = 0; i < 12; i++) {
                if (!Ship[i].getPassenger1().getFirstName().equals("empty")){
                    System.out.println(Ship[i].getPassenger1().getFirstName());
                }

            }

        } else if (slot == 2){
            for (int i = 0; i < 12; i++) {
                for (int j = i + 1; j < 12; j++) {


                    if (Ship[i].getPassenger2().getFirstName().compareTo(Ship[j].getPassenger2().getFirstName()) > 0) {
                        // swapping

                        temp = Ship[i].getPassenger2().getFirstName();
                        Ship[i].getPassenger2().setFirstName(Ship[j].getPassenger2().getFirstName());
                        Ship[j].getPassenger2().setFirstName(temp);

                    }

                }
            }

            for (int i = 0; i < 12; i++) {
                if (!Ship[i].getPassenger2().getFirstName().equals("empty")){
                    System.out.println(Ship[i].getPassenger2().getFirstName());
                }

            }

        } else if (slot == 3){
            for (int i = 0; i < 12; i++) {
                for (int j = i + 1; j < 12; j++) {


                    if (Ship[i].getPassenger3().getFirstName().compareTo(Ship[j].getPassenger3().getFirstName()) > 0) {
                        // swapping

                        temp = Ship[i].getPassenger3().getFirstName();
                        Ship[i].getPassenger3().setFirstName(Ship[j].getPassenger3().getFirstName());
                        Ship[j].getPassenger3().setFirstName(temp);

                    }

                }
            }
            for (int i = 0; i < 12; i++) {
                if (!Ship[i].getPassenger3().getFirstName().equals("empty")){
                    System.out.println(Ship[i].getPassenger3().getFirstName());
                }

            }


        }
        else {
            System.out.println("Invalid slot number");
        }



    }


    public static void Expenses(Cabin[] Ship){ //Display expenses of all passengers and total expenses of all passengers
        int Total = 0;
        for (int i = 0; i< 12; i++) {
            int CabinTotal;


            CabinTotal = Integer.parseInt(Ship[i].getPassenger1().getExpenses()) + Integer.parseInt(Ship[i].getPassenger2().getExpenses()) + Integer.parseInt(Ship[i].getPassenger3().getExpenses());
            if (!Ship[i].getPassenger1().getFirstName().equals("empty") || !Ship[i].getPassenger2().getFirstName().equals("empty") || !Ship[i].getPassenger3().getFirstName().equals("empty") ){
                if (!Ship[i].getPassenger1().getExpenses().equals("0") || !Ship[i].getPassenger2().getExpenses().equals("0") || !Ship[i].getPassenger3().getExpenses().equals("0") ){
                    System.out.println("Cabin number " + i);
                    if (!Ship[i].getPassenger1().getFirstName().equals("empty")){
                        System.out.println("The expense of Passenger in slot number one is $" + Ship[i].getPassenger1().getExpenses());
                    }
                    else {
                        System.out.println("No passenger in slot number one");
                    }
                    if (!Ship[i].getPassenger2().getFirstName().equals("empty")){
                        System.out.println("The expense of Passenger in slot number two is $" + Ship[i].getPassenger2().getExpenses());
                    }
                    else {
                        System.out.println("No passenger in slot number two");
                    }
                    if (!Ship[i].getPassenger3().getFirstName().equals("empty")){
                        System.out.println("The expense of Passenger in slot number three is $" + Ship[i].getPassenger3().getExpenses());
                    }
                    else {
                        System.out.println("No passenger in slot number three");
                    }

                    System.out.println("The total expense of all passengers in cabin number " + i + " is $" + CabinTotal);
                    Total = Total + CabinTotal;
                }

                else{
                    System.out.println("Cabin number " + i + " is empty");
                }
            }


        }
        System.out.println("All other cabins are empty");
        System.out.println("The total expense of all passengers is $" + Total);

    }

}
