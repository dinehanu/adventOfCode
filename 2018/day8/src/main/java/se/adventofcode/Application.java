package se.adventofcode;

import se.adventofcode.solver.Day8Solver;

public class Application {

    public static void main(String[] args) {

        Day8Solver solver = new Day8Solver();

        System.out.println("Lösningen på uppgift 1 är: " + solver.solveFirstTask());

        System.out.println("Lösningen på uppgift 2 är: " + solver.solveSecondTask());
    }
}
