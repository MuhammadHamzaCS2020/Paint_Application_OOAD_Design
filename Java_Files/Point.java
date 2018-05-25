import java.io.Serializable;

public class Point implements Serializable{

	private int x;
	private int y;

	public Point(int a, int b){
		x = a;
		y = b;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
