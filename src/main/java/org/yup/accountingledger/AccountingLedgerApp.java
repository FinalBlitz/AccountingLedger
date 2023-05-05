package org.yup.accountingledger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountingLedgerApp {

    public static void main(String[] args) {


        boolean appRunning = true;

         while (appRunning) {

             switch (mainMenu()) {
                 case 'D':
                     addTransaction(true);
                     break;
                 case 'P':
                     addTransaction(false);
                     break;
                 case 'L':
                     Ledger.ledgerRunning();
                     break;
                 case 'X':
                     System.out.println("Exiting the application...\n");
                     appRunning = false;
                     break;
                 default:
                     System.out.println("Invalid selection, please try again.");

             }
             System.out.println("Thank you for visiting Final's, Have a nice day\n");
         }
    }
    public static int mainMenu(){
        Scanner scanner = new Scanner(System.in);
        String name = "Berny Fontil\n";

        System.out.println("Welcome " + name);
        System.out.println("WHat would you like to do?");
        System.out.println("D: Make a Deposit ");
        System.out.println("P: Make a Payment ");
        System.out.println("L: Ledger ");
        System.out.println("X: Exit ");
        System.out.print("Please make your selection: ");

        return scanner.next().toUpperCase().charAt(0);
    }

//    public static void addDeposit() {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the deposit information: ");
//        System.out.println("Date (MM/DD/YYYY): ");
//        String date = scanner.nextLine();
//        System.out.println("Amount: ");
//        double amount = scanner.nextDouble();
//        scanner.nextLine();
//        System.out.println("Description: ");
//        String description = scanner.nextLine();
//
//        Deposit deposit = new Deposit(date,amount,description);
//
//        try{
//            FileWriter DWriter = new FileWriter("Transactions.csv",true);
//            System.out.println(deposit.getDescription());
//            DWriter.append(String.format("%s,%.2f,%s\n", deposit.getDate(), deposit.getAmount(), deposit.getDescription()));
//            DWriter.close();
//            System.out.println("Deposit was added");
//        }catch (IOException e) {
//            System.out.println("An error occurred while adding the deposit");
//        }
//    }
//     make addTransaction boolean to give me a true or false option in my if statement
    public static void addTransaction(boolean isDeposit) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the following information: ");
        System.out.println("Description: ");
        String description = scanner.nextLine();
        System.out.println("Vendor: ");
        String Vendor = scanner.nextLine();
        System.out.println("Amount: ");
        double amount = scanner.nextDouble();

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = time.format(formatter);
        System.out.println(formattedTime);

        try {
            FileWriter TWriter = new FileWriter("Transactions.csv", true);

            if (isDeposit) {
                TWriter.append(String.format("%s | %s | %s | %s | $%.2f\n ", date, time, description, Vendor, amount));
                System.out.println("Deposit was added\n.");
            }else{
                TWriter.append(String.format("%s | %s | %s | %s | $%.2f\n ",date,time,description,Vendor,amount * -1));
                System.out.println("Payment was added\n.");
            }
            TWriter.close();
        } catch (IOException e) {
            System.out.println("An error has occurred");
        }
    }

}
