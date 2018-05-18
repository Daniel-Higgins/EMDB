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
public class MailingAddress extends Address{
    public MailingAddress(String s, int h, String z, String t) {
        super(s,h,z,t);
    }
    
    public String getType(){
        return "mailing";
    }
    
}
