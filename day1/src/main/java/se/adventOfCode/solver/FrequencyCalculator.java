package se.adventOfCode.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventOfCode.util.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class FrequencyCalculator {

    @Autowired
    FileReader fileReader;

    public long calculateFrequency(){
        return this.calculateFrequency("input");
    }

    public long calculateFrequency(String filePath){

        ArrayList<String> changesToFrequency = fileReader.getFileContentAsArray(filePath);
        long frequency = 0;

        for (String freqChange: changesToFrequency) {
            String operator = freqChange.substring(0,1);
            String number = freqChange.substring(1);
            frequency = operator.equals("+") ? frequency + Long.parseLong(number) : frequency - Long.parseLong(number);
        }

        return frequency;
    }

    public long calculateFirstDuplicateFrequency(){
        return this.calculateFirstDuplicateFrequency("input");
    }

    public long calculateFirstDuplicateFrequency(String filePath){

        Map<Long, Long> calculatedFrequencies = new HashMap<>();
        ArrayList<String> changesToFrequency = fileReader.getFileContentAsArray(filePath);
        long frequency = 0;
        calculatedFrequencies.put(frequency, frequency);
        boolean foundDuplicate = false;

        while(!foundDuplicate){
            for (String freqChange: changesToFrequency) {
                String operator = freqChange.substring(0,1);
                String number = freqChange.substring(1);
                frequency = operator.equals("+") ? frequency + Long.parseLong(number) : frequency - Long.parseLong(number);
                if(calculatedFrequencies.containsKey(frequency)){
                    foundDuplicate = true;
                    break;
                } else {
                    calculatedFrequencies.put(frequency, frequency);
                }
            }
        }
        return frequency;
    }
}
