package editor;

import java.awt.Event;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ViewPart;


public class TextView extends ViewPart {
	
	public static final String ID = TextView.class.getCanonicalName();
	
	String readed;
	ExecutionEvent event;

	public TextView(/*String readed*/) {
		//this.readed = readed;
	}

	@Override
	public void createPartControl(Composite parent) {
		/*try {
			HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Text text;
		try {
			text = new Text((Composite) HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(ID), SWT.BORDER);
			text.setText(readed + "\n"); 
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //text.setText("Imagine a fantastic user interface here");
		
                       
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public void getText(String readed, ExecutionEvent event) {
		this.event = event;
		this.readed = readed;
	}


}
