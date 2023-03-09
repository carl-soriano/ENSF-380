package Assignment3.edu.ucalgary.oop;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Movement implements FormattedOutput, Cloneable{
	
	private String action;
	private String direction;
	private final static String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})";
	private final static Pattern PATTERN = Pattern.compile(REGEX);
	

	
	
	public Movement (String movement) throws IllegalArgumentException{
		Matcher movementMatcher = PATTERN.matcher(movement);
		if(movementMatcher.find()) {
			String unknownAction = movementMatcher.group().replace("\"", "").split("-")[0].replace(" ", "");
			String unknownDirection = movementMatcher.group().replace("\"", "").split("-")[1].replace(" ","");
				
			for(Actions a : Actions.values()) {
				if(unknownAction.equals(a.name())){
					this.action = unknownAction;
					
				}
			}
			for(Directions d: Directions.values()) {
				if((unknownDirection).equals(d.name())) {
					this.direction = unknownDirection;
					
				}
			}
			
			return;
		
		}
		
		throw new IllegalArgumentException ();
	}
	
	public String getAction() {
		return this.action;
	}
	
	public String getDirection() {
		return this.direction;
	}
	

	public Object clone() throws CloneNotSupportedException{
		Movement copy = (Movement)super.clone();
		return copy;
		
	}


	public String getFormatted() {
		String formattedOutput = "Action: " + this.getAction() + ", Direction: " + Directions.valueOf(this.getDirection()).toString();
		return formattedOutput;
	}
	
	
	
}
