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
public class CommercialAccount extends Account{

    public CommercialAccount(String a, Customer c) {
        super(a, c);
    }
    @Override
    public void updateBalance(){
         double sum = 0;
        for(Address a: this.getAddresses()){
            for (Meter m: a.getMeters()) {
                for (MeterReading mr: m.getReadings()) {
                    
                    sum = sum + mr.getReading();
                }                
            }
        }
        this.setBalance(sum * commercialUnitRate);                
    }
        
    
}
