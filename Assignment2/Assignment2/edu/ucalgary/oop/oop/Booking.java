package Assignment2.edu.ucalgary.oop.oop;



public class Booking{

private String STARTDATE;
private String ENDDATE;
private Pet BOOKEDPET; 
private Employee CAREGIVER; 

public Booking(Pet pet, Employee assigned, String startDate, String endDate){
    this.STARTDATE = startDate; 
    this.ENDDATE = endDate; 
    this.BOOKEDPET = pet; 
    this.CAREGIVER = assigned; 
}

public String getStartDate(){
    return this.STARTDATE; 
}

public String getEndDate(){
    return this.ENDDATE; 
}

public String getBookedPet(){
    return this.BOOKEDPET.getName();
}

public String getCareGiver(){
    return this.CAREGIVER.getName(); 
}

}


