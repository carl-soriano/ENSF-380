package edu.ucalgary.oop;

public class CommandArgumentNotProvidedException extends Exception{
    public CommandArgumentNotProvidedException(){
        super("Not a valid argument.");
    }
}
