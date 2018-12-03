package se.adventOfCode.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventOfCode.util.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Component
public class ChecksumCalculator {

    @Autowired
    FileReader fileReader;

    public long calculateChecksum() { return this.calculateChecksum("input"); }

    public long calculateChecksum(String filepath) {
        int[] numberOfOccurences = getNumberOfOccurences(fileReader.getFileContentAsArray(filepath));
        return numberOfOccurences[2]*numberOfOccurences[3];
    }

    public String findMatchingId() { return this.findMatchingId("input"); }

    public String findMatchingId(String filepath) {
        List<String> lines = fileReader.getFileContentAsArray(filepath);
        for (int firstIndex = 0; firstIndex < lines.size()-1; firstIndex++) {
            for (int secondIndex = firstIndex+1; secondIndex < lines.size(); secondIndex++) {
                if (getNumberOfMismatchingLetters(lines.get(firstIndex), lines.get(secondIndex)) == 1) {
                   return removeMismatchingLetter(lines.get(firstIndex), lines.get(secondIndex));
                }
            }
        }
        return "";
    }

    private String removeMismatchingLetter(String firstWord, String secondWord){
            StringBuilder ret = new StringBuilder(firstWord);
            for(int i = 0; i < firstWord.length(); i++){
                if(firstWord.charAt(i) != secondWord.charAt(i)){
                    ret.deleteCharAt(i);
                }
            }
            return ret.toString();
    }

    private long getNumberOfMismatchingLetters(String firstWord, String secondWord){
        return  IntStream.range(0, firstWord.length())
                .filter(index -> !(firstWord.charAt(index) == secondWord.charAt(index)))
                .count();
    }

    private int[] getNumberOfOccurences(List<String> lines){
        int[] totalNumberOfOccurences = new int[]{0,0,0,0,0};
        for(String line : lines){
            int[] checkSumNumbers = getOccurencesAsArray(getCharacterOccurenceInString(line));
            for (int i = 0; i < 5; i++) {
                totalNumberOfOccurences[i] = totalNumberOfOccurences[i] + checkSumNumbers[i];
            }
        }
        return totalNumberOfOccurences;
    }

    private Map<Character, Integer> getCharacterOccurenceInString(String line){
        Map<Character, Integer> ret = new HashMap<>();
        for (char character: line.toCharArray()) {
            if(ret.containsKey(character)){
                ret.put(character, (ret.get(character)+1));
            } else {
                ret.put(character, 1);
            }
        }
        return ret;
    }

    private int[] getOccurencesAsArray(Map<Character, Integer> characters){
        int[] ret = new int[]{0,0,0,0,0};
        for (char key: characters.keySet()) {
            ret[characters.get(key)] = 1;
        }
        return ret;
    }
}
