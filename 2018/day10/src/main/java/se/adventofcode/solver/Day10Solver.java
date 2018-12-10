package se.adventofcode.solver;

import se.adventofcode.util.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day10Solver {

    private final FileReader fileReader;

    public Day10Solver(){
        this.fileReader = new FileReader();
    }

    public void solveFirstTask(int start, int end){
        List<String> lines = fileReader.getFileContentAsArray("input");
        int[][] values = getValues(lines);

        IntStream stream = Arrays.stream(values).flatMapToInt(Arrays::stream);

        for (int i = start; i < end; i++) {
            int counter = 0;
            String[][] currentPositions = IntStream.range(0, 200)
                    .mapToObj(j -> IntStream.range(0, 200).mapToObj(k -> " ").toArray(String[]::new))
                    .toArray(String[][]::new);
            for (int[] positions: values) {
                int y = (positions[0]+(positions[2]*i));
                int x = (positions[1]+(positions[3]*i));
                if(x > 0 && y > 0){
                    if(x<currentPositions.length && y <currentPositions[x].length){
                        currentPositions[x][y] = "#";
                        counter++;
                    }
                }

            }
            if(counter == values.length){
                System.out.println("index is: " + i);
                printMatrix(currentPositions);
            }
        }
    }

    private int[][] getValues(List<String> lines ){
        int[][] values = new int[lines.size()][4];
        for (int i = 0; i < lines.size(); i++) {
            values[i] = Arrays.stream(lines.get(i).replaceAll("\\s", "").split("position=<|velocity=<|>|,"))
                    .filter(v -> v.length() > 0).mapToInt(v-> Integer.parseInt(v)).toArray();
        }
        return values;
    }

    public int solveSecondTask(){
       return 0;
    }

    private void printMatrix(String[][] matrix){
        for (int x = 0; x < matrix.length; x++) {
            String line = "";
            for (int y = 0; y < matrix[x].length; y++) {
                line += matrix[x][y];
            }
            System.out.println(line);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
