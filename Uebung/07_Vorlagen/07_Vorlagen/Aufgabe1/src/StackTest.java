
public class StackTest {
	public static void main(String[] args) {
		testInvalidCapacity();
		testStackOverflow();
		testStackUnderflow();
		testStackNullPush();
		testLIFO();
		testGrowShrinkGrow();
		testEmptyStack();
		System.out.println("All tests passed!");
	}
	
	private static void testStackNullPush() {
		var stack = new Stack(1);
		stack.push(null); // TODO: Check that null pushes fails with IllegalArgumentException
		stack.push("A");
		check(stack.pop().equals("A"), "Stack corrupted after underflow");
	}

	private static void testInvalidCapacity() {
		new Stack(-1); // TODO: Check that this fails with IllegalArgumentException
		new Stack(65536 + 1); // TODO: Check that this fails with IllegalArgumentException
	}
	
	private static void testStackOverflow() {
		var stack = new Stack(1);
		stack.push("A");
		stack.push("Too much"); // TODO: Check that this fails with StackOverflowException
		check(stack.pop().equals("A"), "Stack corrupted after overflow");
	}
	
	private static void testStackUnderflow() {
		var stack = new Stack(1);
		stack.pop(); // TODO: Check that this fails with StackUnderflowException
		stack.push("A");
		check(stack.pop().equals("A"), "Stack corrupted after underflow");
	}

	private static void testLIFO() {
		final int capacity = 10;
		var stack = new Stack(capacity);
		check(stack.size() == 0, "initial stack size is not zero");
		for (int i = 0; i < capacity; i++) {
			stack.push("item" + i);
			check(stack.size() == i + 1, "stack size not properly increased");
		}
		check(stack.isFull(), "Incorrect full check");
		for (int i = capacity - 1; i >= 0; i--) {
			String value = stack.pop();
			check(value.equals("item" + i), "wrong item removed from stack");
			check(stack.size() == i, "stack size not properly decreased");
		}
		check(stack.isEmpty(), "Incorrect empty check");
	}
	
	private static void testGrowShrinkGrow() {
		var stack = new Stack(5);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.pop();
		stack.pop();
		stack.push("D");
		check(stack.size() == 2, "incorrect stack size");
		check(stack.pop().equals("D"), "incorrect last element");
		check(stack.pop().equals("A"), "incorrect first element");
		check(stack.isEmpty(), "stack not empty at the end");
	}

	private static void testEmptyStack() {
		var stack = new Stack(0);
		check(stack.size() == 0, "Incorrect stack size");
		check(stack.isEmpty(), "Empty stack is not empty");
		check(stack.isFull(), "Zero-capacity stack is not full");
	}
	
	private static void check(boolean condition, String description) {
		if (!condition) {
			throw new AssertionError("Test failed: " + description);
		}
	}
}
