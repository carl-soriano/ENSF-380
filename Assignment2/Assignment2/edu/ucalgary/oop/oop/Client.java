package Assignment2.edu.ucalgary.oop.oop;


public class Client{

private String name;
private String phoneNumber;
private String address; 
private RewardsProfile rewardsinfo = new RewardsProfile(); 


public Client(String name, String phoneNumber, String address){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address; 
}

public boolean enrollRewards(String newNumber){                
    try {
        rewardsinfo = new RewardsProfile(newNumber); 
        return true;
    }
    catch(InvalidRewardsNumException q){
        return false; 
    }
}

public int getRewardsPoints(){           
    return this.rewardsinfo.getPoints();
}

public String getRewardsNumber(){        
    return this.rewardsinfo.getNumber(); 
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getPhoneNumber() {
    return phoneNumber;
}


public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public void updatePoints(int addPoints){
    rewardsinfo.setPoints(addPoints);
}             

}


