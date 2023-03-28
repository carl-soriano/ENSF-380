package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.*;

/* getTranslation()
   * getter method returning a stored TranslationText object.
  */

/* translate()
 * Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for
 * the 31st), and a year. Note that years may be any previous year in the common era 
 * (CE) from 0 to the previous year, or they may be before the common era (BCE),
 * represented by negative numbers. Thus 2021, 800, and -1600 are all valid years.
 * Method throws an IllegalArgumentException if monthNum or dayNum is not
 * valid. Returns the formatted sentence as a String. Notice that the String
 * containing formatting uses numbered arguments - this is because some languages
 * will put the words in the sentence in a different order, but the translate()
 * method must be able to work without knowledge of the language structure.
 * Note: You do not have to check if a day is valid for a particular month/year;
 * February 31 or February 29, 2021 can both be accepted, but out of range values
 * e.g., month 15 day 0, are not valid and should be handled with an 
 * IllegalArgumentException. 
*/

/* Constructor
 * Accepts a String of a two-letter language code (lowercase), dash, and two-letter 
 * region (caps) code, e.g., te-IN and throws an IllegalArgumentException if the language 
 * and region code are not in the correct format. Language codes are ISO 639-1 and
 * region codes are ISO 3166, but this method only checks the format of the String, 
 * not if the region and language codes are valid according to the ISO specifications.
 * The input parameter must exactly match the expected format.
 * It calls importTranslation().
 * Does not catch ArgFileNotFoundException (exception may optionally be caught
 * by code which invokes this constructor).
*/

/* importTranslation()
 * Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
 * No arguments. Returns void.
*/

/* importFromText()
 * Reads in from a the two-letter language code, dash, two-letter region code text 
 * file, in the form of ab-XY.txt, and instantiates a TranslationText object with
 * the data. It can throw I/O exceptions. Throw a custom ArgFileNotFoundException
 * when the file isn't found. 
 * We expect the .txt file to be in a valid format. The file is expected to be in the same 
 * directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They will 
 * always consist of the month names, one per line, followed by the day names, one per line, 
 * followed by the sentence containing formatting strings. This is the last line in the file. You
 * cannot make any assumptions about what will appear on each line, only that each line
 * will contain only one data element, and that it will not contain an empty line.
 * No arguments. Returns void.
*/

/* serialize()
* Creates a serialized object file of the TranslationText object, with the
* name format la-CO.ser, where la is the two-letter language code and CO is
* the two-letter region code. An example of a serialized object file can be
* found in the exercise directory as es-BO.ser
* I/O exceptions can be thrown.
* No arguments. Returns void.
*/

/* deserialize()
 * Creates a TranslationText object from a .ser file. The files are named
 * xx-YY.ser, where xx is the two-letter language code and YY is the two-
 * letter region code. es-BO.ser is an example. It can throw I/O exceptions.
 * No arguments. Returns void.
*/

public class Translator {

    private String myFile;
    private TranslationText translation;

    final String LANG_REGEX = "^[a-z]{2}-[A-Z]{2}$";
    final Pattern LANG_PATTERN = Pattern.compile(LANG_REGEX);

    public Translator(String lang) throws ArgFileNotFoundException {
        Matcher MATCH_LANG = LANG_PATTERN.matcher(lang);

        if (!MATCH_LANG.find()) {
            throw new IllegalArgumentException();
        }
        this.myFile = lang;

        importTranslation();

    }

    public void importTranslation() throws ArgFileNotFoundException {
        File serFile = new File(this.myFile + ".ser");

        // checks file input, by hecking if serFile exists. Else, importFromText
        if (serFile.isFile()) {
            deserialize();
        } else {
            importFromText();
        }
    }

    public void importFromText() throws ArgFileNotFoundException {

        File txtFile = new File(this.myFile + ".txt");

        // check if txtFile exists

        if (!txtFile.exists()) {
            throw new ArgFileNotFoundException();
        }
        BufferedReader reader;
        String line;
        String[] fileContents = new String[44];
        int i = 0;
        // start file reading
        try {
            reader = new BufferedReader(new FileReader(this.myFile + ".txt"));
            while ((line = reader.readLine()) != null) {
                fileContents[i] = line;
                i++;
            }
            reader.close();
            // read all contents into the fileContents array and close the BufferedReader
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] months = new String[12];
        String[] days = new String[31];
        i = 0;

        for (int j = 0; j < 12; j++, i++) {
            months[j] = fileContents[i];
        }
        for (int j = 0; j < 31; j++, i++) {
            days[j] = fileContents[i];
        }
        // transfer the contents into separate arrays for days and months

        this.translation = new TranslationText(months, days, fileContents[i]);

        // try {

        // FileReader readFile = new FileReader(this.myFile+".txt");
        // BufferedReader reader = new BufferedReader(readFile);
        // for (int i = 0; i < 12; i++) {
        // months[i] = reader.readLine();
        // }
        // for (int i = 0; i < 31; i++) {
        // days[i] = reader.readLine();
        // }
        // String sentence = reader.readLine();

        // //close files
        // reader.close();
        // readFile.close();
        // translation = new TranslationText(sentence, days, months);
        // }catch (IOException e) {
        // System.out.println("Error: Input Text File cannot be found.");
        // e.printStackTrace();
        // System.exit(1);
        // }

    }

    public TranslationText getTranslation() {
        return this.translation;
    }

    public String translate(int monthInput, int dayInput, int year) throws IllegalArgumentException {
        if (monthInput < 1 || monthInput > 12) {
            throw new IllegalArgumentException("Invalid month, can only accept: 1-12");
        }

        if (dayInput < 1 || dayInput > 31) {
            throw new IllegalArgumentException("Invalid day, can only accept 1-31");
        }

        String formattedSentence = this.translation.getSentence();
        System.out.println("\n\n");
        String day = this.translation.getDay(dayInput - 1);
        String month = this.translation.getMonth(monthInput - 1);
        return String.format(formattedSentence, day, month, year);
    }

    public void serialize() {
        // do the same for this but serializing
        try {
            FileOutputStream fileOutput = new FileOutputStream(this.myFile + ".ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(this.translation);

            fileOutput.close();
            objectOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deserialize() {
        try {
            FileInputStream fileInput = new FileInputStream(this.myFile + ".ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            this.translation = (TranslationText) objectInput.readObject();

            fileInput.close();
            objectInput.close();
            // close the files when finished
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}