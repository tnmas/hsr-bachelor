import java.util.Comparator;
import java.util.List;
import java.io.IOException;

//interface SearchPerson<T> {
//	@SuppressWarnings("hiding")
//	<T> List<T> search(List<T> input, T criterion);
//}

public class Program{
	public static void main(String[] args) throws IOException {
		var people = PeopleData.read("people.csv");
		new Program().sortedPeople(people);
		PeopleData.write("csvFiles/sortedCompLnRevAge.csv", people);
		
	}
	
	int compareByAge(Person person1, Person person2) {
		return Integer.compare(person1.getAge(), person2.getAge());	
	}
	
	int compareByAgeReversed(Person person1, Person person2) {
		return -Integer.compare(person1.getAge(), person2.getAge());	
	}
	
	int compareByLastName(Person person1, Person person2) {
		return person1.getLastName().compareTo(person2.getLastName());	
	}
	
	int compareNameLengthReversed(Person person1, Person person2) {
	    var combineNamep1 = person1.getFirstName() + person1.getLastName();
	    var combineNamep2 = person2.getFirstName() + person2.getLastName();
		return -Integer.compare(combineNamep1.length(), combineNamep2.length());	
	}
	
	int comparePlLnFn(Person person1, Person person2) {
		var result1 = person1.getCity().compareTo(person2.getCity());
		if (result1 != 0) {
			return result1;
		}
		else {
			var result2 = person1.getLastName().compareTo(person2.getLastName());
			if (result2 != 0) {
				return result2;
			}
			return person1.getFirstName().compareTo(person2.getFirstName());
		}
	}
	int compareByLnRvAge(Person person1, Person person2) {
		var lastName = person1.getLastName().compareTo(person2.getLastName());	
		if (lastName != 0) {
			return lastName;
		}
		return -Integer.compare(person1.getAge(), person2.getAge());
	}
	
	
	
	 void sortedPeople(List<Person> people) {
		 /**
		  * 
		  * Here is Method references
		  */
		 
//		people.sort(this::compareByAgeReversed);
//		people.sort(this::compareByAge);
//		 people.sort(this::compareByLastName);
//		 people.sort(this::compareNameLengthReversed);
//		 people.sort(this::comparePlLnFn);
//		 people.sort(this::compareByLnRvAge);
		 
		 /**
		  * 
		  * Here I used Lambda
		  * 
		  */
		 
//		 people.sort((person1, person2)->Integer.compare(person1.getAge(), person2.getAge()));
//		 people.sort((person1, person2)->-Integer.compare(person1.getAge(), person2.getAge()));
//		 people.sort((person1, person2)->person1.getLastName().compareTo(person2.getLastName()));
		
//		 people.sort((person1, person2)->-Integer.compare((person1.getFirstName() + person1.getLastName()).length(), (person2.getFirstName() + person2.getLastName()).length()));

//		 people.sort((person1, person2)->{
//			 var result1 = person1.getCity().compareTo(person2.getCity());
//				if (result1 != 0) {
//					return result1;
//				}
//				else {
//					var result2 = person1.getLastName().compareTo(person2.getLastName());
//					if (result2 != 0) {
//						return result2;
//					}
//					return person1.getFirstName().compareTo(person2.getFirstName());
//				}
//		 });
	
//		 people.sort((person1, person2)->{
//			 var lastName = person1.getLastName().compareTo(person2.getLastName());	
//				if (lastName != 0) {
//					return lastName;
//				}
//				return -Integer.compare(person1.getAge(), person2.getAge());
//		 });
		 
		 /**
		  * 
		  * Here is Comparator
		  * 
		  */
		 
//		 people.sort(Comparator.comparing(Person::getAge));
//		 people.sort(Comparator.comparing(Person::getAge).reversed());
//		 people.sort(Comparator.comparing(Person::getLastName));
//		 people.sort(Comparator.comparing(Person::lengthConcatenatedString).reversed());
//		 people.sort(Comparator.comparing(Person::getCity).thenComparing(Person::getLastName).thenComparing(Person::getFirstName));
		 people.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getAge).reversed());
	 };

		 
	 }
