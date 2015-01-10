/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pamarin.chapter2;

/**
 *
 * @author anonymous
 */
public class SeparateStringPattern {
    
    public static void main(String[] args) {
        String input = "1234-5647-901";
        String split[] = input.split("-");
        System.out.print(split[0] + ", " + split[1] + ", " + split[2]);
    }
}
