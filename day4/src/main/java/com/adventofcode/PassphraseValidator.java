package com.adventofcode;

import com.sun.javafx.image.IntPixelGetter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@Component
public class PassphraseValidator {

    public int getNumberOfValidPassphrases_Harder(String fileName) {
        int ret = 0;
        ArrayList<String[]> passphrases = getPassphraseFile(fileName);
        for (String[] line : passphrases) {
            HashMap<String, Integer> numberOfOccurrences = new HashMap<>();
            for (String passphrase : line) {
                int passphraseOccurrences = numberOfOccurrences.containsKey(passphrase) ? (numberOfOccurrences.get(passphrase) + 1) : 1;
                numberOfOccurrences.put(passphrase, passphraseOccurrences);
            }
            boolean valid = true;
            for (Integer occurrence : numberOfOccurrences.values()) {
                if(occurrence > 1){
                    valid = false;
                }
            }
            if (valid){
                ret++;
            }
        }
        return ret;
    }

    public int getNumberOfValidPassphrases(String fileName) {

        int ret = 0;
        ArrayList<String[]> passphrases = getPassphraseFile(fileName);
        for (String[] line : passphrases) {
            HashMap<String, Integer> numberOfOccurrences = new HashMap<>();
            for (String passphrase : line) {
                int passphraseOccurrences = numberOfOccurrences.containsKey(passphrase) ? (numberOfOccurrences.get(passphrase) + 1) : 1;
                numberOfOccurrences.put(passphrase, passphraseOccurrences);
            }
            boolean valid = true;
            for (Integer occurrence : numberOfOccurrences.values()) {
                if(occurrence > 1){
                    valid = false;
                }
            }
            if (valid){
                ret++;
            }
        }
        return ret;
    }

    private ArrayList<String[]> getPassphraseFile(String fileName) {
        ArrayList<String[]> lines = new ArrayList<String[]>();

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line.split("\\s+"));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
