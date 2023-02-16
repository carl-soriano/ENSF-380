package Assignment2.edu.ucalgary.oop.oop;


public class RewardsProfile{


private String rewardsNum = "Not enrolled"; 
private int pointsTotal = 10; 


public RewardsProfile(){
}

public RewardsProfile(String newNumber) throws InvalidRewardsNumException{           
   for(int i = 0; i< newNumber.length(); i++){
    if(!Character.isDigit(newNumber.charAt(i))){
        throw new InvalidRewardsNumException();
    }
   }
   this.rewardsNum = newNumber; 

}

public int getPoints(){
    return pointsTotal;                   
}

public void setPoints(int pointsTotal){            
    this.pointsTotal += pointsTotal; 
}

public String getNumber(){
    return rewardsNum;                                
}

}