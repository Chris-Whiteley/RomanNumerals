/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris
 */
public class RomanNumberTest {

    public RomanNumberTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class RomanNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RomanNumber instance = new RomanNumber(2944);
        String expResult = "MMCMXLIV";
        String result = instance.toString();
        assertEquals(expResult, result);
        instance = new RomanNumber(9);
        expResult = "IX";
        result = instance.toString();
        assertEquals(expResult, result);
        instance = new RomanNumber(1009);
        expResult = "MIX";
        result = instance.toString();
        assertEquals(expResult, result);
        instance = new RomanNumber(549);
        expResult = "DXLIX";
        result = instance.toString();
        assertEquals(expResult, result);
        instance = new RomanNumber(509);
        expResult = "DIX";
        result = instance.toString();
        assertEquals(expResult, result);
        instance = new RomanNumber(159);
        expResult = "CLIX";
        result = instance.toString();
        assertEquals(expResult, result);
        instance = new RomanNumber(2554);
        expResult = "MMDLIV";
        result = instance.toString();
        assertEquals(expResult, result);
        instance = new RomanNumber(2000);
        expResult = "MM";
        result = instance.toString();
        assertEquals(expResult, result);
        instance = new RomanNumber(1996);
        expResult = "MCMXCVI";
        result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toInt method, of class RomanNumber.
     */
    @Test
    public void testToInt() {
        System.out.println("toInt");
        RomanNumber instance = new RomanNumber("MMDCDXLIV");
        int expResult = 2944;
        int result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("MMCMXLIV");
        expResult = 2944;
        result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("VIV");
        expResult = 9;
        result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("IX");
        expResult = 9;
        result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("MIX");
        expResult = 1009;
        result = instance.toInt();
        assertEquals(expResult, result);
        try {
            instance = new RomanNumber("LID");
            assertTrue("NumberFormatException expected", false);
        } catch (NumberFormatException nfe) {
            assertTrue("NumberFormatException expected", true);
        }
        instance = new RomanNumber("DIX");
        expResult = 509;
        result = instance.toInt();
        assertEquals(expResult, result);
        try {
            instance = new RomanNumber("LICX");
            assertTrue("NumberFormatException expected", false);
        } catch (NumberFormatException nfe) {
            assertTrue("NumberFormatException expected", true);
        }

        instance = new RomanNumber("CLIX");
        expResult = 159;
        result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("MMDLIV");
        expResult = 2554;
        result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("MMXDLIV");
        expResult = 2544;
        result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("MCMXCX");
        expResult = 2000;
        result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("MCMXCVI");
        expResult = 1996;
        result = instance.toInt();
        assertEquals(expResult, result);
        instance = new RomanNumber("DXLIX");
        expResult = 549;
        result = instance.toInt();
        assertEquals(expResult, result);
        try {
            instance = new RomanNumber("IIV");
            assertTrue("NumberFormatException expected", false);
        } catch (NumberFormatException nfe) {
            assertTrue("NumberFormatException expected", true);
        }

        instance = new RomanNumber("DXLIX");
        expResult = 549;
        result = instance.toInt();
        assertEquals(expResult, result);
    }

}
