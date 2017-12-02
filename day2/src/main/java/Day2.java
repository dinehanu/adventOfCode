import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.nio.file.Files;

public class Day2 {

    public int getChecksum(){
        return calcChecksum(getSpreadsheet());
    }

    protected int calcChecksum(ArrayList<String[]> lines){

        int checksum = 0;
        for (String[] line : lines ) {
            int min = -1, max = 0;
            for (String number : line) {
                max = Integer.parseInt(number) > max ? Integer.parseInt(number) : max;
                min = (Integer.parseInt(number) < min || min == -1) ? Integer.parseInt(number) : min;
            }
            checksum += (max - min);
        }
        return checksum;
    }


    private ArrayList<String[]> getSpreadsheet() {
        ArrayList<String[]> lines = new ArrayList<String[]>();

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("spreadsheet.txt").getFile());

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
