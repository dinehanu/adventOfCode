package se.adventofcode.solvers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Day4SolverTest {

    @Autowired
    Day4Solver solver;

    @Test
    public void runStrategyOne(){
    assertEquals(240, solver.runStrategyOne("input"));
    }

    @Test
    public void runStrategyTwo(){
        assertEquals(4455, solver.runStrategyTwo("input"));
    }

}