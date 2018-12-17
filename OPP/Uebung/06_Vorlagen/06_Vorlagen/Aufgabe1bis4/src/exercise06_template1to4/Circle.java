package exercise06_template1to4;

public class Circle implements Shape{
	private final int radius, color;
	private int centerX, centerY; 
	
	public Circle(int centerX, int centerY, int radius, int color) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.color = color;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getX() {
		return centerX;		
	}
	
	public int getY() {
		return centerY;
	}
	
	public void move(int deltaX, int deltaY) {
		centerX += deltaX;
		centerY += deltaY;
	}
	
	public int getAreaColor() {
		return color;
	}
}
