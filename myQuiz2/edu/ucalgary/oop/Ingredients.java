/*
Copyright Ann Barcomb and Emily Marasco, 2023
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package myQuiz2.edu.ucalgary.oop;

import java.util.*;
import java.util.regex.*;

/**
 * Class which describes a list of ingredients
**/
class Ingredients {
    // Store up to 10 ingredients - use one array for names, another for quantity, another 
    // for measurement type (list of available types listed in ingredientMeasurementOptions)
    private String ingredientNames[] = new String[10];
    private int ingredientQuantities[] = new int[10];
    private String ingredientMeasurements[] = new String[10];

    private static final String[] ingredientMeasurementOptions = {"grams", "cups", " ", "liters"};

    /** Getters **/

    /*
     * Getter
     * @return all ingredients
    */
    public String[] getIngredientNames() { return this.ingredientNames; }

    /*
     * Getter
     * @return all ingredient quantities
    */
    public int[] getIngredientQuantities() { return this.ingredientQuantities; }

    /*
     * Getter
     * @return all ingredient measures
    */
    public String[] getIngredientMeasures() { return this.ingredientMeasurements; }

    /*
     * Getter
     * Return ingredient name, ingredient quantity, and ingredient measure at requested index
     * @param index
     * @return String[3]
     * @throws ArrayIndexOutOfBoundsException if index is larger than 9 or less than 0
    */
    public String[] getIngredientByIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (index > 10|| index < 0) {
            throw new ArrayIndexOutOfBoundsException("Only 10 ingredients are permitted");
        }

        String[] anIngredient = { this.ingredientNames[index],
            String.valueOf(this.ingredientQuantities[index]), this.ingredientMeasurements[index] };
        return anIngredient;
    }


    /** Constructor **/

    /*
     * Constructor  
     * Will not actually throw an ArrayIndexOutOfBoundsException since only one ingredient
     * can be specified.
     * @param ingredient - name of ingredient
     * @param quantity - quantity of ingredient
     * @param measurement - ingredient measurement unit
     * @throws IllegalArgumentException if the measurement is not found in ingredientMeasurementOptions
    */
    public Ingredients(String ingredient, int quantity, String measurement)
      throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        addNewIngredient(ingredient, quantity, measurement);
    }

    /** Other methods **/

    /*
     * Check that the measurement is one of the allowed values in ingredientMeasurementOptions
     * @param measurement - ingredient measurement unit
     * @return validated measurement
     * @throws IllegalArgumentException if the measurement is not found in ingredientMeasurementOptions
    */
    public static String validateMeasurement(String measurement) throws IllegalArgumentException {
        for (int i=0; i < ingredientMeasurementOptions.length; i++) {
            if (measurement == ingredientMeasurementOptions[i]) { return measurement; }
        }
        throw new IllegalArgumentException("Measurement must be in measurement options list.");
    }

    /* 
     * Add an ingredient to the list of ingredients
     * @param ingredient - name of ingredient
     * @param quantity - quantity of ingredient
     * @param measurement - ingredient measurement unit
     * @throws ArrayIndexOutOfBoundsException if there are more than 10 ingredients
     * @throws IllegalArgumentException if the measurement is not found in ingredientMeasurementOptions
    */
    public void addNewIngredient(String ingredient, int quantity, String measurement) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        // Find the first empty index spot
        int emptyIndex = -1;
        for (int i = 0; i < ingredientNames.length; i++) {
            // The first non-null value found is the first non-used index
            if (ingredientNames[i] == null) {
                emptyIndex = i;
                break;
            }
        }
    
        // If no empty index was found, throw an exception
        if (emptyIndex == -1) {
            throw new ArrayIndexOutOfBoundsException("Only 10 ingredients are allowed.");
        }
    
        // Ensure that a permitted value was given for measurement
        this.ingredientMeasurements[emptyIndex] = validateMeasurement(measurement);
    
        // Store the other values
        this.ingredientNames[emptyIndex] = ingredient;
        this.ingredientQuantities[emptyIndex] = quantity;
    }
}