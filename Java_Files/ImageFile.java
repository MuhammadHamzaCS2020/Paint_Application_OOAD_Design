import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class ImageFile implements  Serializable,SaveType{

	@Override
	public void Save(MyPanel Panel) {
		BufferedImage Image = new BufferedImage(Panel.getWidth(),Panel.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = Image.getGraphics();
		Panel.paint(g);
		try {
			ImageIO.write(Image, "PNG", new File("Image_File.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Load(MyPanel drawingPanel) {
		
	}

}
