package com.netent.tools;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConsoleTest {
    public static Console console;

    @BeforeClass
    public static void setUpClass() throws Exception {
        console = new Console();
    }

    @Test
    public void parseNumberTest() throws Exception {
        Long expected = 1000L;
        Long actual = console.parseNumber("1000");

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void parseNumberTestDouble() throws Exception {
        Long expected = -53L;
        Long actual = console.parseNumber("-53");

        Assert.assertEquals(expected, actual);
    }

}