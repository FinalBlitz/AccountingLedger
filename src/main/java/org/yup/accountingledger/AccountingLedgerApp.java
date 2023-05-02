package org.yup.accountingledger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountingLedgerApp {

    public static void main(String[] args) {


        boolean appRunning = true;

         while (appRunning) {

             switch (mainMenu()) {
                 case 'D':
                     addDeposit();
                     break;
                 case 'P':
                     System.out.println();
                     break;
                 case 'L':
                     System.out.println();
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

    public static void addDeposit() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the deposit information: ");
        System.out.println("Date (MM/DD/YYYY): ");
        String date = scanner.nextLine();
        System.out.println("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();

        Deposit deposit = new Deposit(date,amount,description);

        try{
            FileWriter DWriter = new FileWriter("Transactions.csv",true);
            System.out.println(deposit.getDescription());
            DWriter.append(String.format("%s,%.2f,%s", deposit.getDate(), deposit.getAmount(), deposit.getDescription()));
            DWriter.close();
            System.out.println("Deposit was added");
        }catch (IOException e) {
            System.out.println("An error occurred while adding the deposit");
        }
    }
    public static void addTransaction() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please provide the following information: ");
            System.out.println("Description: ");
            String description = scanner.nextLine();
            System.out.println("Vendor: ");
            String Vendor = scanner.nextLine();
            System.out.println("Amount: ");
            double amount = scanner.nextDouble();
            boolean isDebit = true;
    }
}
