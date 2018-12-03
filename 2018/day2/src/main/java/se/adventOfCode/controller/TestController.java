package se.adventOfCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.adventOfCode.solver.ChecksumCalculator;

@RestController
public class TestController {

    @Autowired
    ChecksumCalculator calculator;

    @RequestMapping("/")
    public String index() {
        return "The calculated checksum is: " + calculator.calculateChecksum()
                + "</br>"
                + "</br>";
                //+ "The first duplicate frequency is: " + calculator.calculateFirstDuplicateFrequency();
    }

}
