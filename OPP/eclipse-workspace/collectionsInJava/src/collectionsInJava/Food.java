package collectionsInJava;

public abstract class Food {
	private String name;
	public abstract int getCalories();
	public Food(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String toString(int indent);
	
	@Override 
	public String toString() {
		return toString(0);
	}
	
	protected String getIndent(int length) {
		String text = "";
		
		for (int i = 0; i < length; i++) {
			text += " ";
		}
		return text;
	}
}

