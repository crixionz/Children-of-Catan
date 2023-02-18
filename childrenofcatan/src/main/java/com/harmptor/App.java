package com.harmptor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Kingdom catan = new Kingdom(1000);
        boolean breedable = true;
        while (breedable) {
            breedable = catan.breed();
        }
    }
}
