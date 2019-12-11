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
    public void calculateState1() {

        assertEquals(2, calculator.calculateFirstState("testInput1"));
        assertEquals(6, calculator.calculateFirstState("testInput2"));
        assertEquals(9801, calculator.calculateFirstState("testInput3"));
        assertEquals(30, calculator.calculateFirstState("testInput4"));
    }

}