package se.adventOfCode.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventOfCode.util.FileReader;

@Component
public class IntCodeCalculator {

    @Autowired
    FileReader fileReader;

    public long calculateFirstState(){
        return this.calculateFirstState("input");
    }

    public long calculateSecondState(){
        return this.calculateFirstState("input");
    }

    public long calculateFirstState(String filePath){
        int[] code = fileReader.getFileContentAsArray(filePath);
            code[1] = 12;
            code[2] = 2;
            calculateLastState(code);
            return code[0];
    }

    public int calculateLastState(int[] code) {
        int solution = 0;
        for (int i = 0; i < code.length ; i = i+4) {
            switch (code[i]){
                case 1: solution = addition(code, i); break;
                case 2:  solution = multiplication(code, i); break;
                case 99: return solution;
                default: return 0;
            }
            int newIndex = code[i+3];
            code[newIndex] = solution;
        }
        return 0;
    }

    private int addition(int[] code, int index) {
        int firstValueIndex = code[index+1];
        int secondValueIndex = code[index+2];
        return code[firstValueIndex] + code[secondValueIndex];
    }

    private int multiplication(int[] code, int index) {
        int firstValueIndex = code[index+1];
        int secondValueIndex = code[index+2];
        return code[firstValueIndex] * code[secondValueIndex];
    }

}
