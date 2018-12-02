package se.adventOfCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import se.adventOfCode.solver.FrequencyCalculator;

@RestController
public class TestController {

    @Autowired
    FrequencyCalculator calculator;

    @RequestMapping("/")
    public String index() {
        return "The resulting frequency is: " + calculator.calculateFrequency()
                + "</br>"
                + "</br>"
                + "The first duplicate frequency is: " + calculator.calculateFirstDuplicateFrequency();
    }

}
