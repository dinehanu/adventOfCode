package se.adventofcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.adventofcode.solvers.Day4Solver;

@Controller
public class RestController {

    @Autowired
    Day4Solver solver;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="input") String name, Model model) {
        model.addAttribute("strategyOne", solver.runStrategyOne(name));
        model.addAttribute("strategyTwo", solver.runStrategyTwo(name));
        return "result";
    }

}