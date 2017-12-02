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

        assertEquals(18, checksumGen.calcChecksum(testLines), "calcChecksum");
    }

    @org.junit.jupiter.api.Test
    void getEvenChecksum() {
        Day2 checksumGen = new Day2();
        ArrayList<String[]> testLines2 = new ArrayList<String[]>();
        testLines2.add(new String[]{"5","9","2","8"});
        testLines2.add(new String[]{"9","4", "7", "3"});
        testLines2.add(new String[]{"3","8","6","5"});

        assertEquals(9, checksumGen.calcEvenChecksum(testLines2),  "calcEvenChecksum");
    }
}