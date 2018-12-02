package recursive;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursiveTowerCalculatorTest {

    private RecursiveTowerCalculator towerCalculator;

    @Before
    public void setUp() throws Exception {
        towerCalculator = new RecursiveTowerCalculator();
    }

    @Test
    public void getLowestTower() {
        assertEquals("Recursive tower part 1", "tknk", towerCalculator.getLowestTower("testTower.txt"));
    }
}