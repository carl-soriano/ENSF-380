/*
Copyright Ann Barcomb and Emily Marasco, 2023
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/


package myQuiz2.edu.ucalgary.oop;

import java.util.*;
import java.util.regex.*;

/**
 * Class which describes a simple recipe
**/
public class Recipe extends Ingredients implements DisplayRecipe {
    private String instructions;
    private String name;

    /** Setters **/

    /*
     * Standard setter
     * @param instructions - the recipe instructions
    */
    public void setInstructions(String instructions) { this.instructions = instructions; }

    /*
     * Standard setter
     * @param name - the name of the recipe
    */
    public void setName(String name) { this.name = name; }

    /** Getters **/

    /*
     * Standard getter
     * @return the recipe name
    */
    public String getName() { return this.name; }

    /*
     * Standard getter
     * @return the recipe instructions
    */
    public String getInstructions() { return this.instructions; }

    /** Constructors **/

    /*
     * Constructor
     * @param name - Recipe name
     * @param instructions - Recipe instructions
     * @param ingredients - String array of recipe ingredients
     * @param quantities - int array of quantities of recipe ingredients
     * @param measurementUnits - String array of units of quantities of recipe ingredients
     * @throws IllegalArgumentException if the measurement units are not allowed types or length of ingredients, quantities and measurementUnits are different
     * @throws ArrayIndexOutOfBoundsException if there are more than 10 ingredients
     */
    public Recipe(String name, String instructions, String[] ingredients, int[] quantities, String[] measurementUnits) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {

        // Store the first ingredient - call to super must be first statement in constructor
        super(ingredients[0], quantities[0], measurementUnits[0]);

        // Ensure all arrays are the same length
        if (ingredients.length != quantities.length || 
            quantities.length != measurementUnits.length || 
            measurementUnits.length != quantities.length) {
            throw new IllegalArgumentException("There must be the same number of ingredients, quantities and measurement units.");
        }

        // Store recipe name and instructions
        this.name = name;
        this.instructions = instructions;

    

        // Store remaining ingredients
        for (int i=0; i < ingredients.length; i++) {
            this.addNewIngredient(ingredients[i], quantities[i], measurementUnits[i]);
        }
    }
 
    public String formatOrder() {
        return DisplayRecipe.formatOrder(this.name, this.instructions);
    }


}

