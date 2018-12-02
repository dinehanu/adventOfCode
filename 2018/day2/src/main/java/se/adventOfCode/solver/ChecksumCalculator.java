package se.adventOfCode.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventOfCode.util.FileReader;

@Component
public class ChecksumCalculator {

    @Autowired
    FileReader fileReader;

    public long calculateChecksum() { return this.calculateChecksum("input"); }

    public long calculateChecksum(String filepath) {
        long checksum = 0;

        return checksum;
    }
}
