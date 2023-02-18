package com.harmptor;

import java.util.ArrayList;
import java.util.List;

public class Couple {

    protected static boolean verbose = true;
    private static int numberOfCouples = 0;
    private static int numberOfBreedableCouples = 0;
    private final int coupleID;
    private List<Child> children;
    private boolean breedable;

    Couple(){
        numberOfCouples++;
        numberOfBreedableCouples++;
        coupleID = numberOfCouples;
        children = new ArrayList<>();
        breedable = true;
        // System.out.printf("Created new couple: %d \n", coupleID);
    }

    /**
     * requires couple.breedable == true;
     * @return The newborn child of this couple
     */
    public Child breed(){
        if (!breedable) {
            System.out.printf("ERROR: Couple %3d cannot breed any more (%d girls, %d boys) \n", coupleID, getNumberofGirls(), getNumberofBoys());
            return null;
        }
        Child newchild;
        if (coupleID <= numberOfBreedableCouples/2){ // pesudo random. the idea here is that the first half of all eligible couples will have a boy, the second half will have a girl.
            newchild = makeNewChild("male");
        } else {
            newchild = makeNewChild("female");
        }
        return newchild;
    }

    private Child makeNewChild(String sex){
        final Child newchild = Child.create(sex);
        children.add(newchild);
        if (sex == "female" && breedable) { // && breedable is redundant but used as a safety precautionn
            breedable = false;
            numberOfBreedableCouples--;
        }
        if (verbose) {
            System.out.printf("Couple %3d had a %4s : (%d girls, %d boys)\n", coupleID, newchild.getGender(), getNumberofGirls(), getNumberofBoys());
        }
        return newchild;
    }

    public boolean isSubmissiveAndBreedable(){
        return breedable?true:false;
    }

    public long getNumberofGirls(){
        return children.stream().filter(child -> child instanceof Girl).count();
    }

    public long getNumberofBoys(){
        return children.stream().filter(child -> child instanceof Boy).count();
    }
}
