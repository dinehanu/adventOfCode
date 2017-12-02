import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @org.junit.jupiter.api.Test
    void getChecksum() {
        Day2 checksumGen = new Day2();
        ArrayList<String[]> testLines = new ArrayList<String[]>();
        testLines.add(new String[]{"5","1","9","5"});
        testLines.add(new String[]{"7","5","3"});
        testLines.add(new String[]{"2","4","6","8"});



        assertEquals(checksumGen.calcChecksum(testLines), 18, "calcChecksum");
    }
}