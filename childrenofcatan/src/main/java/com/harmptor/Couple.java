package com.harmptor;

import java.util.ArrayList;
import java.util.List;

public class Couple {

    private static int numberOfCouples = 0;
    private static int numberOfBreedableCouples = 0;
    private final int coupleID;
    private List<Child> children;
    private boolean breedable;

    public Couple(){
        numberOfCouples += 1;
        numberOfBreedableCouples += 1;
        coupleID = numberOfCouples;
        children = new ArrayList<>();
        breedable = true;
        // System.out.printf("Created new couple: %d \n", coupleID);
    }

    public void breed(){
        if (!breedable) {
            System.out.printf("Couple %3d cannot breed any more (%d girls, %d boys) \n", coupleID, getNumberofGirls(), getNumberofBoys());
            return;
        }
        
        if (coupleID <= numberOfBreedableCouples/2){
            breed("male");
        } else {
            breed("female");
        }

    }
    private void breed(String sex){
        final Child newchild = Child.create(sex);
        children.add(newchild);
        if (sex == "female" && breedable) { // && breedable is redundant but used as a safety precautionn
            breedable = false;
            numberOfBreedableCouples -= 1;
        }
        System.out.printf("Couple %3d had a %4s  (%d girls, %d boys)\n", coupleID, newchild.getGender(), getNumberofGirls(), getNumberofBoys());

    }

    public boolean isSubmissiveAndBreedable(){
        return breedable?true:false;
    }

    public void printChildren(){
        System.out.printf("Couple %3d has: %d girls, %d boys \n", coupleID, getNumberofGirls(), getNumberofBoys());
    }

    public long getNumberofGirls(){
        return children.stream().filter(child -> child instanceof Girl).count();
    }

    public long getNumberofBoys(){
        return children.stream().filter(child -> child instanceof Boy).count();
    }
}
