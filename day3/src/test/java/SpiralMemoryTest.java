import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMemoryTest {

    @Test
    void calculateNumberOfSteps() {

        SpiralMemory spiralMemory = new SpiralMemory();

        assertEquals(0, spiralMemory.calculateNumberOfSteps(1), "calculateNumberOfSteps Input 1");
        assertEquals(3, spiralMemory.calculateNumberOfSteps(12), "calculateNumberOfSteps Input 1");
        assertEquals(2, spiralMemory.calculateNumberOfSteps(23), "calculateNumberOfSteps Input 1");
        assertEquals(31, spiralMemory.calculateNumberOfSteps(1024), "calculateNumberOfSteps Input 1");
    }
}