package com.netent.tools;


import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    Validator validator = new Validator();

    @Test
    public void isNumberTest() throws Exception {
        Assert.assertTrue(validator.isNumber("100"));
    }
    @Test
    public void StringIsNumberTest() throws Exception {
        Assert.assertFalse(validator.isNumber("first"));
    }
    @Test
    public void backspaceIsNumberTest() throws Exception {
        Assert.assertFalse(validator.isNumber(" "));
    }
}