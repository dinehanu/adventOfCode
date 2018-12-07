package se.adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.adventofcode.solver.Day7Solver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7SolverTest {

    private Day7Solver solver;

    @BeforeEach
    void setUp() {
        this.solver = new Day7Solver();
    }

    @Test
    void solveFirstTask() {
        assertEquals("CABDFE", solver.solveFirstTask());
    }

    @Test
    void solveSecondTask() {
        assertEquals(15, solver.solveSecondTask(2, 0));
    }
}
