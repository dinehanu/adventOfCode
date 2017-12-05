import java.io.File;

public class MainClass {


    public static void main(String[] args) {
    SpiralMemory memory = new SpiralMemory();

    int input = 265149;
        int test = 1024;

    System.out.println("Input: " + input + "\ncircleIndex: " + memory.calculateNumberOfSteps(input));

        System.out.println("Input: " + test + "\ncircleIndex: " + memory.calculateNumberOfSteps(test));

    }



}