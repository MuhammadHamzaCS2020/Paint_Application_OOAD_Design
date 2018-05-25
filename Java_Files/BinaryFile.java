
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BinaryFile implements Serializable,SaveType{

	@Override
	public void Save(MyPanel drawingPanel) {
		///System.out.println("Hi i am Binary file");
		System.out.println(drawingPanel.shapes.size());
		try {
			File file=new File("Binary_File.dat");
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(drawingPanel.shapes);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void Load(MyPanel Panel) {
		try {
			File file1=new File("Binary_File.dat");
			FileInputStream fos=new FileInputStream(file1);
			ObjectInputStream oos=new ObjectInputStream(fos);
			Panel.shapes=(ArrayList<Shape>)(oos.readObject());
			
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	
}
