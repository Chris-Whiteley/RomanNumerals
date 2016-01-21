/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgi;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An object of type RomanNumber is an integer between 1 and 5000. It can be
 * constructed either from an integer or from a string that represents a Roman
 * number in this range. The function toString() will return a standardised
 * Roman number representation of the number. The function toInt() will return
 * the number as a value of type int.
 *
 * @author Chris
 */
public class RomanNumber {

    private final String roman;
    private final int arabic;
    private final Map<String, Integer> numeralLookup;

    public RomanNumber(int arabic) {
        numeralLookup = getRomanNumerals();
        this.arabic = arabic;
        roman = toRoman(this.arabic);
    }

    public RomanNumber(String roman) {
        numeralLookup = getRomanNumerals();
        this.arabic = toArabic(roman);
        this.roman = toRoman(this.arabic);
    }

    private int toArabic(String roman) {
        if (roman.isEmpty()) {
            throw new NumberFormatException("Empty String.");
        }
        int value = 0;
        int previous = 0;
        int max = 0;
        StringBuilder builder = new StringBuilder(roman);
        builder.reverse();  // check digits in order of least significant to most significant digits 
        for (int i = 0; i < builder.length(); i++) {
            Integer current = numeralLookup.get(String.valueOf(builder.charAt(i)));

            if (current == null) {
                throw new NumberFormatException("Unrecognised character : " + builder.charAt(i));
            }

            // If the value of the roman numeral suddenly drops then subtract, don't add.
            if (current < previous) {
                if (current == 1 || current == 10 || current == 100) {
                    value -= current;
                } else {
                    // only 1, 10, 100 allowed for subtraction rule
                    throw new NumberFormatException("Invalid character combination at: " + builder.charAt(i));
                }
            } else {
                // should put a check in here to check that current is >= max i.e. we are increasing the value of the digits as we go along.
                // i.e. digits should increase in magnitude ones, tens, hundreds, and thousands as separate items
                if (current >= max) {
                    value += current;
                    max = current;

                } else {
                    throw new NumberFormatException("Invalid character combination at: " + builder.charAt(i));
                }
            }

            previous = current;
        }
        return value;
    }

    private Map<String, Integer> getRomanNumerals() {
        Map<String, Integer> numerals = new LinkedHashMap<>(13);
        // Initialize in descending order.
        numerals.put("M", 1_000);
        numerals.put("CM", 900);
        numerals.put("D", 500);
        numerals.put("CD", 400);
        numerals.put("C", 100);
        numerals.put("XC", 90);
        numerals.put("L", 50);
        numerals.put("XL", 40);
        numerals.put("X", 10);
        numerals.put("IX", 9);
        numerals.put("V", 5);
        numerals.put("IV", 4);
        numerals.put("I", 1);
        return numerals;
    }

    @Override
    public String toString() {
        return roman;
    }

    public int toInt() {
        return arabic;
    }

    private String toRoman(int value) {
        if (value < 0 || value >= 5_000) {
            throw new ArithmeticException("Unsupported value : " + value);
        }

        StringBuilder builder = new StringBuilder(10);
        for (Map.Entry<String, Integer> entry : numeralLookup.entrySet()) {
            int v = entry.getValue();
            String k = entry.getKey();
            while (value >= v) {
                value -= v;
                builder.append(k);
            }
        }
        return builder.toString();
    }

}
