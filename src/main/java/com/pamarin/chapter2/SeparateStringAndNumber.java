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
public class SeparateStringAndNumber {

    private static boolean is(char ch, char start, char end) {
        return (int) start <= (int) ch && (int) ch <= (int) end;
    }

    private static boolean isString(char ch) {
        return is(ch, 'A', 'Z') || is(ch, 'a', 'z');
    }

    private static boolean isNumber(char ch) {
        return is(ch, '0', '9');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        String str = "";
        String number = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isNumber(ch)) {
                number = number + ch;
            }

            if (isString(ch)) {
                str = str + ch;
            }
        }
        
        System.out.println("number -> " + number);
        System.out.println("string --> " + str);
    }
}
