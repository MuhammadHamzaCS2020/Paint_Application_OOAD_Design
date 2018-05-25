import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Serializable{

	ArrayList<Shape> shapes = new ArrayList<>();

	public void addShape(Shape s){
		shapes.add(s);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(Shape s: shapes)
			s.draw(g); // polymorphic call
	}
}
