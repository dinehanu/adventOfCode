package se.adventOfCode.solver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrequencyCalculatorTest {

    @Autowired
    FrequencyCalculator calculator;

    @Test
    public void calculateFrequency() {

        assertEquals(calculator.calculateFrequency("testfile1"), 3);
        assertEquals(calculator.calculateFrequency("testfile2"), 3);
        assertEquals(calculator.calculateFrequency("testfile3"), 0);
        assertEquals(calculator.calculateFrequency("testfile4"), -6);
    }

    @Test
    public void calculateFirstDuplicateFrequency() {

        assertEquals(calculator.calculateFirstDuplicateFrequency("testfile5"), 0);
        assertEquals(calculator.calculateFirstDuplicateFrequency("testfile6"), 10);
        assertEquals(calculator.calculateFirstDuplicateFrequency("testfile7"), 5);
        assertEquals(calculator.calculateFirstDuplicateFrequency("testfile8"), 14);
    }
}