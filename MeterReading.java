/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07;
import java.time.LocalDateTime;

/**
 *
 * @author Danny
 */
public class MeterReading {
    private double enunits;
    private LocalDateTime ldt;
    private String flag;
    private Meter m;
    public MeterReading(double eu, LocalDateTime l, String f, Meter g){
        enunits = eu;
        ldt = l;
        flag = f;
        m = g;
    }
    
    public double getReading(){
        return enunits;
    } 
    public LocalDateTime getDateTime(){
        return ldt;
    }
    public String getFlag(){
        return flag;
    }    
    public Meter getMeter(){
        return m;
    }
    
}
