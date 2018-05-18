/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07;

import java.util.ArrayList;

/**
 *
 * @author Danny
 */
public class Customer {
     private String lastName;
    private String firstName;
    private Address mailingAddress;
    private ArrayList<Account> accounts;
    public String getLastName() {
        return lastName;
    }
//getFirstName() - Returns a String containing the customer’s first name
    public String getFirstName() {
        return firstName;
    }
    public Address getMailingAddress() {
        return mailingAddress;
    }
//getAccounts() - Returns an array of Account objects for this customer
    public Account[] getAccounts() {
        Account[] accountArray = new Account[accounts.size()];
        accountArray = accounts.toArray(accountArray);
        return accountArray;
    }
//addAccount(Account a) - Add an account for this customer
    public void addAccount(Account a) {
        accounts.add(a);
    }
//removeAccount(Account a) - remove account.
    public void removeAccount(Account a) {
        // Check if present
        if (accounts.contains(a)) {
            // found it, now remove it
            accounts.remove(a);
        }
    }
//A constructor that initializes the last name, first name, and address of the customer.
    public Customer(String l, String f, Address a) {
        lastName = l;
        firstName = f;
        mailingAddress = a;
        accounts = new ArrayList<Account>();
    }
    // New for HW3
       public Customer(String l, String f) {
        lastName = l;
        firstName = f;
        mailingAddress = null;
        accounts = new ArrayList<Account>();
    }  
    public void setMailingAddress(Address a){
        mailingAddress = a;
    }   
}