import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Rectangle extends Shape {

	private int width = 50;
	private int height = 30;
	public Rectangle(Point clickPoint) {
		super(clickPoint);
	}
	public String Coordinates() {
		String str=null;
		str=""+'R'+" "+this.getVertexPoint().getX()+" "+this.getVertexPoint().getY();
		return str;
	}
	@Override
	public void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(getVertexPoint().getX(),
				getVertexPoint().getY(), width, height);
	}
	
	public boolean Delete(Point click) {
		int x1=getVertexPoint().getX();
		int y1=getVertexPoint().getY();
		int x2 = x1 + width;
		int y2 = y1 + height;
		
		int clickX=click.getX();
		int clickY=click.getY();

		if( (clickX>=x1 && clickX<=x2)){
			if((clickY>=y1 && clickY<=y2)) {
				return true;
			}
		}
		return false;
		
	}
}
