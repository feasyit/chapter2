/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.chapter2;

import java.util.Scanner;

/**
 *
 * @author anonymous
 */
public class Grade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int error, G, P, Total, N;
        float score = scanner.nextFloat();
        N = (int) score;
        error = (int) (N / 101) * 3;//More than 100 then Error
        G = (int) (N % 101 / 90) * 2;//Get grade 'G' if score between 90 and 100
        P = N % 101 % 90 / 60; //Get grade 'P' if score between 60 and 89;  
        Total = error + G + P;//other 'F'(less than 50) 
        switch (Total) {
            case 0:
                System.out.println("You get grade F");
                break;
            case 1:
                System.out.println("You get grade P");
                break;
            case 2:
                System.out.println("You get grade G");
                break;
            default:
                System.out.println("Error!");
        }
    }
}
