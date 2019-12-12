package se.adventOfCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import se.adventOfCode.solver.CrossedWireSolver;

@RestController
public class TestController {

    @Autowired
    CrossedWireSolver calculator;

    @RequestMapping("/")
    public String index() {

        return "The closest crossing is at the distance: " + calculator.solveCrossedWires()
                + "</br>"
                + "</br>"
                + "The resulting rocket fuel requirement with additional fuel is: " + calculator.solveCrossedWires();
    }

}
