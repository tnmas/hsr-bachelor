package exercise06_template1to4;

public class TextBox extends Rectangle implements Text{
	
	private final String text;
	private int textColor;
	
	public TextBox(int left, int top, int width, int height, int areaColor, String text, int textColor) {
		super(left, top, width, height, areaColor);
		this.text = text;
		this.textColor = textColor;
	}
	
	public String getText() {
		return text;
	}
	
	public int getTextColor() {
		return textColor;
	}

}
