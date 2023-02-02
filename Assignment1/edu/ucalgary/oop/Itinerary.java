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
        String new_data = value + " (" + key + ")"; 
        return new_data; 
    }

    // Constructor 
    //Make each element in the given array, an object. 
    public Itinerary(String[][] myTrips) {
          for (int i = 0; i < myTrips.length ; i++){
            trips[i] = new Trip(myTrips[i]); 
          }
    }

    // Getter
    public Trip[] getTrips() {
        return trips; 
    }

    public String formatByArrival() {
        StringBuilder newString = new StringBuilder();
        String[][][] format = byDate(); 

        for(int i=0 ; i < format.length ; i++){
            int year = i + 2021;
            boolean hasYear = false;
            for(int j=0 ; j < format[i].length ; j++){
                boolean hasPlaces = false;
                for(int k=0 ; k < format[i][j].length ; k++) {
                    if(format[i][j][k] != null){
                        hasPlaces = true;
                        break;
                    }
                }
                if (hasPlaces) {
                    if (hasYear != true) {
                    newString.append(year + " (Year)\n");
                    hasYear = true;
                    }
                    newString.append("--" + (j + 1) + " (Month)\n");
                    for(int k=0 ; k < format[i][j].length ; k++) {
                        if(format[i][j][k] != null){
                            newString.append("----" + format[i][j][k] + " (Place)\n");
                }
            }
        }
    }
}
        newString.setLength(newString.length() - 1);    
        return newString.toString();

    }

    
    

    // The first array holds years (2021-2023).
    // The second array holds months. 
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
        String[][][] dateArray = new String[3][12][20];
            for(int i =0; i < trips.length ; i++ ){
                if (trips[i] != null ){
                    String date = trips[i].getArrival();
                    int year = Trip.getYear(date) - 2021;
                    int month = Trip.getMonth(date) - 1; 
                    String locations = fmtString("City", trips[i].getCity()) + ", " + fmtString("Country", trips[i].getCountry());

                    int location = 0; 
                    while(true){
                        if(dateArray[year][month][location] == null) {
                            dateArray[year][month][location] = locations; 
                            break;
                        }
                        location++;
                    }
                }
            }

        return dateArray; 

    }

}
