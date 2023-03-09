package Assignment3.edu.ucalgary.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RobotDataRecord implements Cloneable{
	
	private ArrayList<RobotDataLine> log = new ArrayList <RobotDataLine>(); 
	
	
	public RobotDataRecord(String[] array){
		for(int i =0; i<array.length; i++) {
			log.add(new RobotDataLine(array[i]));
			
		}
	
		
	}
	
	
	public RobotDataLine getLine(int index) {
		return log.get(index);
	}
	
	public ArrayList<RobotDataLine> getDataRecord(){
		return this.log;
	}
	
	public Object clone() throws CloneNotSupportedException{
		RobotDataRecord copy = (RobotDataRecord)super.clone();
		copy.log = new ArrayList <RobotDataLine>();
		for(int i =0; i <log.size(); i++) {
			copy.log.add((RobotDataLine) log.get(i).clone());
		}
		return copy;
		
	}
	

}
