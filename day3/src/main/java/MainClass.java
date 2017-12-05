import java.io.File;

public class MainClass {


    public static void main(String[] args) {
    SpiralMemory memory = new SpiralMemory();

    //System.out.println("circleIndex with index " + 265149 + ": " + memory.getRowNumber(265149));
        //System.out.println("circleIndex with index " + 1024 + ": " + memory.getRowNumber(1024));

        int[] positions = memory.getPositions(3, 25, 12);
        System.out.println("circleIndex with index " + 1024 + ": ");
        System.out.println("X = " + positions[0]);
        System.out.println("y = " + positions[1]);

    }



}