package Assignment3.edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sensor implements FormattedOutput, Cloneable {
	
	private String sensor;
	private final static String REGEX = "\\(([a-z]+)\\)";
	private final static Pattern PATTERN = Pattern.compile(REGEX);
	
	
	
	public Sensor(String Sensor) throws IllegalArgumentException{
		Matcher sensorMatcher = PATTERN.matcher(Sensor);
		if(sensorMatcher.find()) {
			this.sensor = sensorMatcher.group().replace("(", "").replace(")", "");
			return;
		}
		throw new IllegalArgumentException();
	
	}
	
	
	public String getSensor() {
		return this.sensor; 
	}
	
	public Object clone() throws CloneNotSupportedException{
		Sensor copy = (Sensor)super.clone();
		return copy;
		
	}


	@Override
	public String getFormatted() {
		String output = "Sensor: " + getSensor();
		return output;
	}

}
