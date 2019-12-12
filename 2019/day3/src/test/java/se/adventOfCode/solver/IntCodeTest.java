package se.adventOfCode.solver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntCodeTest {

    @Autowired
    CrossedWireSolver calculator;

    @Test
    public void calculateLastState() {

        assertEquals(6, calculator.calculateClosestCrossing("testInput1"));
        assertEquals(159, calculator.calculateClosestCrossing("testInput2"));
        assertEquals(135, calculator.calculateClosestCrossing("testInput3"));
    }

}