package maze;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {


            MazeSolver ms = ctx.getBean(MazeSolver.class);
            System.out.println("The maze takes " + ms.getNumberOfStepsToSolveMaze("maze.txt") + " to solve.");
            System.out.println("Part 2 of the maze takes " + ms.getNumberOfStepsToSolveMaze_PartTwo("maze.txt") + " to solve.");


        };
    }

}