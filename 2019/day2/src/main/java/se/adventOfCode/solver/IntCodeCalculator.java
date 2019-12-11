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

    public int[] calculateSecondState(){
        return this.calculateDesiredInputs("input", 19690720);
    }

    public int[] calculateDesiredInputs(String filePath, int wantedOutput){
        int[] code = fileReader.getFileContentAsArray(filePath);
        code[1] = 12;
        code[2] = 2;
        int[] test = calculateInputs(code, wantedOutput);
        return calculateInputs(code, wantedOutput);
    }

    public long calculateFirstState(String filePath){
        int[] code = fileReader.getFileContentAsArray(filePath);
            code[1] = 12;
            code[2] = 2;
            calculateLastState(code);
            return code[0];
    }

    public int[] calculateInputs(int[] code, int wantedOutput) {
        int solution = 0;
        int firstInput = 0;
        int secondInput = 0;
        for (int i = 0; i < code.length ; i = i+4) {

            int firstValueIndex = code[i+1];
            int secondValueIndex = code[i+2];
            firstInput = code[firstValueIndex];
            secondInput = code[secondValueIndex];

            switch (code[i]){
                case 1: solution = (100 * firstInput) + secondInput; break;
                case 2:  solution = 100 * firstInput * secondInput; break;
                default: return new int[]{};
            }

            if(solution == wantedOutput){
                break;
            }
        }
        return new int[]{firstInput, secondInput};
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
