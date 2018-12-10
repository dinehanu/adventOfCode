package adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.adventofcode.solver.Day10Solver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10SolverTest {

    private Day10Solver solver;

    @BeforeEach
    void setUp() {
        this.solver = new Day10Solver();
    }

    @Test
    void solveFirstTask() {
        solver.solveFirstTask(0, 4);
    }

    @Test
    void solveSecondTask() {
        assertEquals(10000, solver.solveSecondTask());
    }
}
