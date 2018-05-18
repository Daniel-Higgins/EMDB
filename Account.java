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
public abstract class Account implements Constants{
    
private String accountNumber;
    private Customer customer;
    private double balance;
    private ArrayList<Address> addresses;

// The following methods should be available:
// - getAccountNumber() - Returns a String representing an account number
    public String getAccountNumber() {
        return accountNumber;
    }

// - getCustomer() - Returns a reference to a Customer (see below)
    public Customer getCustomer() {
        return customer;
    }
// - getCurrentBalance() - Returns a double
    public double getCurrentBalance(){
        return balance;
    }
    
    public void setBalance(double b){
        balance = b;
        //System.out.println("setBalance:" + b);
    }
    
    public abstract void updateBalance();

    // - getAddresses() - Returns an array of Address objects associated with the account

    public Address[] getAddresses() {
        Address[] addressArray = new Address[addresses.size()];
        addressArray = addresses.toArray(addressArray);
        return addressArray;
    }

// - addAddress(Address a) - Add an Address reference to this account. 
//    Returns a boolean to indicate success or failure.
    public boolean addAddress(Address a) {
        addresses.add(a);
        return true;
    }
// - removeAddress(Address a) - Removes the named Address from those 
//    associated with this account. Returns a boolean to indicate success or failure.

    public boolean removeAddress(Address a) {
        boolean returnVal = false;
        //Check if present
        if (addresses.contains(a)) {
            // Found it, now remove
            addresses.remove(a);
            returnVal = true;
        }
        return returnVal;
    }

// - A constructor to initialize the account number and customer. For now, initialize the balance to zero.
    public Account(String a, Customer c) {
        accountNumber = a;
        customer = c;
        balance = 0;
        addresses = new ArrayList<Address>();
    }
}
