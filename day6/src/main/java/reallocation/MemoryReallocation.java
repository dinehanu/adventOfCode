package reallocation;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class MemoryReallocation {

    public int getNumberOfStepsToReallocate(String filePath) {

        int ret = 0;
        int[] memory = getMemoryAsArray(filePath);
        List<int[]> visitedAllocations = new ArrayList<>();

        while (!isInList(visitedAllocations, memory)) {
            int largestNumber = 0;
            int index = 0;
            visitedAllocations.add(memory.clone());

            for (int i = 0; i < memory.length; i++) {
                if (memory[i] > largestNumber) {
                    largestNumber = memory[i];
                    index = i;
                }
            }
            memory[index] = 0;
            int nextIndex = (index + 1) == memory.length ? 0 : (index + 1);
            for (int j = 0; j < largestNumber; j++) {
                if (nextIndex == memory.length) {
                    nextIndex = 0;
                }
                memory[nextIndex] = memory[nextIndex] + 1;
                nextIndex++;
            }
            ret++;
        }
        return ret;
    }

    public int getNumberOfStepsToReallocate_part2(String filePath) {

        int[] memory = getMemoryAsArray(filePath);
        List<VisitedMemory> visitedAllocations = new ArrayList<>();

        while (!visitedAllocations.contains(new VisitedMemory(memory.clone(), 0))) {
            int largestNumber = 0;
            int index = 0;
            visitedAllocations.add(new VisitedMemory(memory.clone(), 0));

            for (int i = 0; i < memory.length; i++) {
                if (memory[i] > largestNumber) {
                    largestNumber = memory[i];
                    index = i;
                }
            }
            memory[index] = 0;
            int nextIndex = (index + 1) == memory.length ? 0 : (index + 1);
            for (int j = 0; j < largestNumber; j++) {
                if (nextIndex == memory.length) {
                    nextIndex = 0;
                }
                memory[nextIndex] = memory[nextIndex] + 1;
                nextIndex++;
            }
            addStep(visitedAllocations);
        }
        int index = visitedAllocations.indexOf(new VisitedMemory(memory.clone(), 0));
        return visitedAllocations.get(index).getNumberOfSteps();
    }

    public void addStep(List<VisitedMemory> list){
        for (VisitedMemory visitedMemory : list) {
            visitedMemory.addStep();
        }
    }

    private class VisitedMemory {

        int[] memory;
        int numberOfSteps;

        public VisitedMemory(int[] memory, int numberOfSteps) {
            this.memory = memory;
            this.numberOfSteps = numberOfSteps;
        }

        public void addStep(){
            numberOfSteps++;
        }

        public int getNumberOfSteps(){
            return numberOfSteps;
        }

        @Override
        public boolean equals(Object obj){
            return Arrays.equals(memory, ((VisitedMemory)obj).memory);
        }

        @Override
        public int hashCode() {
            int result = 0;
            for (int i = 0; i < memory.length; i++) {
                result += memory[i];
            }
            return result;
        }

    }

    public static boolean isInList(
            final List<int[]> list, final int[] candidate) {

        return list.stream().anyMatch(a -> Arrays.equals(a, candidate));
        //  ^-- or you may want to use .parallelStream() here instead
    }

    private int[] getMemoryAsArray(String fileName) {

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split("\\s+");
                int[] maze = new int[splitLine.length];
                for (int i = 0; i < splitLine.length; i++) {
                    maze[i] = Integer.parseInt(splitLine[i]);
                }
                return maze;
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
