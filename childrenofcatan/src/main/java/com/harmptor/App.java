package com.harmptor;

import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Locale.setDefault(Locale.ROOT);
        System.out.println( "\nOye cunt! Look at dese numbnuts fuckin their brains out for science" );

        Kingdom catan = new Kingdom(8192);
        Couple.verbose = false; // verbose makes every couple print their shitty ass gender reveal as if we cared
        while (catan.simulateYear());
    }
}
