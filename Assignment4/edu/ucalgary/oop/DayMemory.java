package edu.ucalgary.oop;

public class DayMemory{
    public static void main (String[] args) throws CommandArgumentNotProvidedException, ArgFileNotFoundException{
        if(args.length == 0)
            throw new CommandArgumentNotProvidedException();
        
        Translator translator = new Translator(args[0]);
        System.out.println(translator.translate(3, 8, 2021));
    }
}
