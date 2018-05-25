import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Triangle extends Shape{

	private int height = 40;
	private Polygon triangle;
	public Triangle() {
		super();
	}
	public Triangle(Point clickPoint) {
		super(clickPoint);
	}

	public String Coordinates() {
		String str=null;
		str=""+'T' +" "+this.height+" "+this.getVertexPoint().getX()+" "+
				this.getVertexPoint().getY();
		return str;
	}
	@Override
	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		int x = getVertexPoint().getX();
		int y = getVertexPoint().getY();
		int[] xCoords = {x, x-(height/2),x+(height/2)};
		int[] yCoords = {y, y+height, y+height};
		triangle = new Polygon(xCoords, yCoords, 3);
		g.fillPolygon(triangle);
	}
	
	public void LoadDraw(Graphics g,int x,int y) {
		
	}
	
	public boolean Delete(Point click) {	
		boolean flage=triangle.contains(click.getX(), click.getY());
		return flage;

	}
}
