import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateConverter {
	
	
	private final String weekdayGroup = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun)";
	private final String dayGroup = "([0-2]?[1-9])";
	private final String monthGroup = "(0?[1-9]|[1|2][0-9]|3[0|1])";
	private final String yearGroup = "(19|20[0-9]{2})";
	private final String hourGroup = "([0]?[0-9]|1[0-2])";
	private final String minuteGroup = "([0-5][0-9])";
	private final String meridianGroup = "(AM|PM)";
	private final String usDateRegex = String.format("^%s %s/%s/%s %s:%s %s$", weekdayGroup, monthGroup, dayGroup,
			yearGroup, hourGroup, minuteGroup, meridianGroup);

	private Pattern pattern;
	private Map<String, String> usDEDayMap = new HashMap<>();
	

	public DateConverter() {
		pattern = Pattern.compile(usDateRegex);
		PutDayToMap();
	}

	private void PutDayToMap() {
		usDEDayMap.put("Mon", "Mo");
		usDEDayMap.put("Tue", "Di");
		usDEDayMap.put("Wed", "Mi");
		usDEDayMap.put("Thu", "Do");
		usDEDayMap.put("Fri", "Fr");
		usDEDayMap.put("Sat", "Sa");
		usDEDayMap.put("Sun", "So");		
	}

	public String convertDateToDE(String usDateFormat) {
		Matcher matcher = getMatch(usDateFormat);
		if(!matcher.matches()){
			throw new IllegalArgumentException("US DateTime Format doesn't match");
		}
		
		String weekday = usDEDayMap.get(matcher.group(1));
		String day = matcher.group(3);
		String month = matcher.group(2);
		String year = matcher.group(4);
		String hour = matcher.group(5);
		String minute = matcher.group(6);
		
		if(matcher.group(7).equals("PM")){
			int hour24 = Integer.parseInt(hour);
			hour24 = hour24 == 12 ? hour24 : hour24 + 12;
			hour =  Integer.toString(hour24);
		}else{
			hour = hour.equals("12") ? "0" : hour;
		}
		
		return getGeFormat(weekday, day, month, year, hour, minute);
	}

	private Matcher getMatch(String text) {
		return pattern.matcher(text);
	}
	
	private String getGeFormat(String weekday, String day, String month, String year, String hour, String minute){
		return String.format("%s %s.%s.%s %s:%s", weekday, day, month, year, hour, minute);
	}
	
	@Override
	public String toString() {
		return usDateRegex;
	}
	
}
