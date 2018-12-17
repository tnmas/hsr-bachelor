
public class StackTest {
	public static void main(String[] args) {
		testLIFO();
		testGrowShrinkGrow();
		testEmptyStack();
	}
	
	private static void testLIFO() {
		final int capacity = 10;
		var stack = new Stack(capacity);
		System.out.println("correct initial stack size? " + (stack.size() == 0));
		for (int i = 0; i < capacity; i++) {
			stack.push("item" + i);
			System.out.println("correct increased stack size? " + (stack.size() == i + 1));
		}
		System.out.println("Correct full check? " + stack.isFull());
		for (int i = capacity - 1; i >= 0; i--) {
			String value = stack.pop();
			System.out.println("correct item removed from stack? " + value.equals("item" + i));
			System.out.println("correct decreased stack size? " + (stack.size() == i));
		}
		System.out.println("Correct empty check? " + stack.isEmpty());
	}
	
	private static void testGrowShrinkGrow() {
		var stack = new Stack(5);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.pop();
		stack.pop();
		stack.push("D");
		System.out.println("correct stack size? " + (stack.size() == 2));
		System.out.println("last element correct? " + (stack.pop().equals("D")));
		System.out.println("first element correct? " + (stack.pop().equals("A")));
		System.out.println("stack finally empty? " + stack.isEmpty());
	}

	private static void testEmptyStack() {
		var stack = new Stack(0);
		System.out.println("Correct stack size? " + (stack.size() == 0));
		System.out.println("Empty stack is indeed empty? " + stack.isEmpty());
		System.out.println("Zero-capacity stack is full? " + stack.isFull());
		System.out.println("Correct stack underflow handling? " + (stack.pop() == null));
	}
}
