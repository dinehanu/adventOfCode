package se.adventOfCode.solver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.adventOfCode.util.FileReader;

import java.util.ArrayList;

@Component
public class RocketEquationCalculator {

    @Autowired
    FileReader fileReader;

    public long calculateRocketFuel(){
        return this.calculateRocketFuel("input");
    }


    public long calculateAdditionalRocketFuel(){
        return this.calculateAdditionalRocketFuel("input");
    }

    public long calculateRocketFuel(String filePath){

        ArrayList<String> fuelAsArray = fileReader.getFileContentAsArray(filePath);
        long totalFuel = 0;

        for (String fuel: fuelAsArray) {
            totalFuel += calculateFuel(Integer.parseInt(fuel));
        }

        return totalFuel;
    }

    public long calculateAdditionalRocketFuel(String filePath){

        ArrayList<String> fuelAsArray = fileReader.getFileContentAsArray(filePath);
        long totalFuel = 0;

        for (String fuel: fuelAsArray) {
            totalFuel += calculateAdditionalFuel(Integer.parseInt(fuel));
        }

        return totalFuel;
    }

    public int calculateFuel(int mass) {
        return ((int)(mass / 3))-2;
    }

    public int calculateAdditionalFuel(int mass) {
        int totalFuel = calculateFuel(mass);
        int additionalFuel = calculateFuel(totalFuel);
        while(additionalFuel > 0){
            totalFuel += additionalFuel;
            additionalFuel = calculateFuel(additionalFuel);
        }
        return totalFuel;
    }

}
