package com.harmptor;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {
    public List<Couple> couples;
    public static int currentYear;
    
    public Kingdom(int amountOfCouples){
        couples = new ArrayList<>();
        currentYear = 0;
        for(int i = 0; i < amountOfCouples; i++){
            couples.add(new Couple());
        }
    }

    public boolean breed(){
        currentYear += 1;
        System.out.printf("Year %d: \n", currentYear);

        // This stream breeds and saves how the amount of executions in breedCount
        long breedCount = couples.stream()
            .filter(couple -> couple.isSubmissiveAndBreedable())
            .map(couple -> {
                couple.breed();
                return couple;
            })
            .count();

        // Prints breed results
        printBreedResults(breedCount);
        return breedCount>0;
    }

    private void printBreedResults(long breedCount){        
        if (breedCount > 0) {
            System.out.printf("Times bred: %d\n\n", breedCount);
        } else {
            System.out.printf("Pussyo, we done ye? Aigh chief lookat dat brudda:\n");
            int totalGirls = couples.stream()
                .mapToInt(couple -> (int) couple.getNumberofGirls())
                .sum();
            int totalBoys = couples.stream()
                .mapToInt(couple -> (int) couple.getNumberofBoys())
                .sum();
            System.out.printf("Total girls: %d \nTotal boys: %d\n\n", totalGirls, totalBoys);
        }
    }
}
