package se.adventOfCode.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class FileReader {

    public int[] getFileContentAsArray(String fileName) {

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                return Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
