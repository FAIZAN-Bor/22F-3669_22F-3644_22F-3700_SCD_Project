package EditorAppMain;

import java.io.FileNotFoundException;
import java.io.IOException;

import BLL.EditorBusinessLogic;
import DAL.AbstractClassDAOfactory;
import DAL.IEditordata;
import PD.EditorGUI;

public class ArabicEditorApp {
	
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
    	IEditordata data=AbstractClassDAOfactory.getInstance().geteditordata();
    	EditorBusinessLogic obj = new EditorBusinessLogic(data);
    	EditorGUI gui=new EditorGUI(obj);
    }
}
