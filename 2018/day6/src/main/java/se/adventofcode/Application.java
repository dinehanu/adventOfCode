package se.adventofcode;

import se.adventofcode.solver.Day6Solver;

public class Application {

    public static void main(String[] args){

        Day6Solver solver = new Day6Solver();

        System.out.println("Första svaret är: " + solver.solveFirstTask() );

        System.out.println("Andra svaret är: " + solver.solveSecondTask(10000) );

    }
}
