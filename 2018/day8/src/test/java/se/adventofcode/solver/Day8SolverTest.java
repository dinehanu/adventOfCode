package se.adventofcode.solver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day8SolverTest {

    private Day8Solver solver;

    @BeforeEach
    void setUp() {
        this.solver = new Day8Solver();
    }

    @Test
    void solveFirstTask() {
        assertEquals(138, solver.solveFirstTask());
    }

    @Test
    void solveSecondTask() {
        assertEquals(66, solver.solveSecondTask());
    }
}