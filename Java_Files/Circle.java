import java.awt.Color;
import java.awt.Graphics;


public class Circle extends Shape {

	private int radius = 20;

	public Circle(Point clickPoint) {
		super(clickPoint);
	}

	public String Coordinates() {
		String str=null;
		str=""+'C' +" "+this.radius+" "+this.getVertexPoint().getX()+" "+this.getVertexPoint().getY();
		return str;
	}
	@Override
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(getVertexPoint().getX()-radius,
				getVertexPoint().getY()-radius, radius*2, radius*2);
	}

	public void LoadDraw(Graphics g,int x,int y) {
		g.setColor(Color.BLUE);
		g.fillOval(x-radius,y-radius, radius*2, radius*2);
		this.setVertexPoint(x, y);
	}
	public boolean Delete(Point click) {

		//		System.out.println(click.getX()+" I am in Delete Button "+click.getY());
		int CircleX=this.getVertexPoint().getX();
		int CircleY=this.getVertexPoint().getY();
		int DeleteX=click.getX();
		int DeleteY=click.getY();

		int temp1=(DeleteX)^2-(CircleX)^2;
		int temp2=(DeleteY)^2-(CircleY)^2;
		double temp3=Math.hypot(temp1, temp2);
		if(temp3<=this.radius) {
			return true;
		}
		return false;
	}
}
