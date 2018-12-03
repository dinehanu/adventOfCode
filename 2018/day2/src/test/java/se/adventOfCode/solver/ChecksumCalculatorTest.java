package se.adventOfCode.solver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChecksumCalculatorTest {

    @Autowired
    ChecksumCalculator calculator;

    @Test
    public void calculateChecksum() {
        assertEquals(12, calculator.calculateChecksum("testfile"));
    }

    @Test
    public void findMatchingId() {
        assertEquals("fgij", calculator.findMatchingId("testfile2"));
    }
}