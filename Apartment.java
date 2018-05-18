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
public class Apartment extends Address{
    private String type;
    private String unit;
        public Apartment(String s, int hn, String z, String bt, String u){
            super(s, hn, z, bt);
            unit = u;
            type = bt;
        }

    public String getType(){
        return type;
    }
    public void setUnit(String u){
        unit = u;
    }
    public String getUnit(){
        return unit;
    }
    
    
}
