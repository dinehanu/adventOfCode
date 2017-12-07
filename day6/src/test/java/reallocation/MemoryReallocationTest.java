package reallocation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MemoryReallocationTest {

    private MemoryReallocation mem;

    @Before
    public void setUp() throws Exception {
        this.mem = new MemoryReallocation();
    }

    @Test
    public void getNumberOfStepsToReallocate() {
        assertEquals("Memory allocation part 1", 5, mem.getNumberOfStepsToReallocate("memoryTest.txt"));
    }

    @Test
    public void getNumberOfStepsToReallocate_part2() {
        assertEquals("Memory allocation part 1", 4, mem.getNumberOfStepsToReallocate_part2("memoryTest.txt"));
    }
}