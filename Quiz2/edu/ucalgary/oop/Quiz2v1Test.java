/*
Copyright Ann Barcomb and Emily Marasco, 2023
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.regex.*;

public class Quiz2v1Test {
    // Values used for all tests involving SkateSki class
    int expectedCourseCode = 430;
    String expectedCourseName = "Skate Skiing";
    char expectedCourseDifficultyLevel = 'I';

    SkateSki sharedTestObj = new SkateSki(9876, "Forum Shetty");

    @Test
    public void testConstants() {
        int expectedMaxSize = 10;
  
        int actualMaxSize = sharedTestObj.getMaxClassSize();
 
        assertEquals("Constant value maximum class size is not correct", 
            expectedMaxSize, actualMaxSize);
    }

    @Test
    public void testInheritedGetters() {
        int actualCourseCode = sharedTestObj.getCourseCode();
        String actualCourseName = sharedTestObj.getCourseName();
        char actualCourseDifficultyLevel = sharedTestObj.getDifficultyLevel();

        assertEquals("Constructor or getter gave wrong value for course code", 
          expectedCourseCode, actualCourseCode);
        assertEquals("Constructor or getter gave wrong value for course name", 
          expectedCourseName, actualCourseName);
        assertEquals("Constructor or getter gave wrong value for course difficulty", 
          expectedCourseDifficultyLevel, actualCourseDifficultyLevel);
    }

    @Test
    public void testConstructorAndGettersWithNumericPhone() {
        long expectedParticipantPhone = 1234567;
        String expectedParticipantName = "Shreyankar Gulkota";

        SkateSki testObj = new SkateSki(expectedParticipantPhone, expectedParticipantName);

        long actualParticipantPhone = testObj.getParticipantPhone();
        String actualParticipantName = testObj.getParticipantName();

        assertEquals("Constructor or getter gave wrong value for participant phone", 
          expectedParticipantPhone, actualParticipantPhone);
        assertEquals("Constructor or getter gave wrong value for participant name", 
          expectedParticipantName, actualParticipantName);
    }

    @Test
    public void testConstructorAndGettersWithStringPhone() {
        String providedParticipantPhone = "878-1841";
        long expectedParticipantPhone = 8781841;
        String expectedParticipantName = "Soyoon Lee";

        SkateSki testObj = new SkateSki(providedParticipantPhone, expectedParticipantName);

        long actualParticipantPhone = testObj.getParticipantPhone();
        String actualParticipantName = testObj.getParticipantName();
        int actualCourseCode = testObj.getCourseCode();
        String actualCourseName = testObj.getCourseName();
        char actualCourseDifficultyLevel = testObj.getDifficultyLevel();

        assertEquals("Constructor or getter gave wrong value for participant phone",
          expectedParticipantPhone, actualParticipantPhone);
        assertEquals("Constructor or getter gave wrong value for participant name",
          expectedParticipantName, actualParticipantName);
    }

    @Test
    public void testSetParticipantPhoneNumeric() {
        long expectedParticipantPhone = 129;
        String expectedParticipantName = "Shirin Mohajernia";

        SkateSki testObj = new SkateSki(120, expectedParticipantName);
        testObj.setParticipantPhone(expectedParticipantPhone);
        long actualParticipantPhone = testObj.getParticipantPhone();

        assertEquals("Setting a new participant phone number (numeric) did not work",
          expectedParticipantPhone, actualParticipantPhone);
    }

    @Test
    public void testSetParticipantPhoneStringNormalization() {
        long expectedParticipantPhone = 120;
        String providedParticipantPhone = "$1 AbC 2-0 =r";
        String expectedParticipantName = "Jane Burdock";
        
        SkateSki testObj = new SkateSki(8888, expectedParticipantName);
        testObj.setParticipantPhone(providedParticipantPhone);
        long actualParticipantPhone = testObj.getParticipantPhone();
        
        assertEquals("Setting a new participant phone number (String) did not work",
          expectedParticipantPhone, actualParticipantPhone);
    }

    @Test
    public void testFormatOrderExactFormatting() {
        String expectedOutput = "430: Skate Skiing (I) - Alec Stromquist 8280014";
        long providedParticipantPhone = 8280014;
        String providedParticipantName = "Alec Stromquist"; 

        SkateSki testObj = new SkateSki(providedParticipantPhone, providedParticipantName);
        String actualOutput = testObj.formatOrder();

        assertEquals("SkateSki.formatOrder() did not return a correctly formatted String.",
            expectedOutput, actualOutput);
    }

    @Test
    public void testFormatOrderApproximateFormatting() {
        String expectedOutput = "430: Skate Skiing (I) - Julia Kaufmann";
        long providedParticipantPhone = 8280001;
        String providedParticipantName = "Julia Kaufmann"; 

        SkateSki testObj = new SkateSki(providedParticipantPhone, providedParticipantName);
        String actualOutput = testObj.formatOrder();
        actualOutput = actualOutput.replaceAll(" \\d*$", "");

        assertEquals("SkateSki.formatOrder() did not return an approximately correctly formatted String.",
            expectedOutput, actualOutput);
    }

    @Test
    public void testFormatOrderContentOnly() {
        String expectedOutput = "430skateskiingialecstromquist8280003";
        long providedParticipantPhone = 8280003;
        String providedParticipantName = "Alec Stromquist";

        SkateSki testObj = new SkateSki(providedParticipantPhone, providedParticipantName);
        String actualOutput = testObj.formatOrder();
        actualOutput = actualOutput.toLowerCase();
        actualOutput = actualOutput.replaceAll("[^\\w_]", "");

        assertEquals("SkateSki.formatOrder() did not return the expected content.",
            expectedOutput, actualOutput);
    }

    @Test
    public void testSkateSkiInheritsFromRecreationCourse() {
        assertTrue("SkateSki does not inherit from RecreationCourse", 
          (sharedTestObj instanceof RecreationCourse));
    }

    @Test
    public void testSkateSkiImplementsCourseRegistration() {
        assertTrue("SkateSki does not implement CourseRegistration",
          (CourseRegistration.class.isAssignableFrom(sharedTestObj.getClass())));
    }

    @Test
    public void testNormalizeCourseLevel() {
        char providedLevel = 'a';
        char expectedLevel = 'A';

        char actualLevel = RecreationCourse.normalizeLevel(providedLevel);

        assertEquals("RecreationCourse does not normalize difficulty level to capital letter",
           expectedLevel, actualLevel);
    }

    @Test
    public void testValidateCourseLevel() {
        char expectedLevel = 'B';

        RecreationCourse testObj = new RecreationCourse(40, "Krav Maga", expectedLevel);
        char actualLevel = testObj.getDifficultyLevel();
  
        assertEquals("RecreationCourse does not validate difficulty level by returning valid level",
           expectedLevel, actualLevel);

    }

    @Test
    public void testValidateCourseLevelIllegalArgumentException() {
        boolean testResult = false;

        try {
            RecreationCourse testObj = new RecreationCourse(50, "Baking Cakes", 'H');
        }
        catch (IllegalArgumentException e) {
            testResult = true;
        }
        catch (Exception e) { }
        assertTrue("validateLevel did not throw an IllegalArgumentException given an invalid level", 
            testResult);
    }

    @Test
    public void testValidateCourseLevelExceptionMessage() {
        String expectedError = "Course level must be a single character: B (beginner), I (intermediate), or A (advanced)";
        String actualError = "";

        try {
            RecreationCourse testObj = new RecreationCourse(501, "Baking Cupcakes", '2');
        }
        catch (Exception e) {
            actualError = e.getMessage();
        }
        assertEquals("validateLevel did not provide correct exception message given an invalid level",
          expectedError, actualError);
    }

}

