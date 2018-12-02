import java.io.File;

public class MainClass {


    public static void main(String[] args) {
        SpiralMemory memory = new SpiralMemory();

        int input = 265149;
        int test = 1024;

        int ret = memory.calculateTotalNumberOfSteps(test);
        System.out.println("Input: " + test);
        System.out.println("Number of steps = " + ret);

        ret = memory.calculateTotalNumberOfSteps(input);
        System.out.println("Input: " + input);
        System.out.println("Number of steps = " + ret);
    }


}