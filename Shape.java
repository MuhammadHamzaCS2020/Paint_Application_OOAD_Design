import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable{

	private Point vertexPoint;

	public Shape(Point clickPoint){
		vertexPoint = clickPoint;
	}

	public Shape() {
		// TODO Auto-generated constructor stub
	}

	public Point getVertexPoint(){
		return vertexPoint;
	}
	public void setVertexPoint(int x,int y){
		this.vertexPoint.setX(x);
		this.vertexPoint.setY(y);
	}
	public abstract boolean Delete(Point click); 
	public abstract void draw(Graphics g);
	public abstract String Coordinates();

}
