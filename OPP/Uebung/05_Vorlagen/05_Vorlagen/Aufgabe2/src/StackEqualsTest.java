
public class StackEqualsTest {
	public static void main(String[] args) {
		testStackEquals();
		testStackUnequals();
	}

	private static void testStackEquals() {
		var first = createStack();
		var second = createStack();
		System.out.println("Correct stack equals?" + first.equals(second));
		System.out.println("Commutative stack equals? " + second.equals(first));
		System.out.println("Symmetric stack equals? " + first.equals(first));
		System.out.println("Correct hash code? " + (first.hashCode() == second.hashCode()));
	}

	private static void testStackUnequals() {
		Stack first = createStack();
		Stack second = createStack();
		second.pop();
		System.out.println("Correct stack unequals? " + !first.equals(second));
		System.out.println("Commutative stack unequals? " + !second.equals(first));
	}


	
	private static Stack createStack() {
		final int capacity = 10;
		var stack = new Stack(capacity * 2);
		for (int i = 0; i < capacity; i++) {
			stack.push("Item " + i);
		}
		return stack;
	}
	

}
