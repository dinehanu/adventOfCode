package se.adventofcode.solver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OverlapCalculatorTest {

    @Autowired
    OverlapCalculator calculator;

    @Test
    public void calculateOverlap() {
        assertEquals(4, calculator.calculateOverlap("testinput1"));
    }

    @Test
    public void calculateNonOverlapingId() {
        assertEquals(3, calculator.calculateNonOverlapingId("testinput1"));
    }
}