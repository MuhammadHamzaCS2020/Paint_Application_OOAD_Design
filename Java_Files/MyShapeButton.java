import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

// A JToggleButton is a special type of JButton 
// When clicked it remains pressed, while a normal 
// JButton is immediately released. Since I want a 
// shape to remain selected until user selects 
// another shape, I use JToggleButton

public class MyShapeButton extends JToggleButton{

	
	public MyShapeButton(String imageFileName) {
		setIcon(new ImageIcon(imageFileName)); // Sets icon on button
		setBorderPainted(false);
		setFocusPainted(false);
	}
}
