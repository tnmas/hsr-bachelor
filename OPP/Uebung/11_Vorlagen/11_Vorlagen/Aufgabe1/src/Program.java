import java.io.IOException;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Program {
	public static void main(String[] args) throws IOException {
		var people = PeopleData.read("people.csv");
		
		// a) Alle unterschiedlichen Vornamen weiblicher 
		// Personen mit maximal 3 Buchstaben
		
		people.stream()
		.filter(p -> p.getGender() == Gender.FEMALE)
		.filter(p -> p.getFirstName().length() <= 3)
		.map(p -> p.getFirstName())
		.sorted()
		.distinct()
		.forEach(System.out::println);
		
		// b) Durchschnittsalter aller männlicher Personen
		
		OptionalDouble averageAge = people.stream()
		.filter(p -> p.getGender() == Gender.MALE)
		.mapToInt(p -> p.getAge()).average();
		 averageAge.ifPresent(System.out::println);
		 
		 
		 // c) Minimal- und Maximalalter aller Personen in Zürich
		 
		 var minAge = people.stream()
		 .filter(p -> p.getGender() == Gender.MALE)
		 .filter(p -> p.getCity().equals("Zürich"))
		 .mapToInt(p -> p.getAge())
		 .min();
		 
		 var maxAge = people.stream()
				 .filter(p -> p.getGender() == Gender.MALE)
				 .filter(p -> p.getCity().equals("Zürich"))
				 .mapToInt(p -> p.getAge())
				 .max();
		 
		minAge.ifPresent(System.out::println);
		maxAge.ifPresent(System.out::println);
		
		
		// d) Top 10 Verdiener (Jahreseinkommen)
		
	var	age = people.stream()
		.sorted(Comparator.comparing(Person::getAge))
		.limit(10);
	
	age.map(p -> p.getSalary()).forEach(System.out::println);
	
	
	// e) Durchschnittsalter pro Ort (Gruppierung mittels Collector)
	
	var average = people.stream()
	.collect(Collectors.groupingBy(Person::getCity, Collectors.averagingInt(Person::getAge)));
		
	System.out.println(average);
	
	
	}
}
