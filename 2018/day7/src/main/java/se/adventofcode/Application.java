package se.adventofcode;

import se.adventofcode.solver.Day7Solver;

public class Application {

    public static void main(String[] args){

        Day7Solver solver = new Day7Solver();
        System.out.println("The solution to the first task is: " + solver.solveFirstTask());
        System.out.println("The solution to the second task is: " + solver.solveSecondTask(5, 60));
    }
}
