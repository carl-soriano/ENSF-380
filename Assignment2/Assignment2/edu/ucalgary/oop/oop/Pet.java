package Assignment2.edu.ucalgary.oop.oop;


public class Pet{

    private String NAME;
    private String SPECIES;
    private String BREED; 
    private String COLOUR; 
    private boolean vaccineStatus = false; 
    private Client owner;  
    private EmergVet vet; 
    private CareProfile care; 


public Pet(String name, String species, String breed, String colour, Client owner){
    this.NAME = name; 
    this.SPECIES = species; 
    this.BREED = breed; 
    this.COLOUR = colour; 
    this.owner = owner; 
}

public void setVet(EmergVet vet){                     
    this.vet = vet; 
}

public EmergVet getVet(){
    return this.vet;
}


public void updateVaccineStatus(boolean change){
    vaccineStatus = change; 
}
public boolean getVaccineStatus(){
    return vaccineStatus; 
}

public void setCare(String[] meds, String medInstr, String feedingInstr){
    this.care = new CareProfile(meds, medInstr, feedingInstr); 
    
}

public String getCareSummary(){
    String outputSummary = new String();
    outputSummary = String.format("Care for %s:\n%s", this.NAME , care.summarizeCareInstructions());
    return outputSummary;
}

public String getName() {
    return NAME;
}

public String getSpecies() {
    return SPECIES;
}


public String getBreed() {
    return BREED;
}


public String getColour() {
    return COLOUR;
}


public Client getOwner() {
    return owner;
}

public void setOwner(Client updatClient) {
    this.owner = updatClient;
}

public CareProfile getCare() {
    return care;
}

}