package edu.ucalgary.oop;

import java.io.Serializable;

/* TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of 19L.
 * Member data names should be based on those implied by the getters. Member data are not final.
*/

  /* getSentence()
   * Getter method, returns String
  */

  /* getMonths()
   * Getter method, returns String[]
  */

  /* getDays()
   * Getter method, returns String[]
  */

  /* getMonth()
   * Accepts an integer 0-11 corresponding to an index in the months array,
   * and returns the value at that index. (e.g., 0 = January)
  */

  /* getDay()
   * Accepts an integer 0-30 corresponding to an index in the day array,
   * and returns the value at that index. (e.g., 30 = 31st)
  */

  /* Constructor
   * Accepts a String array of months, a String array of days, and a String 
   * containing a sentence with formatting.
  */


  
  /* TranslationText
   * Serializable representation of the data file. Has the serialVersionUID of 19L.
   * Member data names should be based on those implied by the getters. Member data are not final.
   */
  public class TranslationText implements Serializable {
  
      private static final long serialVersionUID = 19L;
      private String sentence;
      private String[] months;
      private String[] days;
  
      /* Constructor
       * Accepts a String array of months, a String array of days, and a String 
       * containing a sentence with formatting.
       */
      public TranslationText(String[] months, String[] days, String sentence) {
          this.months = months;
          this.days = days;
          this.sentence = sentence;
      }
  
      /* getSentence()
       * Getter method, returns String
       */
      public String getSentence() {
          return sentence;
      }
  
      /* setSentence()
       * Setter method, accepts a String
       */
      public void setSentence(String sentence) {
          this.sentence = sentence;
      }
  
      /* getMonths()
       * Getter method, returns String[]
       */
      public String[] getMonths() {
          return months;
      }
  
      /* setMonths()
       * Setter method, accepts a String[]
       */
      public void setMonths(String[] months) {
          this.months = months;
      }
  
      /* getDays()
       * Getter method, returns String[]
       */
      public String[] getDays() {
          return days;
      }
  
      /* setDays()
       * Setter method, accepts a String[]
       */
      public void setDays(String[] days) {
          this.days = days;
      }
  
      /* getMonth()
       * Accepts an integer 0-11 corresponding to an index in the months array,
       * and returns the value at that index. (e.g., 0 = January)
       */
      public String getMonth(int index) {
          return months[index];
      }
  
      /* getDay()
       * Accepts an integer 0-30 corresponding to an index in the day array,
       * and returns the value at that index. (e.g., 30 = 31st)
       */
      public String getDay(int index) {
          return days[index];
      }
  }
  


