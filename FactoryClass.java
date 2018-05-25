import java.awt.event.ActionEvent;

public class FactoryClass {
	private SaveType filetype=null;
	private static FactoryClass FactoryReference=null;
	private FactoryClass() {

	}
	public static FactoryClass getSingltonObject() {
		if(FactoryReference==null) {
			FactoryReference=new FactoryClass();
		}
		return FactoryReference;
	}
	public SaveType getObjectUsingFactoryPattern(ActionEvent arg) {

		if(arg.getActionCommand()=="Text File") {
			filetype=new TextFile();
		}else 
			if(arg.getActionCommand()=="Binary File") {
				filetype=new BinaryFile();
			}else 
				if(arg.getActionCommand()=="Image File") {
					filetype=new ImageFile();
				}
		return filetype;
	}

}
