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

    public void solveFirstTask(){
        List<String> lines = fileReader.getFileContentAsArray("input");
        int[][] values = getValues(lines);

        for (int i = 0; i < 15000; i++) {
            System.out.println("index is: " + i);
            String[][] currentPositions = IntStream.range(0, 300)
                    .mapToObj(j -> IntStream.range(0, 300).mapToObj(k -> " ").toArray(String[]::new))
                    .toArray(String[][]::new);
            for (int[] positions: values) {
                int y = Math.abs(positions[0]+positions[2]*i)%100;
                int x = Math.abs(positions[1]+positions[3]*i)%100;
                currentPositions[x][y] = "#";
            }
            printMatrix(currentPositions);
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
        for (int x = 0; x < 100; x++) {
            String line = "";
            for (int y = 0; y < 100; y++) {
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
