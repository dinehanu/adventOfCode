package se.adventOfCode.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventOfCode.util.FileReader;

import java.util.ArrayList;

@Component
public class RocketEquationCalculator {

    @Autowired
    FileReader fileReader;

    public long calculateFirstState(){
        return this.calculateFirstState("input");
    }

    public long calculateFirstState(String filePath){

        int[] code = fileReader.getFileContentAsArray(filePath);

       return calculateState(code);
    }

    public int calculateState(int[] code) {
        return 0;
    }

}
