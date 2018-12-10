package se.adventofcode;

import se.adventofcode.solver.Day10Solver;

public class Application {

    public static void main(String[] args) {

        Day10Solver solver = new Day10Solver();

        solver.solveFirstTask();

        System.out.println("Lösningen på uppgift 2 är: " + solver.solveSecondTask());
    }
}
