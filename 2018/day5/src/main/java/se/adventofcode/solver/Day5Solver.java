package se.adventofcode.solver;

import se.adventofcode.util.FileReader;

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
