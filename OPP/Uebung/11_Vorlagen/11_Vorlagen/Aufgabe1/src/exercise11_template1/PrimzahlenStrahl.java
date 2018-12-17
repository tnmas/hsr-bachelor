package exercise11_template1;

import java.util.stream.Stream;

public class PrimzahlenStrahl {
	
	public static void main(String[] args) {
		
		Stream.iterate(1, i -> i + 1)
		.filter(i -> i % 2 != 0)
		.limit(1000000)
		.forEach(System.out::println);
		
		
		//a) Was ist die 1‘000‘000te Primzahl?  => 1999999
		//b) Wie viele Primzahlen gibt es zwischen 2 und 1‘000‘000?
		
	}

}
