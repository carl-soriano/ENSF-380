package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

public class Trip {
    private String arrival;
    private String departure;
    private String city;
    private String country;

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        String new_data = value + " (" + key + ")"; 
        return new_data; 
    }

    // Constructor
    public Trip(String[] array) {
        arrival = array[0];
        departure = array[1];
        city = array [2];
        country = array[3];
    }

    // Given a date string, return just the year
    public static int getYear(String date) {
        String str; 
        str = date.substring(0,4); 
        int new_year = Integer.valueOf(str);
        return new_year;
    }

    // Given a date string, return just the month
    // Since it is an int, a date like "2022-01-12" returns 1
    public static int getMonth(String date) {
        String str; 
        str = date.substring(5,7); 
        int new_month = Integer.valueOf(str);
        return new_month;
    }

    // Return a formatted string of key/value pairs, with commas
    // between each. See the output for an example.
    public String formatTrip() {
        return this.getArrival() + " (Arrival), " + this.getDeparture() + " (Departure), " + this.getCity() + " (City), " + this.getCountry() + " (Country), "; 

    }

    // Getter
    public String getArrival() {
        return arrival; 
    }

    // Getter
    public String getDeparture() {
        return departure; 
    }

    // Getter
    public String getCity() {
        return city;
    }

    // Getter
    public String getCountry() {
        return country;
    }

    // Setter
    public void setArrival(String date) {
        date = this.arrival;
    }

    // Setter
    public void setDeparture(String date) {
        date = this.departure; 
    }

    // Setter 
    public void setCity(String city) {
        city = this.city;
    }

    // Setter 
    public void setCountry(String country) {
       country = this.country; 
    }

}