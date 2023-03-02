/*
Copyright Ann Barcomb and Emily Marasco, 2023
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package myQuiz2.edu.ucalgary.oop;

public interface DisplayRecipe {
    /* 
     * Provides the format:  name, instructions
     * Example:              Cold cereal, Pour milk over cereal.
     * @param name - recipe name
     * @param instructions - recipe instructions
     * @return formatted String
    */
    static String formatOrder(String name, String instructions) { 
        return String.format("%s, %s", name, instructions);
    }
}
