import java.util.Arrays;
import java.util.Random;

public class SortBenchmark {
	private static final int NOF_ELEMENTS = 1_000_000;

	public void measureQuicksort() {
		var array = getTestArray();
		long start = System.nanoTime();
		// TODO: Call your quicksort implementation
		long end = System.nanoTime();
		System.out.println("Quicksort: " + (end - start) / 1000_000 + " ms");
		checkSorted(array);
	}

	public void measureJavaSort() {
		var array = getTestArray();
		long start = System.nanoTime();
		Arrays.sort(array);
		long end = System.nanoTime();
		System.out.println("Java Arrays.sort: " + (end - start) / 1000_000 + " ms");
		checkSorted(array);
	}

	public void measureTreeSetSort() {
		var array = getTestArray();
		long start = System.nanoTime();
		// TODO: sort using TreeSet
		long end = System.nanoTime();
		System.out.println("TreeSet sort: " + (end - start) / 1000_000 + " ms");
		checkSorted(array);
	}

	private void measureParallelStreamSort() {
		var array = getTestArray();
		long start = System.nanoTime();
		// TODO: sort using Parallel Stream API
		long end = System.nanoTime();
		System.out.println("Parallel Stream API sort: " + (end - start) / 1000_000 + " ms");
		checkSorted(array);
	}

	public void measureBubbleSort() {
		var array = getTestArray();
		long start = System.nanoTime();
		// TODO: call your bubble sort implementation
		long end = System.nanoTime();
		System.out.println("Bubble sort: " + (end - start) / 1000_000 + " ms");
		checkSorted(array);
	}

	private long[] getTestArray() {
		var random = new Random(4711); // arbitrary but reproducible seed
		long[] array = new long[NOF_ELEMENTS];
		for (int i = 0; i < NOF_ELEMENTS; i++) {
			array[i] = random.nextLong();
		}
		return array;
	}

	private void checkSorted(long[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				throw new AssertionError("not sorted");
			}
		}
	}

	public static void main(String[] args) {
		var benchmark = new SortBenchmark();
		benchmark.measureQuicksort();
		benchmark.measureJavaSort();
		benchmark.measureTreeSetSort();
		benchmark.measureParallelStreamSort();
		benchmark.measureBubbleSort();
	}
}
