package se.adventofcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.adventofcode.solver.OverlapCalculator;

@RestController
public class TestController {

    @Autowired
    OverlapCalculator calculator;

    @RequestMapping("/")
    public String index() {
        return "The number of overlapping square inches are: " + calculator.calculateOverlap()
                + "</br>"
                + "</br>"
                + "The id of the non overlapping piece of fabric is: " + calculator.calculateNonOverlapingId()
                + "</br>"
                + "</br>"
                + "Showing 100x100 of the matrix"
                + "</br>"
                + getTable();
    }

    private String getTable(){

        String[][]matrix = calculator.getMatrix("input");
        String ret = "<table style=\"width:100%\">";

        for (int i = 0; i<100; i++){
            ret += "<tr>";
            for (int j = 0; j<100; j++){
                ret += "<td>" + matrix[i][j] + "</td>";
            }
            ret += "</tr>";
        }
        return ret + "</table>";
    }

}
