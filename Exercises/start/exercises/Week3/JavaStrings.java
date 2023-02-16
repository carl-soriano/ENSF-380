public class JavaStrings {
    public static int addTogether (String n, String b) { 
        String nTrim = 
        
        String concatString = n.trim() + b.trim();
        return concatString.length();
    }
    
    public static String idProcessing (String name, String lastName, String petName, int year) {
        name = name.substring(0, 1);
        lastName = lastName.substring(0, 1);
        petName = petName.substring(0, 1);
        String identifier = name + lastName + petName + year;
        return identifier;
    }

    public static String secretCode (String sc) {
        sc = sc.replaceAll("[aeiouAEIOU]", "z");
        
        sc = sc.substring(0, 3);

        return sc;
    }
    
    public static void main(String args[]) {
        JavaStrings myObject = new JavaStrings();

        // Print out examples from addTogether.
        String oneExample = "12 4 6789";
        String twoExample = "abcdef gh";
        int theLength = myObject.addTogether(oneExample,twoExample);
        System.out.println(theLength);

        // Length is unchanged by adding whitespace to front and back
        oneExample = "   " + oneExample + "\n";
        twoExample = "\t" + twoExample;
        theLength = myObject.addTogether(oneExample,twoExample);
        System.out.println(theLength);

        // Print out example of idProcessing
        String personFirst = "Dorothy";
        String personLast = "Gale";
        String petName = "Toto";
        int petBirth = 1899;
        String theID = myObject.idProcessing(personFirst,personLast,
                       petName,petBirth);
        System.out.println(theID);

        // Print out examples from secretCode
        String ingredientOne = "tomato";
        String ingredientTwo = "WATER";
        String theCode = myObject.secretCode(ingredientOne);
        System.out.println(theCode);
        theCode = myObject.secretCode(ingredientTwo);
        System.out.println(theCode);
    }
}

/*

Provides a method addTogether
– Accepts two Strings as arguments
– The method should trim the leading and trailing whitespaces from each String and add
them together
– Returns the length of the trimmed, concatenated String


Provides a method idProcessing
– A veterinary clinic needs to create unique identifiers for its animal clients. The identifier
will consist of the owner’s first and last initials, the first initial of the animal’s name, and
the pet’s year of birth (e.g. EMD2010)
– Write a method that will:
∗ Accept three Strings and an integer as arguments (first name, last name, pet name,
year)
∗ Returns the desired identifier as a String



Provides a method secretCode
– A famous pizzeria wants to encode its secret recipe. All ingredients are referred to using
code words. Vowels (a, e, i, o, u and their capital versions) are replaced with a “z” (always
lower-case) and only the first three letters are used (e.g. tomato = tzmztz = tzm, POTATO =
PzTzTz = PzT)
– Write a method that will:
∗ Accept a String as an argument
∗ Return the corresponding secret code String
∗ You may assume that all ingredients are at least three letters lon */

