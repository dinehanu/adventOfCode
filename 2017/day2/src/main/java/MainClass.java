import java.io.File;

public class MainClass {


    public static void main(String[] args) {
        //Get file from resources folder

        Day2 checksumGenerator = new Day2();
        System.out.println("CheckSum: " + checksumGenerator.getChecksum());
        System.out.println("Even checkSum: " + checksumGenerator.getEvenChecksum());

    }



}
