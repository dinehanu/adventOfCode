package recursive;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecursiveController {

    private static final String template = "The name of the bottom program is: %s";

    @RequestMapping("/towerCalculator")
    public String towerCalculator(@RequestParam(value="filePath", defaultValue="testTower.txt") String filePath) {
        RecursiveTowerCalculator towerCalculator = new RecursiveTowerCalculator();
        String name = towerCalculator.getLowestTower(filePath);
        return String.format(template, name);
    }
}
