package Assignment2.edu.ucalgary.oop.oop;

public class ReportCard{


private Booking REPORT; 

public  ReportCard(Booking reportInfo ){
    this.REPORT = reportInfo; 
}


public String printReport(){
    String output= ""; 
    
    output += REPORT.getCareGiver() + " enjoyed taking care of " + REPORT.getBookedPet() + ". See you next time!";
    
    return output; 
}
}

