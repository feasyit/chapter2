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
public class ThaiNumberReader {

    private static final String THAI_LEVEL[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน"};
    private static final String THAI_WORD[] = {"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};

    public String read(double number, int floatingPoint) {
        String notation = (number < 0) ? "ลบ" : "";
        number = absoluteNumber(number);
        return notation + beforePointReading(number) + (floatingPoint < 1 ? "" : ("จุด" + afterPointReading(number, floatingPoint)));
    }

    public String read(double number) {
        String numberString = number + "";
        int floatingPoint = 0;
        int indexOf = numberString.indexOf(".");
        if (indexOf != -1) {
            String floating = numberString.substring(indexOf + 1);
            floatingPoint = floating.equals("0") ? 0 : floating.length();
        }

        return read(number, floatingPoint);
    }

    private String checkZero(String reading) {
        return reading.isEmpty() ? "ศูนย์" : reading;
    }

    private double absoluteNumber(double number) {
        return number < 0 ? (-1) * number : number;
    }

    private String beforePointReading(double number) {
        long beforePointNumber = (long) number;//12.32 -> 12
        String reading = "";

        int index;
        int levelCount = 0;

        while (beforePointNumber > 0) {
            index = (int) (beforePointNumber % 10);
            String word = getWord(beforePointNumber, index, levelCount);
            String level = getLevel(index, levelCount);
            reading = word + level + reading;

            beforePointNumber = (beforePointNumber / 10);
            levelCount = levelCount + 1;
        }

        return checkZero(reading);
    }

    private String afterPointReading(double number, int floatingPoint) {
        double afterPointNumber = (number - (long) number);//12.32 - 12 -> 0.32
        String reading = "";

        for (int i = 1; i <= floatingPoint; i++) {
            int index = (int) (Math.pow(10, i) * afterPointNumber) % 10;
            reading = reading + THAI_WORD[index];
        }

        return checkZero(reading);
    }

    private String getWord(long number, int index, int levelCount) {
        String word;
        if (index == 0) {
            word = "";//0 จะไม่อ่านออกเสียง เช่น 20, 30, 40
        } else if (index == 1) {
            if ((levelCount % 6) == 0 && (number > 1)) {//เช็คระดับล้าน เช่น สิบเอ็ดล้าน
                word = "เอ็ด";//เช่น คำอ่านของ 101
            } else if (levelCount % 6 == 1) {
                word = "";//แทนคำอ่านของ 1 ซึ่งไม่อ่านออกเสียง เช่น 16, 19
            } else {
                word = "หนึ่ง";
            }
        } else if (index == 2) {
            if (levelCount % 6 == 1) {//เช็คระดับล้าน เช่น ยี่สิบล้าน
                word = "ยี่";//แทนคำอ่านของ 2 ในหลัก 10 เช่น 23
            } else {
                word = "สอง";
            }
        } else {
            word = THAI_WORD[index];
        }

        return word;
    }

    private String getLevel(int index, int levelCount) {
        String level;
        if ((levelCount != 0) && (levelCount % 6 == 0)) {
            level = "ล้าน";
        } else if (index != 0) {
            level = THAI_LEVEL[levelCount % 6];
        } else {
            level = "";//แทนหลักหน่วย  ซึ่งไม่อ่านออกเสียง
        }

        return level;
    }
    
    public static void main(String[] args) {
        ThaiNumberReader numberReader = new ThaiNumberReader();
        System.out.println("read --> " + numberReader.read(12));
    }
}
