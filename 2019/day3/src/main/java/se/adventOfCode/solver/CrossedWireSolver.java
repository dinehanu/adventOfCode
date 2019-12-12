package se.adventOfCode.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventOfCode.util.FileReader;

import java.util.ArrayList;
import java.util.List;

@Component
public class CrossedWireSolver {

    @Autowired
    FileReader fileReader;

    public int solveCrossedWires(){
        return this.calculateClosestCrossing("input");
    }


    public int calculateClosestCrossing(String filename){

        List<int[]> wires = fileReader.getFileContentAsArray(filename);

        
        return 0;
    }


}
