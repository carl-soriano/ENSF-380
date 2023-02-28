/*
Copyright Ann Barcomb and Emily Marasco, 2023
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package edu.ucalgary.oop;

import java.util.*;
import java.util.regex.*;

/**
 * Class which describes a generic course offered by the recreation centre
**/
class RecreationCourse {
    protected final int COURSE_CODE;
    protected final String COURSE_NAME;
    protected final char DIFFICULTY_LEVEL;
    private Character[] difficultyLevels = {'B', 'A', 'H'};

    /** Getters **/

    /*
     * Getter
     * @return course code
    */
    public int getCourseCode() { return this.COURSE_CODE; }

    /*
     * Getter
     * @return course name
    */
    public String getCourseName() { return this.COURSE_NAME; }

    /*
     * Getter
     * @return course level
    */
    public char getDifficultyLevel() { return this.DIFFICULTY_LEVEL; }

    /** Constructor **/

    /*
     * Constructor
     * @param code - numeric course code
     * @param name - name of course
     * @param level - course difficulty level: one of B, I, or A
    */
    public RecreationCourse(int code, String name, char level) throws IllegalArgumentException {
        this.COURSE_CODE = code;
        this.COURSE_NAME = name;
        this.DIFFICULTY_LEVEL = validateLevel(normalizeLevel(level));
    }

    /** Other methods **/

    /*
     * Check that the course level is one of the allowed characters (B, I, or A)
     * @return validated course level
    */
    public char validateLevel(char level) throws IllegalArgumentException {
        for (int i=0; i < this.difficultyLevels.length; i++) {
            if (level == this.difficultyLevels[i]) {
                return level; // level is valid, return it
            }
        }
        // level is not valid, throw an exception
        throw new IllegalArgumentException("Course level must be a single character: B (beginner), I (intermediate), or H (hard)");
    }

    /*
     * Normalize the course level by converting to uppercase
     * @return normalized course level
    */
    public char normalizeLevel(char level) {
        return Character.toUpperCase(level);
    }
}

