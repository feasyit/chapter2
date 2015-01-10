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
public class GarbageTest {

    public static void main(String[] args) {
        Object obj = new Object() {

            @Override
            protected void finalize() throws Throwable {
                System.out.println("call before garbage");
            }

        };

        obj = new Object();
        obj = new Object();
        System.gc();
    }
}
