package se.adventOfCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /*
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
            FrequencyCalculator calculator = context.getBean(FrequencyCalculator.class);
            System.out.println("The resulting frequency is:");
            System.out.println(calculator.calculateFrequency());

            System.out.println("The first duplicate frequency is:");
            System.out.println(calculator.calculateFirstDuplicateFrequency());

        };
    }
    */
}
