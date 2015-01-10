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
public class Max {

    public static void main(String[] args) {
        int[] numbers = {78, 4545, 1, 54, 5, 985, 98, 847, 8};
        int max = numbers[0];

        for (int numb : numbers) {
            if (numb > max) {
                max = numb;
            }
        }
        
        System.out.println("max --> " + max);
    }
}
