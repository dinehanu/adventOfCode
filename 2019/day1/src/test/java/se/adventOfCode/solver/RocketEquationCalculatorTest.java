package se.adventOfCode.solver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketEquationCalculatorTest {

    @Autowired
    RocketEquationCalculator calculator;

    @Test
    public void calculateFuel1() {

        assertEquals(2, calculator.calculateFuel(12));
        assertEquals(2, calculator.calculateFuel(14));
        assertEquals(654, calculator.calculateFuel(1969));
        assertEquals(33583, calculator.calculateFuel(100756));
    }

    @Test
    public void calculateFuel2() {

        assertEquals(2, calculator.calculateAdditionalFuel(14));
        assertEquals(966, calculator.calculateAdditionalFuel(1969));
        assertEquals(50346, calculator.calculateAdditionalFuel(100756));
    }

}