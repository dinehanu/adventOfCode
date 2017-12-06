package maze;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MazeSolverTest {


    @Autowired
    MazeSolver ms;

    @Test
    public void getNumberOfStepsToSolveMaze() {

        Assert.assertEquals("getNumberOfStepsToSolveMaze", 5, ms.getNumberOfStepsToSolveMaze("mazeTest.txt"));
    }
}