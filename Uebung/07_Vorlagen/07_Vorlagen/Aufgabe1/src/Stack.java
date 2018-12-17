// TODO: Introduce exception handling
public class Stack {
	private final String[] elements;
	private int position;
	
	public Stack(int capacity) {
		elements = new String[capacity];
	}
	
	public void push(String element) {
		if (position < elements.length) {
			elements[position++] = element;
		} else {
			System.err.println("stack overflow");
		}
	}
	
	public String pop() {
		if (position == 0) {
			System.err.println("stack underflow");
			return null;
		}
		String element = elements[--position];
		elements[position] = null;
		return element;
	}
	
	public int size() {
		return position;
	}
	
	public boolean isEmpty() {
		return position == 0;
	}
	
	public boolean isFull() {
		return position == elements.length;
	}
}
