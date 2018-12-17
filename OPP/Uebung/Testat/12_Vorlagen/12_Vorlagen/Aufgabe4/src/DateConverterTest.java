
public class DateConverterTest {

	public static void main(String[] args) {
		String dateUs1 = "Thu 12/7/2017 10:15 AM";
		String dateUs2 = "Sat 12/24/2017 8:00 PM";
		String dateUs3 = "Sun 1/1/2018 12:00 AM";
		var date = new DateConverter();
		System.out.println(date.convertDateToDE(dateUs1));
		System.out.println(date.convertDateToDE(dateUs2));
		System.out.println(date.convertDateToDE(dateUs3));
	}

}
