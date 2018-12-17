package exercise06_template1to4;

public class Rectangle implements Shape{
	private final int color;
	private int left, top, width, height;
	
	public Rectangle(int left, int top, int width, int height, int color) {
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getX() {
		return left;
	}
	
	public int getY() {
		return top;
	}
	
	public void move(int deltaX, int deltaY) {
		left += deltaX;
		top += deltaY;
	}
	
	public int getAreaColor() {
		return color;
	}
	
	

}
