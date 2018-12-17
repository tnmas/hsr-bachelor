//import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;

public class Stack {
	private int top;
	private final String[] stack;
	public Stack(int capacity) {
		stack = new String[capacity];
	}
	
	public void push(String element) {
		if(top < stack.length) {
			stack[top++] = element;
		}
		else {
			System.out.println("Stack full");
		}
		
	}
	public int size() {
		return top;
	}
	public boolean isFull() {
		return stack.length == top;
	}
	public boolean isEmpty() {
		return top == 0;
	}
	public String pop() {
		
		if(isEmpty()) {
			return null;
		}
		String element = stack[--top];
		stack[top] = null;
		return element;
	}
}
