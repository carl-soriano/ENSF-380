/*
Copyright Ann Barcomb and Emily Marasco, 2023
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package myQuiz2.edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.regex.*;

public class Quiz2v3Test {
    // Values used for all tests involving Recipe class
    String expectedRecipeName = "Cold cereal";
    String expectedRecipeInstructions = "Pour milk over cereal.";
    String expectedIngredients[] = {"milk", "cereal"};
    int expectedQuantities[] = {1, 2};
    String expectedMeasurementUnits[] = {"cups", "cups"};

    Recipe sharedTestObj = new Recipe(expectedRecipeName, expectedRecipeInstructions,
       expectedIngredients, expectedQuantities, expectedMeasurementUnits);

    @Test
    public void testGetters() {
        String actualRecipeName = sharedTestObj.getName();
        String actualRecipeInstructions = sharedTestObj.getInstructions();

        assertEquals("Constructor or getter gave wrong value for recipe name", 
          expectedRecipeName, actualRecipeName);
        assertEquals("Constructor or getter gave wrong value for recipe instructions", 
          expectedRecipeInstructions, actualRecipeInstructions);
    }

    @Test
    public void testInheritedGetters() {
        String actualIngredients[] = sharedTestObj.getIngredientNames();
        int actualQuantities[] = sharedTestObj.getIngredientQuantities();
        String actualMeasures[] = sharedTestObj.getIngredientMeasures();

        for (int i=0; i < expectedIngredients.length; i++) {
            assertEquals("Constructor or getter had wrong value at index " + i + " for ingredients.",
                expectedIngredients[i], actualIngredients[i]);
            assertEquals("Constructor or getter had wrong value at index " + i + " for quantities.",
                expectedQuantities[i], actualQuantities[i]);
            assertEquals("Constructor or getter had wrong value at index " + i + " for measures.",
                expectedMeasurementUnits[i], actualMeasures[i]);
        }
    }

    @Test
    public void testConstructorWithOneIngredient() {
        String expectedRecipeName = "Boiled egg";
        String expectedRecipeInstructions = "Boil egg until done.";
        String expectedIngredients[] = {"egg"};
        int expectedQuantities[] = {1};
        String expectedMeasurementUnits[] = {" "};

        Recipe testObj = new Recipe(expectedRecipeName, expectedRecipeInstructions,
           expectedIngredients, expectedQuantities, expectedMeasurementUnits);

        String actualRecipeName = testObj.getName();
        String actualRecipeInstructions = testObj.getInstructions();

        assertEquals("Constructor or getter gave wrong value for recipe name",
          expectedRecipeName, actualRecipeName);
        assertEquals("Constructor or getter gave wrong value for recipe instructions",
          expectedRecipeInstructions, actualRecipeInstructions);
    }

    @Test
    public void testGetIngredientByIndex() {
        String actualReturn[] = sharedTestObj.getIngredientByIndex(0); 

        assertEquals("getIngredientByIndex does not return correct ingredient.", 
            expectedIngredients[0], actualReturn[0]);
        assertEquals("getIngredientByIndex does not return correct quantity.", 
            expectedQuantities[0], Integer.parseInt(actualReturn[1]));
        assertEquals("getIngredientByIndex does not return correct measurement unit.", 
            expectedMeasurementUnits[0], actualReturn[2]);
    }

    @Test
    public void testAddingAdditionalIngredientAfterConstruction() {
        // Create an object
        String givenIngredients[] = {"egg"};
        int givenQuantities[] = {1};
        String givenMeasurementUnits[] = {" "};
        Recipe testObj = new Recipe("Boiled egg", "Boil egg until done.",
            givenIngredients, givenQuantities, givenMeasurementUnits);
           
        // Add the additional ingredient
        String expectedReturn[] = {"salt", "1", "grams"};
        testObj.addNewIngredient(expectedReturn[0], Integer.parseInt(expectedReturn[1]),
            expectedReturn[2]);

        String actualReturn[] = testObj.getIngredientByIndex(1); 

        assertEquals("New ingredient not added correctly.", expectedReturn[0], actualReturn[0]);
        assertEquals("New quantity not added correctly.", expectedReturn[1], actualReturn[1]);
        assertEquals("New measurement not added correctly.", expectedReturn[2], actualReturn[2]);
        
    }

    @Test
    public void testRecipeInheritsFromIngredients() {
        assertTrue("Recipe does not inherit from Ingredients", 
          (sharedTestObj instanceof Ingredients));
    }

    @Test
    public void testRecipeImplementsDisplayRecipe() {
        assertTrue("Recipe does not implement DisplayRecipe",
          (DisplayRecipe.class.isAssignableFrom(sharedTestObj.getClass())));
    }

    @Test
    public void testValidateMeasurement() {
        String expectedMeasurement = "cups";

        String actualMeasurement = Ingredients.validateMeasurement(expectedMeasurement);

        assertEquals("Valid ingredient measurement option was not validated.",
           expectedMeasurement, actualMeasurement);
    }

    @Test 
    public void testAddingTooManyIngredients() {
        boolean testResult = false;

        String[] ingredients = {"one", "two", "three", "four", "five", "six", "seven", 
           "eight", "nine", "ten", "eleven"};
        int[] quantities = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        String[] measures = {"grams", "cups", " ", "liters", "grams", "cups", " ", " ", " ", " ", " "};
 
        try {
            Ingredients testObj = new Ingredients(ingredients[0], quantities[0], measures[0]);
            for (int i=1; i < ingredients.length; i++) {
                testObj.addNewIngredient(ingredients[i], quantities[i], measures[i]);
            }
        }

        catch (ArrayIndexOutOfBoundsException e) {
            testResult = true;
        }
        catch (Exception e) { }
        assertTrue("It was possible to specify more than 10 ingredients (ArrayIndexOutOfBoundsException was not thrown).",
            testResult);
    }

    @Test
    public void testValidateMeasurementllegalArgumentException() {
        boolean testResult = false;

        try {
            Ingredients testObj = new Ingredients("flour", 100, "gram");
        }
        catch (IllegalArgumentException e) {
            testResult = true;
        }
        catch (Exception e) { }
        assertTrue("validateMeasurement did not throw an IllegalArgumentException with invalid measurement option.", 
            testResult);
    }

    @Test
    public void testValidateMeasurementExceptionMessage() {
        String expectedError = "Measurement must be in measurement options list.";
        String actualError = "";

        try {
            Ingredients testObj = new Ingredients("milk", 100, "ml");
        }
        catch (Exception e) {
            actualError = e.getMessage();
        }
        assertEquals("validateMeasurement did not provide correct exception message given an invalid level",
          expectedError, actualError);
    }

    @Test
    public void testGetIngredientsByIndexException() {
        boolean testResult = false;
 
        // Lower bound for index is 0
        try {
            String actualReturn[] = sharedTestObj.getIngredientByIndex(-3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            testResult = true;
        }
        catch (Exception e) {}
        assertTrue("getIngredientsByIndex did not throw an ArrayIndexOutOfBoundsException given an index below zero.", testResult);

        // Upper bound for index is 9
        testResult = false;
        try {
            String actualReturn[] = sharedTestObj.getIngredientByIndex(10);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            testResult = true;
        }
        catch (Exception e) {}
        assertTrue("getIngredientsByIndex did not throw an ArrayIndexOutOfBoundsException given an index greater than nine.", testResult);
    }

    @Test
    public void testAllArraysEqualLengthException() {
        boolean testResult = false;

        // Ingredients, quantities and measurements must be of equal length 
        try {
            String givenIngredients[] = {"milk", "cereal"};
            int givenQuantities[] = {1};
            String givenMeasurementUnits[] = {"cups", "cups"};

            Recipe testObj = new Recipe("recipe name", "recipe instructions",
               givenIngredients, givenQuantities, givenMeasurementUnits);
        }

        catch (IllegalArgumentException e) {
            testResult = true;
        }
        catch (Exception e) { }
        assertTrue("Recipe constructor did not throw IllegalArgumentException when provided with ingredients, quantities, and measurementUnits of different lengths.", testResult);
    }

    @Test
    public void testFormatOrderExactFormatting() {
        String expectedOutput = "Cold cereal, Pour milk over cereal.";
        String actualOutput = sharedTestObj.formatOrder();

        assertEquals("formatOrder() did not return a correctly formatted String.",
            expectedOutput, actualOutput);
    }

    @Test
    public void testFormatOrderContentOnly() {
        String expectedOutput = "ColdcerealPourmilkovercereal";

        String actualOutput = sharedTestObj.formatOrder();
        actualOutput = actualOutput.replaceAll("[^\\w_]", "");

        assertEquals("formatOrder() did not return the expected content.",
            expectedOutput, actualOutput);
    }






}

