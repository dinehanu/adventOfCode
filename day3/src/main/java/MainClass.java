import java.io.File;

public class MainClass {


    public static void main(String[] args) {
    SpiralMemory memory = new SpiralMemory();

    int input = 265149;
    int test = 1024;

    //System.out.println("Input: " + input + "\ncircleIndex: " + memory.calculateNumberOfSteps(input));
    //System.out.println("Input: " + test + "\ncircleIndex: " + memory.calculateNumberOfSteps(test));

        int[] positions = memory.getPositions(3, 25, 12);
        System.out.println("circleIndex with index " + 1024 + ": ");
        System.out.println("X = " + positions[0]);
        System.out.println("y = " + positions[1]);

    }



}