/*
Copyright Ann Barcomb and Emily Marasco, 2023
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package edu.ucalgary.oop;

interface CourseRegistration {
    /* 
     * Provides the format:  code: name (level) - participant
     * Example:              503: Skate skiing (I) - Julius Gonzalez
     * @param code - course code
     * @param name - course name
     * @param level - difficulty level
     * @param participant - student registered for the course
     * @return formatted String
    */
    static String formatOrder(String code, String name, String participant, String level) { 
        return String.format("%s: %s (%s) %s", name, code, participant, level);
    }
}
