package com.adventofcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassphraseValidatorTest {

    private PassphraseValidator validator;

    @Before
    public void setUp() throws Exception {
        this.validator = new PassphraseValidator();
    }

    @Test
    public void getNumberOfValidPassphrases() {
        Assert.assertEquals("testpassphrasses should return 2", 2, validator.getNumberOfValidPassphrases("testPassphrases.txt"));
    }

    @Test
    public void getNumberOfValidPassphrases_Harder() {
        Assert.assertEquals("testpassphrasses should return 2", 3, validator.getNumberOfValidPassphrases_Harder("harderTestPassphrases.txt"));
    }
}