package com.adventofcode.captchasum;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class CaptchaSumTest {
    @Test
    public void sumCaptchas1() throws Exception {

        CaptchaSum testClass = new CaptchaSum();
        assertEquals(testClass.sumCaptchas("1122"), 3);
    }
    @Test
    public void sumCaptchas2() throws Exception {

        CaptchaSum testClass = new CaptchaSum();

        assertEquals(testClass.sumCaptchas("1111"), 4);
    }
    @Test
    public void sumCaptchas3() throws Exception {
        CaptchaSum testClass = new CaptchaSum();
        assertEquals(testClass.sumCaptchas("1234"), 0);
    }
    @Test
    public void sumCaptchas4() throws Exception {

        CaptchaSum testClass = new CaptchaSum();
        assertEquals(testClass.sumCaptchas("91212129"), 9);
    }

    @Test
    public void sumCaptchasHalfway1() throws Exception {

        CaptchaSum testClass = new CaptchaSum();
        assertEquals(testClass.sumCaptchasHalfway("1212"), 6);
    }
    @Test
    public void sumCaptchasHalfway2() throws Exception {

        CaptchaSum testClass = new CaptchaSum();

        assertEquals(testClass.sumCaptchasHalfway("1221"), 0);
    }
    @Test
    public void sumCaptchasHalfway3() throws Exception {
        CaptchaSum testClass = new CaptchaSum();
        assertEquals(testClass.sumCaptchasHalfway("123425"), 4);
    }
    @Test
    public void sumCaptchasHalfway4() throws Exception {

        CaptchaSum testClass = new CaptchaSum();
        assertEquals(testClass.sumCaptchasHalfway("123123"), 12);
    }
    @Test
    public void sumCaptchasHalfway5() throws Exception {

        CaptchaSum testClass = new CaptchaSum();
        assertEquals(testClass.sumCaptchasHalfway("12131415"), 4);
    }

}