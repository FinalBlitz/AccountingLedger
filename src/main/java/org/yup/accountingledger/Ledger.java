package org.yup.accountingledger;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Ledger {

    public static String ledgerRunning() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        String input = "";

        while (isRunning) {
            System.out.println("What would you like to view");
            System.out.println("A: All");
            System.out.println("D: Deposits");
            System.out.println("P: Payments");
            System.out.println("R: Reports");
            System.out.println("H: Home");
            System.out.println("Provide you selection here: ");

            input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "A":
                    allInformation();
                    break;
                case "D":
                    allDeposit();
                    break;
                case "P":
                    allPayment();
                    break;
                case "R":
                    break;
                case "H":
                    System.out.println("Returning to Home Screen...\n");
                    AccountingLedgerApp.mainMenu();
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
                    break;

            }

        }
        return input;
    }

    public static void allInformation() {

        try {
            FileReader allInfo = new FileReader("Transactions.csv");
            BufferedReader theFile = new BufferedReader(allInfo);

            String headerRow = theFile.readLine();
            String theNextLine;
            while ((theNextLine = theFile.readLine()) != null) {
                String[] allinfos = theNextLine.split("\\|");
                String date = allinfos[0];
                String time = allinfos[1].trim();
                String description = allinfos[2];
                String vendor = allinfos[3];
                double amount = Double.parseDouble(allinfos[4]);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(date.trim(), dateFormatter);

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime localTime = LocalTime.parse(time, timeFormatter);

                Transaction mainTrans = new Transaction(localDate, localTime, description, vendor, amount, false);
                String allT = String.format("Date: %s Time: %s Description: %s Vendor: %s Amount: $%.2f", mainTrans.getToday(), mainTrans.getCurrentTime(), mainTrans.getDescription(), mainTrans.getVendor(), mainTrans.getAmount());
                System.out.println(allT);
            }
            theFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
    public static void allDeposit() {
        try {
            FileReader allD = new FileReader("Transactions.csv");
            BufferedReader theFiles = new BufferedReader(allD);

            String headerRow = theFiles.readLine();
            String theNextLine;

            while ((theNextLine = theFiles.readLine()) != null) {
                String[] allDepot = theNextLine.split("\\|");
                String date = allDepot[0];
                String time = allDepot[1].trim();
                String description = allDepot[2];
                String vendor = allDepot[3];
                double amount = Double.parseDouble(allDepot[4]);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(date.trim(), dateFormatter);

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime localTime = LocalTime.parse(time, timeFormatter);

                Transaction mainTrans = new Transaction(localDate, localTime, description, vendor, amount, false);

                if (amount > 0) {
                    String allDs = String.format("Date: %s Time: %s Description: %s Vendor: %s Amount: $%.2f", mainTrans.getToday(), mainTrans.getCurrentTime(), mainTrans.getDescription(), mainTrans.getVendor(), mainTrans.getAmount());
                    System.out.println(allDs);
                }
            }
            theFiles.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
    public static void allPayment() {
        try {
            FileReader allT = new FileReader("Transactions.csv");
            BufferedReader theFiles = new BufferedReader(allT);

            String headerRow = theFiles.readLine();
            String theNextLine;

            while ((theNextLine = theFiles.readLine()) != null) {
                String[] allDepot = theNextLine.split("\\|");
                String date = allDepot[0];
                String time = allDepot[1].trim();
                String description = allDepot[2];
                String vendor = allDepot[3];
                double amount = Double.parseDouble(allDepot[4]);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(date.trim(), dateFormatter);

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime localTime = LocalTime.parse(time, timeFormatter);

                Transaction mainTrans = new Transaction(localDate, localTime, description, vendor, amount, false);

                if (amount < 0 ) {
                    String allTs = String.format("Date: %s Time: %s Description: %s Vendor: %s Amount: $%.2f", mainTrans.getToday(), mainTrans.getCurrentTime(), mainTrans.getDescription(), mainTrans.getVendor(), mainTrans.getAmount());
                    System.out.println(allTs);
                }
            }
            theFiles.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
