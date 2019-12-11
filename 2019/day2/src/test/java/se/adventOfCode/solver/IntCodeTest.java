package se.adventOfCode.solver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.adventOfCode.util.FileReader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntCodeTest {

    @Autowired
    IntCodeCalculator calculator;


    @Autowired
    FileReader fileReader;

    @Test
    public void calculateLastState() {

        int[] firstArray = fileReader.getFileContentAsArray("testInput1");
        assertEquals(2, calculator.calculateLastState(firstArray));
        int[] secondArray = fileReader.getFileContentAsArray("testInput2");
        assertEquals(6, calculator.calculateLastState(secondArray));
        int[] thirdArray = fileReader.getFileContentAsArray("testInput3");
        assertEquals(9801, calculator.calculateLastState(thirdArray));
        int[] fourthArray = fileReader.getFileContentAsArray("testInput4");
        assertEquals(30, calculator.calculateLastState(fourthArray));
    }
}