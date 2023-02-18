package com.harmptor;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {
    private static int currentYear;
    private List<Couple> couples;
    
    public Kingdom(int amountOfCouples){
        currentYear = 0;
        couples = new ArrayList<>();
        for(int i = 0; i < amountOfCouples; i++){
            couples.add(new Couple());
        }
    }

    /**
     * @return true if at least one child was born
     */
    public boolean simulateYear(){
        System.out.printf("\nYear %d: \n", ++currentYear);

        // This stream breeds all couples and collects copies of the newborn children in thisYearsChildren
        List<Child> thisYearsChildren = couples.stream()
            .filter(couple -> couple.isSubmissiveAndBreedable())
            .map(couple -> couple.breed())
            .filter(child -> child != null)
            .toList();
        printResults(thisYearsChildren);
        return thisYearsChildren.size() > 0; // a 'false' breaks the while-loop in App.java
    }

    private void printResults(List<Child> thisYearsChildren){ 
        int breedCount = thisYearsChildren.size();
        long thisYearsGirls = thisYearsChildren.stream().filter(child -> child instanceof Girl).count();
        long thisYearsBoys = thisYearsChildren.stream().filter(child -> child instanceof Boy).count();
        String unequal = (thisYearsBoys!=thisYearsGirls)?"---------- UNEQUAL NUMBER OF GIRLS TO BOYS ----------":"";
        
        if (breedCount > 0) {
            System.out.printf("= %d couples had a total of %2d girls and %2d boys %s \n", breedCount, thisYearsGirls, thisYearsBoys, unequal);
            return;
        }

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
