package com.harmptor;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {
    private List<Couple> couples;
    private static int currentYear;
    
    public Kingdom(int amountOfCouples){
        currentYear = 0;
        couples = new ArrayList<>();
        for(int i = 0; i < amountOfCouples; i++){
            couples.add(new Couple());
        }
    }

    public boolean simulateYear(){
        System.out.printf("\nYear %d: \n", ++currentYear);

        // This stream breeds and saves the amount of executions in breedCount
        long breedCount = couples.stream()
            .filter(couple -> couple.isSubmissiveAndBreedable())
            .map(couple -> {couple.breed(); return couple;}) // executes .breed() on each couple but keeps stream alive by returning the couple
            .count();

        if (breedCount == 0) printResults(); // Prints results if there wasn't any progress, aka after the last execution
        return breedCount > 0; // if true, keeps the while-loop in App.j running
    }

    private void printResults(){        
        System.out.printf("Pussyo, we done ye? Aigh chief lookat dat brudda:\n");
        int totalGirls = couples.stream()
            .mapToInt(couple -> (int) couple.getNumberofGirls())
            .sum();
        int totalBoys = couples.stream()
            .mapToInt(couple -> (int) couple.getNumberofBoys())
            .sum();
        System.out.printf("Total girls: %d \nTotal boys: %d\nRatio girls to boys: %f\n\n", totalGirls, totalBoys, (float)totalGirls/totalBoys);
    }

}
