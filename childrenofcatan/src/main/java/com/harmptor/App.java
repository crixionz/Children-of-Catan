package com.harmptor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "\nOye cunt! Look at dese numbnuts fuckin their brains out for science" );

        Kingdom catan = new Kingdom(100);
        boolean breedable = true;
        while (breedable) {
            breedable = catan.breed();
        }
    }
}
