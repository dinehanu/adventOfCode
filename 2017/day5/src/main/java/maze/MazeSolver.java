package maze;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class MazeSolver {

    public int getNumberOfStepsToSolveMaze(String filePath) {
        return calculateStepsToSolveMaze(getMazeFileAsArray(filePath));
    }

    public int getNumberOfStepsToSolveMaze_PartTwo(String filePath) {
        return calculateStepsToSolveMaze_PartTwo(getMazeFileAsArray(filePath));
    }

    private int calculateStepsToSolveMaze(List<Integer> maze) {
        int index = 0;
        int numberOfSteps = 0;
        while (index < maze.size() && index >= 0) {
            int stepToTake = maze.get(index);
            maze.set(index, (stepToTake + 1));
            index += stepToTake;
            numberOfSteps++;
        }
        return numberOfSteps;
    }

    private int calculateStepsToSolveMaze_PartTwo(List<Integer> maze) {
        int index = 0;
        int numberOfSteps = 0;
        while (index < maze.size() && index >= 0) {
            int stepToTake = maze.get(index);
            int change = stepToTake >= 3 ? (stepToTake-1) : (stepToTake+1);
            maze.set(index, change);
            index += stepToTake;
            numberOfSteps++;
        }
        return numberOfSteps;
    }

    private List<Integer> getMazeFileAsArray(String fileName) {
        List<Integer> maze = new ArrayList<>();

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                maze.add(Integer.parseInt(line));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maze;
    }
}
