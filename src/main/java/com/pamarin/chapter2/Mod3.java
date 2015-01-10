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
public class Mod3 {
    
    public static void main(String[] args) {
        int count = 0;
        for(int i = 1; i<= 100; i++){
            if(i % 3 == 0){
                count++;
            }
        }
        
        System.out.println("count -> " + count);
    }
}
