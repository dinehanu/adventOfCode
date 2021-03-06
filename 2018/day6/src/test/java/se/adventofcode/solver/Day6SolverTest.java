package se.adventofcode.solver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day6SolverTest {

    private Day6Solver solver;

    @BeforeEach
    void setUp() {
        this.solver = new Day6Solver();
    }

    @Test
    void solveFirstTask() {
        assertEquals(17, solver.solveFirstTask());
    }

    @Test
    void solveSecondTask() {
        assertEquals(16, solver.solveSecondTask(32));
    }
}