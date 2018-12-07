package se.adventofcode.solver;

import se.adventofcode.util.FileReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day7Solver {

    private final FileReader fileReader;

    public Day7Solver(){
        this.fileReader = new FileReader();
    }

    public String solveFirstTask(){
        List<String> lines = fileReader.getFileContentAsArray("input");
        Map<String, List<String>> steps = getStepsAsMap(lines);
        return getStepsAsString(steps);
    }

    public long solveSecondTask(int numberOfWorkers, int timeForTask){
        List<String> lines = fileReader.getFileContentAsArray("input");
        Map<String, List<String>> steps = getStepsAsMap(lines);
        return calculateTimeForSteps(getWorkers(numberOfWorkers), steps, timeForTask);
    }

    private List<Integer> getWorkers(int numberOfWorkers){
        return IntStream.range(0,4).map(value -> value = 0).boxed().collect(Collectors.toList());
    }

    private int calculateTimeForSteps(List<Integer> workers, Map<String, List<String>> steps, int timeForTask) {
        int timeSpent = 0;
        int nrStepsTaken = 0;

        int mapSize = steps.keySet().size();

        while(mapSize != nrStepsTaken){
            List<String> availableSteps = getAvailableTests(steps);

            for (String step: availableSteps) {
                for (int workerIndex = 0; workerIndex < workers.size(); workerIndex++) {
                    if(workers.get(workerIndex) <= timeSpent){
                        workers.set(workerIndex, timeSpent + getTimeForStep(step, timeForTask));
                        nrStepsTaken++;
//                        if(workerIndex == 0){
//                            timeSpent += getTimeForStep(step, timeForTask);
//                        }
                        break;
                    }
                }
                steps.remove(step);
            }
            timeSpent = workers.get(0);
        }

        return timeSpent;
    }

    private int getTimeForStep(String step, int timeForTask){
        List<String> letterArray = IntStream.rangeClosed('A', 'Z').mapToObj(value -> Character.toString((char)value)).collect(Collectors.toList());
        return letterArray.indexOf(step)+1 + timeForTask;
    }

    private List<String> getAvailableTests(Map<String, List<String>> steps){
        List<String> availableSteps = new ArrayList<>(steps.keySet());
        for (String key: steps.keySet()) {
            for (String key2: steps.keySet()) {
                if(steps.get(key2).contains(key)) {
                    availableSteps.remove(key);
                }
            }
        }
        return availableSteps;
    }

    private String getStepsAsString(Map<String, List<String>> steps){
        String ret = "";
        int mapSize = steps.keySet().size();
        String keyToRemove = "";

        while(mapSize != ret.length()){
            for (String key: steps.keySet()) {
                boolean remove = true;
                for (String key2: steps.keySet()) {
                    if(steps.get(key2).contains(key)){
                        remove = false;
                        break;
                    }
                }
                if(remove){
                    keyToRemove = key;
                    break;
                }
            }
            ret += keyToRemove;
            steps.remove(keyToRemove);
        }

        return ret;
    }

    private Map<String, List<String>> getStepsAsMap(List<String> lines ){
        Map<String, List<String>> steps = new HashMap<String, List<String>>();
        for (String line: lines) {
            List<String> list = new ArrayList<>(Arrays.asList(line.split("\\s*[A-z]{2,}\\s*|\\.*")));
            list.removeAll(Arrays.asList("", null));
            steps = addToMap(steps, list.get(0), list.get(1));
            steps = addToMap(steps, list.get(1), null);
        }
        return steps;
    }

    private Map<String, List<String>> addToMap(Map<String, List<String>> steps, String key, String step){
        List<String> stepList = steps.get(key) != null ? steps.get(key) : new ArrayList<>();
        if(step != null) {
            stepList.add(step);
        }
        steps.put(key, stepList);
        return steps;
    }
}
