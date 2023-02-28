/*
Copyright Ann Barcomb and Emily Marasco, 2023
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package edu.ucalgary.oop;

import java.util.*;
import java.util.regex.*;

/**
 * Class which describes a skate skiing class
**/
public class SkateSki extends RecreationCourse implements CourseRegistration {
    private static final int MAX_CLASS_SIZE = 10;
    private String participantName;
    private long participantPhone;

    /** Setters **/

    /*
     * Standard setter
     * @param participantName - student name
    */
    public void setParticipantName(String participantName) { this.participantName = participantName; }

    /*
     * Standard setter
     * @param participantPhone - student's phone number (numeric only)
    */
    public void setParticipantPhone(long participantPhone) { this.participantPhone = participantPhone; }

    /*
     * Setter accepting phone number as a String and storing as numeric.
     * @param participantPhone - student's phone number 
    */
    public void setParticipantPhone(String participantPhone) {
        StringBuilder theNumber = new StringBuilder("");
        Pattern digits = Pattern.compile("\\s");
        Matcher match = digits.matcher(participantPhone);
        while(match.find()) {
          theNumber.append(match.group());
        }
        long theNumberAsDigitsOnly = Long.parseLong(theNumber.toString());
        this.participantPhone = theNumberAsDigitsOnly;
    }

    /** Getters **/

    /*
     * Standard getter
     * @return the maximum class size
    */
    public static int getMaxClassSize() { return MAX_CLASS_SIZE; }

    /*
     * Standard getter
     * @return registered student's name
    */
    public String getParticipantName() { return this.participantName; }

    /*
     * Standard getter
     * @return registered student's phone number
    */
    public long getParticipantPhone() { return this.participantPhone; }

    


    /** Constructors **/

    /*
     * Constructor
     * @param participantPhone - student's phone number (String)
     * @param participantName - student's name
     * @throws IllegalArgumentException if the difficulty is invalid
     */
    public SkateSki(long participantPhone, String participantName) throws IllegalArgumentException {
        super(430, "Skate Skiing", 'I');
        setParticipantName(participantName);
        setParticipantPhone(participantPhone);
    }

    /*
     * Constructor
     * @param participantPhone - student's phone number (numeric)
     * @param participantName - student's name
     * @throws IllegalArgumentException if the difficulty is invalid
     */
    public SkateSki(String participantPhone, String participantName) throws IllegalArgumentException {
        super(430, "Skate Skiing", 'B');
        setParticipantName(participantName);
        setParticipantPhone(participantPhone);
    }

    /** Other methods **/

    /*
     * Create formatted information about the registration
     * @return formatted information about the registration
    */
    public String formatOrder() {
    // Format is:
    // this.COURSE_CODE: this.COURSE_NAME (this.DIFFICULTY_LEVEL) - this.participantName this.participantPhone
        StringBuilder output = new StringBuilder();
        output.append(CourseRegistration.formatOrder(
          Integer.toString(this.COURSE_CODE), this.COURSE_NAME, 
          String.valueOf(this.DIFFICULTY_LEVEL), this.participantName));
        output.append(" ");
        output.append(Long.toString(this.participantPhone));
        return output.toString();
    }
}

