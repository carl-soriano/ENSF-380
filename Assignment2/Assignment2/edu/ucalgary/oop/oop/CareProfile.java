package Assignment2.edu.ucalgary.oop.oop;

public class CareProfile{

private String medInstructions;
private String feedingIntructions;
private String[] medList; 

public CareProfile(String[] medlist, String meds, String feeding){
    this.medList = medlist; 
    this.medInstructions = meds; 
    this.feedingIntructions = feeding; 
}

public String summarizeCareInstructions(){
    String output = ""; 
    
    for(int i = 0; i < medList.length; i++){
       output += medList[i];
       if(i < medList.length - 1){
        output += ", ";
       }
    } 
    output.trim();

    output += "\n" +  medInstructions + "\n" +  feedingIntructions; 



    return output; 
    
    
}

}