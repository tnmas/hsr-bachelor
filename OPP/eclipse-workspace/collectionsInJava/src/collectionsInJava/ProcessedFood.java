package collectionsInJava;

import java.util.ArrayList;
import java.util.List;

public class ProcessedFood extends Food {
	public ProcessedFood(String name) {
		super(name);
	}

	private List<Food> ingredients = new ArrayList<>();
	public void setIngredients(List<Food> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int getCalories() {
		int calories = 0;
		
		for (Food food : ingredients) {
			calories += food.getCalories();
		}
		return calories;
	}

	@Override
	public String toString(int indent) {
		String text = getIndent(indent) + getName() + " (" + getCalories() + " Kalorien)\n";
		for (Food food : ingredients) {
			text += food.toString(indent + 1);
		}
		return text;
	}
}
