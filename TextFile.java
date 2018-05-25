import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class TextFile implements  Serializable,SaveType{
	@Override
	public void Save(MyPanel drawingPanel) {
		try {
			String str =null; ///"SomeMoreTextIsHere";
			File TextFile = new File("Text_File.txt");
			FileWriter fw = new FileWriter(TextFile);
			for(int i=0; i<drawingPanel.shapes.size(); i++) {
				str=drawingPanel.shapes.get(i).Coordinates();
				fw.write(str);
				fw.write("\n");
			}
			fw.close();

		} catch (IOException iox) {
			//do stuff with exception
			iox.printStackTrace();
		}

	}

	@Override
	public void Load(MyPanel Panel) {
		Point pt=null;
		Shape parent=null;
		try {
			File TextFile = new File("Text_File.txt");
			BufferedReader fw = new BufferedReader(new FileReader(TextFile));
			String str=null;
			String[] Spliter=null;
			while ((str = fw.readLine()) != null) {

				System.out.println(str);
				Spliter=str.split("\\s+");
				System.out.println(Spliter[0]);
				
				if(Spliter[0].charAt(0)=='R') {
					pt=new Point(Integer.parseInt(Spliter[1]),
							Integer.parseInt(Spliter[2]));
					parent=new Rectangle(pt);
				}
				else {
					pt=new Point(Integer.parseInt(Spliter[2]),
							Integer.parseInt(Spliter[3]));
					if(Spliter[0].charAt(0)=='T' ) {
						parent=new Triangle(pt);
					}
					else if(Spliter[0].charAt(0)=='C') {
						parent=new Circle(pt);
					}
					else {
						parent=new Diamond(pt);
					}
				}
				Panel.addShape(parent);
			}
			fw.close();
		} catch (IOException iox) {
			//do stuff with exception
			iox.printStackTrace();
		}		
	}



}
