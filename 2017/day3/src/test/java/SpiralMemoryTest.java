import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMemoryTest {


    private SpiralMemory spiralMemory;

    @BeforeEach
    void setUp() {
        this.spiralMemory = new SpiralMemory();
    }

    @Test
    void calculateNumberOfSteps_1() {
        assertEquals(0, this.spiralMemory.calculateTotalNumberOfSteps(1), "calculateNumberOfSteps Input 1");
    }

    @Test
    void calculateNumberOfSteps_12() {
        assertEquals(3, this.spiralMemory.calculateTotalNumberOfSteps(12), "calculateNumberOfSteps Input 12");
    }

    @Test
    void calculateNumberOfSteps_23() {
        assertEquals(2, this.spiralMemory.calculateTotalNumberOfSteps(23), "calculateNumberOfSteps Input 23");
    }

    @Test
    void calculateNumberOfSteps_1024() {
        assertEquals(31, this.spiralMemory.calculateTotalNumberOfSteps(1024), "calculateNumberOfSteps Input 1024");
    }


}