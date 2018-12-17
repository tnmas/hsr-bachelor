public class Test {
	public static void main(String[] args) {
		// Sample shows how to directly draw on the visualization board.
		// TODO: Replace this code by using instances of the Shape interface.
		var v = new Visualization();
		v.clear();
		v.drawRectangle(0, 0, 100, 100, 0x1f497d);
		v.drawCircle(100, 100, 40, 0xc0504d);
		v.drawText(100, 100, "Hello!", 0xffff00);
	}
}
