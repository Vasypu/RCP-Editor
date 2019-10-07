package editor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;


public class MainView extends ViewPart {
	
	public static final String ID = MainView.class.getCanonicalName();
	
	String readed;

	public MainView(/*String readed*/) {
		//this.readed = readed;
	}

	@Override
	public void createPartControl(Composite parent) {
		
		Text text = new Text(parent, SWT.BORDER);
        //text.setText("Imagine a fantastic user interface here");
        text.setText(readed + "\n");                
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public void getText(String readed) {
		this.readed = readed;
	}


}
