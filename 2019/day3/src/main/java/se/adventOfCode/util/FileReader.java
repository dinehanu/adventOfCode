package se.adventOfCode.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class FileReader {

    public List<int[]> getFileContentAsArray(String fileName) {

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            List<int[]> wiresAsArray = new ArrayList<>();
            while (scanner.hasNextLine()) {
                wiresAsArray.add(Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray());
            }
            return wiresAsArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
