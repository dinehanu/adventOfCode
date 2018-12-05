package se.adventofcode;

import se.adventofcode.solver.Day5Solver;

public class Application {

    public static void main(String[] args){

        Day5Solver solver = new Day5Solver();

//        System.out.println("Kortaste möjliga polymer är: " + solver.calculateRemainingUnits());

        System.out.println("Kortase möjliga förbättrade polymer är: " + solver.calculateImprovedRemainingUnits());

    }
}
