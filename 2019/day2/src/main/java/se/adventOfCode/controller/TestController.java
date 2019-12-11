package se.adventOfCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import se.adventOfCode.solver.IntCodeCalculator;

@RestController
public class TestController {

    @Autowired
    IntCodeCalculator calculator;

    @RequestMapping("/")
    public String index() {

        int[] second = calculator.calculateSecondState();
        return "The resulting rocket fuel requirement is: " + calculator.calculateFirstState()
                + "</br>"
                + "</br>"
                + "The resulting rocket fuel requirement with additional fuel is: [" + second[0] + ", " + second[1] + "]";
    }

}
