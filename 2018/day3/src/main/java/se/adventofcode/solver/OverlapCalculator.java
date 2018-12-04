package se.adventofcode.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventofcode.util.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class OverlapCalculator {

    @Autowired
    FileReader fileReader;

    public long calculateOverlap() { return this.calculateOverlap("input"); }

    public long calculateOverlap(String filepath) {
        String[][] calculatedMatrix = getMatrix(filepath);
        return numberOfX(calculatedMatrix);
    }

    private int numberOfX(String[][] matrix){
        int ret = 0;
        for (int x = 0; x<matrix.length; x++){
            for (int y = 0; y<matrix[x].length; y++){
                if(matrix[x][y].equals("X")){
                    ret++;
                }
            }
        }
        return ret;
    }

    public String[][] getMatrix(String filepath){
        List<String> lines = fileReader.getFileContentAsArray(filepath);
        String[][] matrix = getEmptyArray();
            for (int lineIndex = 0; lineIndex<lines.size(); lineIndex++){
            int[] coordinates = getCoordinates(lines.get(lineIndex));
            int[] size = getSize(lines.get(lineIndex));
            if(coordinates.length == 2 && size.length == 2){
                for (int x = coordinates[0]; x < coordinates[0]+size[0]; x++){
                    for (int y= coordinates[1]; y < coordinates[1]+size[1]; y++){
                        if(matrix[y][x].equals("0")){
                            matrix[y][x] = "" + (lineIndex+1);
                        } else {
                            matrix[y][x] = "X";
                        }
                    }
                }
            }
        }
        return matrix;
    }

    private int[] getCoordinates(String line){
        return getSubstringAndSplitWith(line, ",");
    }

    private int[] getSize(String line){
        return getSubstringAndSplitWith(line, "x");
    }

    private int[] getSubstringAndSplitWith(String line, String splitter){
        Pattern pat = Pattern.compile("(\\d*"+ splitter +"\\d*)");
        Matcher mat = pat.matcher(line);
        if(mat.find()){
            String[] split = mat.group(1).split(splitter);
            return Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        }
        return null;
    }

    private String[][] getEmptyArray(){
        String[][] ret = new String[1000][1000];
        for (int i = 0; i<1000; i++){
            for (int j = 0; j<1000; j++){
                ret[i][j]="0";
            }
        }
        return ret;
    }
}
