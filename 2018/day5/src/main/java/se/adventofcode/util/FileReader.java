package se.adventofcode.util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

    public String getFileContent(String fileName) {

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                return scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
