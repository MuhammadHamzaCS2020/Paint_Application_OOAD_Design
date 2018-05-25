import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
//   Muhammad Hamza 
// 2016-UET-NML-CS-28
@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener, Serializable{

	MyShapeButton circleButton, rectangleButton,
	triangleButton,DiamondButton,DeleteButton,saveButton,loadButton;

	///	JButton ;
	MyPanel drawingPanel;
	Shape shape = null;

	// My Adding Objects
	private FactoryClass factory=null; 
	private SaveType SaveFileType=null;
	JRadioButtonMenuItem[] Saveloading=null;
	JRadioButtonMenuItem[] SaveFilling=null;
	String[] Filenames= {"Binary File","Image File","Text File"};



	@SuppressWarnings("unchecked")
	public MyFrame() {

		setTitle("Basic Shape Drawing");

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);

		circleButton = new MyShapeButton("Resources/circle.png");
		circleButton.setToolTipText("Draw a Circle");

		rectangleButton = new MyShapeButton("Resources/rectangle.png");
		rectangleButton.setToolTipText("Draw a Rectangle");

		triangleButton = new MyShapeButton("Resources/triangle.png");
		triangleButton.setToolTipText("Draw a Triangle");

		DiamondButton = new MyShapeButton("Resources/Diamond.png");
		DiamondButton.setToolTipText("Draw a Diamond");

		DeleteButton = new MyShapeButton("Resources/Delete.png");
		DeleteButton.setToolTipText("Delete a Shape");

		//saveButton
		saveButton=new MyShapeButton("Resources/save.png");
		saveButton.addActionListener(this);
		saveButton.setEnabled(true);
		saveButton.setToolTipText("save");
		// LoadButton 
		loadButton= new MyShapeButton("Resources/load.png");
		loadButton.addActionListener(this);
		loadButton.setEnabled(true);
		loadButton.setToolTipText("Load");


		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(circleButton);
		buttonGroup.add(rectangleButton);
		buttonGroup.add(triangleButton);
		buttonGroup.add(DiamondButton);
		buttonGroup.add(DeleteButton);
		buttonGroup.add(saveButton);
		buttonGroup.add(loadButton);

		toolBar.add(circleButton);
		toolBar.add(rectangleButton);
		toolBar.add(triangleButton);
		toolBar.add(DiamondButton);
		toolBar.add(DeleteButton);
		toolBar.add(saveButton);
		toolBar.add(loadButton);		

		JMenuBar jmb=new JMenuBar();

		JMenu file = new JMenu( "File" );
		JMenu setting = new JMenu( "Setting" );
		JMenu savefile = new JMenu( "Save File" );
		savefile.addActionListener(this);
		JMenu loadfile = new JMenu( "Load File" );
		savefile.addActionListener(this);

		int index=0;
		SaveFilling=new JRadioButtonMenuItem[Filenames.length];
		Saveloading=new JRadioButtonMenuItem[Filenames.length];
		for(int i=0; i<Filenames.length; i++) {
			SaveFilling[index]=new JRadioButtonMenuItem(Filenames[index],false);
			SaveFilling[index].addActionListener(this);
			savefile.add(SaveFilling[index]);
			Saveloading[index]=new JRadioButtonMenuItem(Filenames[index], false);
			Saveloading[index].addActionListener(this);
			loadfile.add(Saveloading[index]);
			index++;
		}

		setting.add(savefile);
		setting.add(loadfile);
		JMenuItem backgroundcolor=new JMenuItem("Background color");
		setting.add( backgroundcolor );
		setting.addActionListener(this);
		jmb.add(file);
		jmb.add(setting);

		this.add(jmb,BorderLayout.NORTH);
		add(toolBar, BorderLayout.SOUTH);

		drawingPanel = new MyPanel();
		drawingPanel.setBackground(Color.YELLOW);
		drawingPanel.addMouseListener(new MyMouseListener());
		add(drawingPanel, BorderLayout.CENTER);

		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	//	This is an inner class which implements the listener interface
	private class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Point clickPoint = new Point(e.getPoint().x, e.getPoint().y);
			if(circleButton.isSelected())
				shape = new Circle(clickPoint);
			if(triangleButton.isSelected())
				shape = new Triangle(clickPoint);
			if(rectangleButton.isSelected())
				shape = new Rectangle(clickPoint);
			if(DiamondButton.isSelected())
				shape = new Diamond(clickPoint);
			if(DeleteButton.isSelected()) 
				Remove(clickPoint);
			saveButton.setEnabled(true);
			if(shape!=null) {
				drawingPanel.addShape(shape);
				drawingPanel.repaint();
			}
		}

		@Override public void mousePressed(MouseEvent e) {}
		@Override public void mouseReleased(MouseEvent e) {}
		@Override public void mouseEntered(MouseEvent e) {}
		@Override public void mouseExited(MouseEvent e) {}
	}

	public static void main(String[] args) {
		System.out.println("Name: Muhammad Hamza");
		System.out.println("Reg No: 2016-UET-NML-CS-28");
		MyFrame obj=new MyFrame();		
	}

	@Override
	public void actionPerformed(ActionEvent arg) {

		if(arg.getSource()==saveButton) {
			if(factory!=null && SaveFileType!=null) {
				System.out.println("Hi");
				SaveFileType.Save(drawingPanel);
			}
		}else 
			if(arg.getSource()==loadButton){
				if(factory!=null && SaveFileType!=null) {
					SaveFileType.Load(drawingPanel);
				}
			}else {
				factory=FactoryClass.getSingltonObject();
				SaveFileType=factory.getObjectUsingFactoryPattern(arg);
			}
	}

	// Removing Function 
	void Remove(Point clickPoint) {
		boolean bool = false;
		if(drawingPanel.shapes.get(0)!=null) {
			for(int i=0; i<drawingPanel.shapes.size(); i++) {
				bool=drawingPanel.shapes.get(i).Delete(clickPoint);
				if(bool==true) {
					drawingPanel.shapes.remove(i);
				}
			}					
		}
		else {
			System.out.println("The List of Shape is Empty");
		}
	}

}







//Extra Code


//JRadioButtonMenuItem cb1 = new JRadioButtonMenuItem("Binary File", false);
//cb1.addActionListener(this);
//JRadioButtonMenuItem cb2 = new JRadioButtonMenuItem("Image File", false);
//cb2.addActionListener(this);
//JRadioButtonMenuItem cb3 = new JRadioButtonMenuItem("Text File",false);
//cb3.addActionListener(this);
//
//savefile.add(cb1);
//savefile.add(cb2);
//savefile.add(cb3);

//
//
//
//
//JRadioButtonMenuItem lbf = new JRadioButtonMenuItem("Binary File", false);
//lbf.addActionListener(this);
//JRadioButtonMenuItem limg = new JRadioButtonMenuItem("Image File", false);
//limg.addActionListener(this);
//JRadioButtonMenuItem ltf = new JRadioButtonMenuItem("Text File",false);
//ltf.addActionListener(this);
//
//loadfile.add(lbf);
//loadfile.add(limg);
//loadfile.add(ltf);















