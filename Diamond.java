import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Diamond extends Shape{

	private int height = 40;
	private Polygon diamond,diamond1;
	public Diamond(Point clickPoint) {
		super(clickPoint);
	}
	public String Coordinates() {
		String str=null;
		str=""+'D' +" "+this.height+" "+this.getVertexPoint().getX()+" "+this.getVertexPoint().getY();
		return str;
	}
	@Override
	public void draw(Graphics g){
		g.setColor(Color.white);
		int x = getVertexPoint().getX();
		int y = getVertexPoint().getY();

		int[] xCoords = {x,x-(height/2),x+(height/2)};
		int[] yCoords = {y, y+height, y+height};
		diamond = new Polygon(xCoords, yCoords, 3);
		g.fillPolygon(diamond);


		int[] x1Coords = {x, x-(height/2),x+(height/2)};
		int[] y1Coords = {y+80, y+(height), y+(height)};
		diamond1 = new Polygon(x1Coords, y1Coords, 3);
		g.fillPolygon(diamond1);
	}

	public boolean Delete(Point click) {
		boolean flage1=diamond.contains(click.getX(), click.getY());
		boolean flage2=diamond1.contains(click.getX(), click.getY());
		if(flage1==true || flage2==true) {
			return true;
		}
		return false;
	}
}
