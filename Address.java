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
public abstract class Address {

    private String street;
    private int houseNumber;
    private String zip;
    private String buildingType;
    public Address(String s, int hn, String z, String bt){
        houseNumber = hn;
        street = s;
        zip = z;
        buildingType = bt;
        meter = new ArrayList<Meter>();
    }
    private ArrayList<Meter> meter;
    private Account a;
    public String getStreet() {
        return street;
    }
    public int getNumber() {
        return houseNumber;
    }
    public String getZipCode() {
        return zip;
    }
    public abstract String getType();
    public Meter[] getMeters() {
      
         Meter [] m = new Meter[meter.size()]; 
        m = meter.toArray(m);
        return m;
    }
    public boolean addMeter(Meter m) {
        return meter.add(m);
        

    }

    public boolean removeMeter(String id) {
        for (int i = 0; i < meter.size(); i++) {
            if(id.equals(meter.get(i).getID())){
                meter.remove(i);
                return true;
            }
        }
        return false;
        
    }
    public Account getAccount(){
        return a;
    }
   
   public void setAccount(Account aa) {
        a = aa;      
    }
}