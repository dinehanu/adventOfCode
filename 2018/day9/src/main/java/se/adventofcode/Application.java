package se.adventofcode;

import se.adventofcode.solver.Day9Solver;

public class Application {

    public static void main(String[] args){

        Day9Solver solver = new Day9Solver();

        System.out.println("Första svaret är: " + solver.solveFirstTask(452, 71250) );

        System.out.println("Andra svaret är: " + solver.solveFirstTask(452, 71250*100) );

    }
}
