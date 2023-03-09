package Assignment3.edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotDataLine implements Cloneable{
	
	private String dataLine;
	private String robotID;
	private Sensor sensor;
	private Movement movement;
	private LocalDate date;
	private final static String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
	private final static Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
	private final static String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
	private final static Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);
	
	
	
	public RobotDataLine (String line) throws IllegalArgumentException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Matcher robotMatcher = ROBOT_PATTERN.matcher(line);
		Matcher dateMatcher = DATE_PATTERN.matcher(line);
		
		String calendarRegex = "\\[(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})\\]";
		Pattern calendarPattern = Pattern.compile(calendarRegex);
		Matcher calendarMatcher = calendarPattern.matcher(line);	
		if(robotMatcher.find() && dateMatcher.find() && calendarMatcher.find()) {
		this.dataLine = line;
		this.robotID = robotMatcher.group().replace(" ", "");
		this.date = LocalDate.parse(dateMatcher.group().replace("[", "").replace("]", ""), formatter);
		this.movement = new Movement(line);
		this.sensor= new Sensor(line);
		return;
		}
		
		throw new IllegalArgumentException();
		
	}
		
	
	
	public String getRobotID() {
		return this.robotID;
	}
	
	public String getDataLine() {
		return this.dataLine;
	}	
	
	public Sensor getSensor() {
		return this.sensor;
	}
	
	public Movement getMovement() {
		return this.movement;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public Object clone () throws CloneNotSupportedException{
		RobotDataLine copy = (RobotDataLine)super.clone();
		copy.sensor = (Sensor)sensor.clone();
		copy.movement = (Movement)movement.clone();
		return copy;
		
	}
	
	

}
