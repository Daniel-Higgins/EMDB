/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07;

/**
 *
 * @author Danny
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();

        System.out.println("Welcome to the Energy Management System");

        Scanner kb = new Scanner(System.in);

        String command = "";

        while (!command.equalsIgnoreCase("quit")) {
            //if there is no elements in customer list load in a list from a default file

            System.out.println("Enter a command:");
            command = kb.nextLine();
            String[] cmd;
            cmd = command.split(" ");
//            getFile("data.xml");
            if (cmd[0].equalsIgnoreCase("load")) {
                try {

                    File input = new File(cmd[1]);

                    if (!input.exists()) {
                        System.out.println("Invalid input file - " + cmd[1]);
                        continue;
                    } else {
                        System.out.println("Load successful: " + cmd[1]);
                    }
                    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
                    SAXParser saxParser = saxParserFactory.newSAXParser();
                    Handler handler = new Handler();

                    saxParser.parse(input, handler);
                    customerList = handler.getCustList();
                } catch (SAXException e) {
                    System.out.println("Invalid input file - " + cmd[1]);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (command.equalsIgnoreCase("clear")) {
                customerList = null;
            } else if (cmd[0].equalsIgnoreCase("show")) {
                if (cmd[1].equalsIgnoreCase("account")) {
                    if (customerList != null) {
                        for (Customer c : customerList) {
                            for (Account a : c.getAccounts()) {
                                if (cmd[2].equalsIgnoreCase(a.getAccountNumber())) {
                                    System.out.println("Account number: " + cmd[2]);
                                    a.updateBalance();
                                    DecimalFormat df = new DecimalFormat("0.00");
                                    System.out.println("Balance: $" + df.format(a.getCurrentBalance()));
                                    System.out.println("Addresses:" );
                                    for (Address ad : a.getAddresses()) {
                                        System.out.println("  " + ad.getNumber() + " " + ad.getStreet());
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("No records found");
                    }
                } else if (cmd[1].equalsIgnoreCase("address")) {
                    String searchAddr = "";
                    int addrNum = Integer.parseInt(cmd[2]);
                    for (int i = 3; i < cmd.length; i++) {
                        searchAddr += " " + cmd[i];
                    }
                    searchAddr = searchAddr.substring(1);
                    if (customerList != null) {
                        for (Customer c : customerList) {
                            for (Account a : c.getAccounts()) {
                                for (Address ad : a.getAddresses()) {
                                    if (addrNum == ad.getNumber() && searchAddr.equalsIgnoreCase(ad.getStreet())) {
                                        System.out.println("Number: " + ad.getNumber());
                                        System.out.println("Street: " + ad.getStreet());
                                        System.out.println("Zip: " + ad.getZipCode());
                                        System.out.println("Type: " + ad.getType());
                                        if (ad instanceof Apartment) {
                                            Apartment ap = (Apartment) ad;
                                            System.out.println("Unit: " + ap.getUnit());

                                        }
                                        System.out.println("Meters:" );
                                        for (Meter m : ad.getMeters()) {
                                            System.out.println("  " + m.getID());
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("No records found");
                    }
                } else if (cmd[1].equalsIgnoreCase("meter")) {
                    if (customerList != null) {
                        for (Customer c : customerList) {
                            for (Account a : c.getAccounts()) {
                                for (Address ad : a.getAddresses()) {
                                    for (Meter m : ad.getMeters()) {
                                        if (cmd[2].equalsIgnoreCase(m.getID())) {
                                            System.out.println("ID: " + m.getID());
                                            System.out.println("Brand: " + m.getBrand());
                                            System.out.println("Location: " + m.getLocation());
                                            System.out.println("Type: " + m.getType());
                                            System.out.println("Meters Readings:" );
                                            for (MeterReading mr : m.getReadings()) {
                                                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                                System.out.println("  " + f.format(mr.getDateTime()));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("No records found");
                    }
                } else if (cmd[1].equalsIgnoreCase("customer")) {
                    if (customerList != null) {
                        for (Customer c : customerList) {
                            if (cmd[2].equalsIgnoreCase(c.getLastName())) {
                                System.out.println("Last name: " + c.getLastName());
                                System.out.println("First name: " + c.getFirstName());
                                System.out.println("Accounts:" );
                                for (Account a : c.getAccounts()) {
                                    System.out.println("  " + a.getAccountNumber());
                                }
                            }
                        }
                    } else {
                        System.out.println("No records found");
                    }
                }
            } else if (cmd[0].equalsIgnoreCase("check")) {
                if (cmd[1].equalsIgnoreCase("account")) {
                    if (customerList != null) {
                        for (Customer c : customerList) {
                            for (Account a : c.getAccounts()) {
                                if (a.getAddresses().length == 0) {

                                    System.out.println(a.getAccountNumber());

                                }
                            }
                        }
                    } else {
                        System.out.println("No records found");
                    }
                } else if (cmd[1].equalsIgnoreCase("customer")) {
                    if (customerList != null) {
                        for (Customer c : customerList) {
                            if (c.getAccounts().length == 0) {
                                System.out.println(c.getLastName() + ", " + c.getFirstName());

                            }
                        }
                    } else {
                        System.out.println("No records found");
                    }
                } else if (cmd[1].equalsIgnoreCase("address")) {
                    if (customerList != null) {
                        for (Customer c : customerList) {
                            for (Account a : c.getAccounts()) {
                                for (Address ad : a.getAddresses()) {
                                    if (ad.getMeters().length == 0) {
                                        System.out.println(ad.getNumber() + " " + ad.getStreet());

                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("No records found");
                    }
                } else if (cmd[1].equalsIgnoreCase("meter")) {
                    if (customerList != null) {
                        for (Customer c : customerList) {
                            for (Account a : c.getAccounts()) {
                                for (Address ad : a.getAddresses()) {
                                    for (Meter m : ad.getMeters()) {
                                        
                                        if (m.getReadings().length > 0) {
                                            if(!m.getCurrentReading().getFlag().equals(m.getType())){
                                                System.out.println("Invalid command");
                                            }
                                            

                                        }
                                        
                                            System.out.println(m.getID());
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("No records found");
                    }
                }
            } else if (command.equalsIgnoreCase("report balance")) {
                if (customerList != null) {
                    for (Customer c : customerList) {
                        for (Account a : c.getAccounts()) {
                            System.out.println("Account: " + a.getAccountNumber());
                            a.updateBalance();
                            System.out.println("  Customer: " + c.getLastName() + ", " + c.getFirstName());
                            DecimalFormat df = new DecimalFormat("0.00");
                            System.out.println("  Balance: $" + df.format(a.getCurrentBalance()));
                        }
                    }
                } else {
                    System.out.println("No records found");
                }
            } else if (command.equalsIgnoreCase("quit")) {
                System.out.println("Program ending");
            } else {
                System.out.println("Invalid command: " + command);
            }
        }
    }
}
