package se.adventofcode.solver;

import static org.junit.Assert.*;

public class Day5SolverTest {

    private Day5Solver solver;

    @org.junit.Before
    public void setUp() throws Exception {
        solver = new Day5Solver();
    }

    @org.junit.Test
    public void calculateRemainingUnits() {
        assertEquals(10, solver.calculateRemainingUnits());
    }
}