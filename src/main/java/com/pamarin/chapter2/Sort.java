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
public class Sort {

    public static void main(String[] args) {
        int[] numbers = {78, 4545, 1, 54, 5, 985, 98, 847, 8};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        
        for(int numb : numbers){
            System.out.print(numb + " ");
        }
    }
}
