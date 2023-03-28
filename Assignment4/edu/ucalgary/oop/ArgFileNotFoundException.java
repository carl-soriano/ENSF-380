package edu.ucalgary.oop;

public class ArgFileNotFoundException extends Exception{
    public ArgFileNotFoundException(){
        System.out.println("Argument file not found.");
        System.exit(1);
    }
}
