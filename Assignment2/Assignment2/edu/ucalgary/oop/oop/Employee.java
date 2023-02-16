package Assignment2.edu.ucalgary.oop.oop;



public class Employee{

    private String name;
    private String IDNUMBER;
    private String managerID;
    private Employee[] supvervisedEmployees = new Employee[10]; 



public Employee(String name, String idNumber){
    this.name = name;
    this.IDNUMBER = idNumber; 


}

public Employee(String name, String idNumber, String managerID){
    this.name = name;
    this.IDNUMBER = idNumber; 
    this.managerID = managerID; 

}

public String getName() {
    return name;
}

public String getIDNumber() {
    return IDNUMBER;
}

public String getManagerID() {
    return managerID;
}

public Employee[] getEmployees() {
    return supvervisedEmployees;
}

public void setName(String name) {
    this.name = name;
}

public void setManagerID(String managerID) {
    this.managerID = managerID;
}

public void addEmployee(Employee newEmployee) {  
    if (supvervisedEmployees == null) {
        supvervisedEmployees = new Employee[1];
    }
    else {
        int currentSize = supvervisedEmployees.length;
        Employee[] newArray = new Employee[currentSize + 1];
        for (int i = 0; i < currentSize; i++){
            newArray[i] = supvervisedEmployees[i];
        }
        newArray[currentSize] = newEmployee;
        supvervisedEmployees = newArray; 
    }
    
}


    
}