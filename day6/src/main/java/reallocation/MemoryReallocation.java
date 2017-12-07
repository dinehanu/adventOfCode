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

    public int getNumberOfStepsToReallocate(String filePath){

        int ret = 0;
        int[] memory = getMemoryAsArray(filePath);
        List<int[]> visitedAllocations = new ArrayList<>();

        while(!isInList(visitedAllocations, memory)){
            int largestNumber = 0;
            int index = 0;
            visitedAllocations.add(memory.clone());

            for (int i = 0; i < memory.length; i++) {
                if(memory[i] > largestNumber){
                    largestNumber = memory[i];
                    index = i;
                }
            }
            memory[index] = 0;
            int nextIndex = (index+1) == memory.length ? 0 : (index+1);
            for (int j = 0; j < largestNumber; j++) {
                if(nextIndex == memory.length){
                    nextIndex = 0;
                }
                memory[nextIndex] = memory[nextIndex]+1;
                nextIndex++;
            }
            ret++;
        }
        return ret;
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
