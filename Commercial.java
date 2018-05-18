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
public class Commercial extends Address {
    private String type;
    public Commercial(String s, int hn, String z, String bt) {
        super(s, hn, z, bt);
        type = bt;
    }

     public String getType() {
        return type;
    }
}
