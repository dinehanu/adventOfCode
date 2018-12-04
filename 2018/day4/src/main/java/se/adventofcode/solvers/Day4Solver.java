package se.adventofcode.solvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventofcode.util.FileReader;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Day4Solver {

    @Autowired
    FileReader fileReader;

    public long runStrategyOne(){
        return runStrategyOne("input");
    }

    public long runStrategyOne(String filename){
        List<String> lines = fileReader.getFileContentAsArray(filename);
        List<String> sortedList = sortListByDateAndTime(lines);
        List<String> guardIds = getGuardIds(lines);

        String longestId = "";
        long longestTimeAsleep = 0;
        for (String id : guardIds) {
            List<String> linesForId = getLinesForId(id, lines);
            long totalTimeAsleep = getTotalTimeAsleep(linesForId);
            if(totalTimeAsleep > longestTimeAsleep){
                longestId = id;
                longestTimeAsleep = totalTimeAsleep;
            }
        }
        return Integer.parseInt(longestId) * getMinuteMostOftenAsleep(longestId, lines);
    }

    private Integer getMinuteMostOftenAsleep(String id, List<String> lines){
        List<Integer> timesAsleep = new ArrayList<Integer>(Collections.nCopies(60, 0));
        List<String> linesForId = getLinesForId(id, lines);

        for (int i = 0; i<linesForId.size()-1; i+=2) {
            LocalDateTime fallAsleepTime = getLocalDateTimeFromLine(linesForId.get(i));
            LocalDateTime awakeTime = getLocalDateTimeFromLine(linesForId.get(i+1));
            long duration = Duration.between(fallAsleepTime, awakeTime).toMinutes();
            for (int j = 0; j < duration; j++) {
                int minute = fallAsleepTime.getMinute() + j;
                timesAsleep.set(minute, timesAsleep.get(minute)+1);
            }
        }
        return timesAsleep.indexOf(Collections.max(timesAsleep));
    }

    private long getTotalTimeAsleep(List<String> linesForId){
        long totalTimeAsleep = 0;

        for (int i = 0; i<linesForId.size()-1; i+=2) {
            LocalDateTime fallAsleepTime = getLocalDateTimeFromLine(linesForId.get(i));
            LocalDateTime awakeTime = getLocalDateTimeFromLine(linesForId.get(i+1));
            totalTimeAsleep += Duration.between(fallAsleepTime, awakeTime).toMinutes();
        }
        return totalTimeAsleep;
    }

    private LocalDateTime getLocalDateTimeFromLine(String line){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(getDateFromLine(line), formatter);
    }

    private List<String> getLinesForId(String id, List<String> lines){
        List<String> ret = new ArrayList<>();
        boolean save = false;
        for (String line : lines) {
            if(line.contains("#")){
                save = line.contains("#" + id);
                continue;
            } else if(save){
                ret.add(line);
            }
        }
        return ret;
    }

    private List<String> sortListByDateAndTime(List<String> dateList){
        Collections.sort(dateList, (s1, s2) -> getLocalDateTimeFromLine(s1).
                compareTo(getLocalDateTimeFromLine(s2)));
        return dateList;
    }

    private String getDateFromLine(String line){
        return line.substring(line.indexOf("[")+1, line.indexOf("]"));
    }

    private List<String> getGuardIds(List<String> lines) {
        List<String> ids = new ArrayList<>();
        for (String line: lines) {
            if(line.contains("#") && !ids.contains(getGuardIdFromLine(line))){
                ids.add(getGuardIdFromLine(line));
            }
        }
        return ids;
    }

    private String getGuardIdFromLine(String line){
        return line.substring(line.indexOf("#")+1, line.indexOf("b")-1);
    }
}
