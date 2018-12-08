package se.adventofcode.solver;

import se.adventofcode.util.FileReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

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

    private class Worker{
        private int time = 0;
        private String currentTask = null;

        public int getTime(){
            return time;
        }
    }

    private List<Worker> getWorkers(int numberOfWorkers){
        return IntStream.range(0,numberOfWorkers).mapToObj(value -> new Worker()).collect(Collectors.toList());
    }

    private int calculateTimeForSteps(List<Worker> workers, Map<String, List<String>> steps, int timeForTask) {
        int nrStepsTaken = 0;
        Map<String, List<String>> originalSteps = new HashMap<String, List<String>>(steps);
        int mapSize = steps.keySet().size();

        for (int seconds = 0; seconds <1500 ; seconds++) {
            final int currentTimeSpent = seconds;

            for (int workerIndex = 0; workerIndex < workers.size(); workerIndex++) {
                List<String> tasksBeingWorkedOn = workers.stream().filter(worker -> worker.time > currentTimeSpent).map(worker -> worker.currentTask).collect(Collectors.toList());
                List<String> lockedTasks = new ArrayList<>();
                for (String task: tasksBeingWorkedOn) {
                    lockedTasks.addAll(originalSteps.get(task));
                }
                List<String> availableSteps = getAvailableTests(steps, lockedTasks);

                for (String step: availableSteps) {
                    Worker worker = workers.get(workerIndex);
                    if(worker.time <= seconds){
                        worker.time = seconds + getTimeForStep(step, timeForTask);
                        worker.currentTask = step;
                        workers.set(workerIndex, worker);
                        nrStepsTaken++;
                        steps.remove(step);
                        break;
                    }
                }
            }
            if(nrStepsTaken == mapSize){
                return workers.stream().max(comparing(Worker::getTime)).get().getTime();
            }
        }
        return 0;
    }

    private int getTimeForStep(String step, int timeForTask){
        List<String> letterArray = IntStream.rangeClosed('A', 'Z').mapToObj(value -> Character.toString((char)value)).collect(Collectors.toList());
        return letterArray.indexOf(step)+1 + timeForTask;
    }

    private List<String> getAvailableTests(Map<String, List<String>> steps, List<String> tasksBeingWorkedOn){
        List<String> availableSteps = new ArrayList<>(steps.keySet());
        for (String key: steps.keySet()) {
            for (String key2: steps.keySet()) {
                if(steps.get(key2).contains(key) || tasksBeingWorkedOn.contains(key)) {
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
