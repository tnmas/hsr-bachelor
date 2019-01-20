package compareAndLambda;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		Stream.generate(random::nextInt);
		//.forEach(System.out::println);
		
		OptionalDouble x = IntStream.iterate(0, i -> i + 1)
		.limit(1000)
		.average();
		
		System.out.println(x);
		
		//Person[] array = peopleStream.toaray(Person[]::new);
		//List<Person> list = peopleStream.collect(Collector.toList());
	}

}
