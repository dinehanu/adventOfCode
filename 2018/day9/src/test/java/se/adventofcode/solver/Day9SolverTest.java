package se.adventofcode.solver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day9SolverTest {

    private Day9Solver solver;

    @BeforeEach
    void setUp() {
        this.solver = new Day9Solver();
    }

    @Test
    void solveFirstTask() {
        assertEquals(32, solver.solveFirstTask(9, 25));
        assertEquals(8317, solver.solveFirstTask(10, 1618));
        assertEquals(146373, solver.solveFirstTask(13, 7999));
        assertEquals(2764, solver.solveFirstTask(17, 1104));
        assertEquals(54718, solver.solveFirstTask(21, 6111));
        assertEquals(37305, solver.solveFirstTask(30, 5807));
    }
}