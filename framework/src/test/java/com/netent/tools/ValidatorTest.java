package com.netent.tools;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ValidatorTest {

    public static final Validator validator = new Validator();
    boolean expected;
    String actual;

    public ValidatorTest(boolean expected, String actual) {
        this.expected = expected;
        this.actual = actual;
    }

    @Parameterized.Parameters(name = "{index}:  (result is {1}") // тестовое сообщение
    public static Collection<Object[]> data() {

        Object[][] data = new Object[][]{
                {true, "1000000000"},
                {false, "Ukraine"},
                {false, "http://example.com/dss"},
                {false, "-925"},
                {true, "0"},
                {false, " "}

        };
        return Arrays.asList(data);
    }

    @Test(timeout = 3000)
    public void testSortingMin() throws Exception {
        Assert.assertEquals(expected, validator.isNumber(actual));
    }

}