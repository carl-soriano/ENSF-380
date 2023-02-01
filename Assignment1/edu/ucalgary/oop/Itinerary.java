package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

public class Itinerary {
    private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        String new_data = value + "(" + key + ")"; 
        return new_data; 
    }


    // Constructor
    public Itinerary(String[][] myTrips) {
         String itenerary_obj;  

    }

    // Getter
    public Trip[] getTrips() {
        return trips; 
    }

    public String formatByArrival() {
        


    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
    }

}
