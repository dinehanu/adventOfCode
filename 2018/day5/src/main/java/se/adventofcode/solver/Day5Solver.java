package se.adventofcode.solver;

import se.adventofcode.util.FileReader;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day5Solver {

    private FileReader fileReader;

    public Day5Solver(){
        this.fileReader = new FileReader();
    }

    public long calculateRemainingUnits(){
        return calculateRemainingUnits("input");
    }

    public long calculateRemainingUnits(String filename){
        String line = fileReader.getFileContent(filename);
        return removePolymers(line);
    }

    public long calculateImprovedRemainingUnits(){
        return calculateImprovedRemainingUnits("input");
    }

    public long calculateImprovedRemainingUnits(String filename){
        String line = fileReader.getFileContent(filename);
        return getImprovedPolymerLength(line);
    }

    private long getImprovedPolymerLength(String line){
        String uniqueLettersInWord = getAllLettersInStringAsList(line);
        Map<Character, Long> polymerLengths = new HashMap<>();
        for (Character letter: uniqueLettersInWord.toCharArray()) {
            String shortPolymer = removeOccurrenceOf(letter.toString(), line);
            polymerLengths.put(letter, removePolymers(shortPolymer));
        }
        return Collections.min(polymerLengths.values());
    }

    private String getAllLettersInStringAsList(String line){
        return line.toLowerCase().chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
    }

    private String removeOccurrenceOf(String letter, String line){
        String test = letter.toUpperCase() + letter.toLowerCase();
        return line.replaceAll("[" +letter.toUpperCase() + letter.toLowerCase() + "]", "");
    }

    private long removePolymers(String line){

        StringBuilder sb = new StringBuilder(line);

        boolean removed = true;

        while(removed){
            removed = false;
            for (int i = 0; i < sb.length()-2; i++) {
                if(Character.isLowerCase(sb.charAt(i))){
                    if(Character.toLowerCase(sb.charAt(i)) == Character.toLowerCase(sb.charAt(i+1)) && Character.isUpperCase(sb.charAt(i+1))){
                        sb.delete(i, i+2);
                        removed = true;
                        break;
                    }
                } else if(Character.toLowerCase(sb.charAt(i)) == Character.toLowerCase(sb.charAt(i+1)) && Character.isLowerCase(sb.charAt(i+1))){
                        sb.delete(i, i+2);
                        removed = true;
                        break;
                    }
                }
            }
        return sb.toString().length();
    }
}
