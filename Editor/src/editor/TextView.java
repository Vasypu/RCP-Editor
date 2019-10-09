package editor;

import java.awt.Event;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.View;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ViewPart;


public class TextView extends ViewPart {
	
	public static final String ID = TextView.class.getCanonicalName();	

	@Override
	public void createPartControl(Composite parent) {
		
		/*Text text = new Text(parent, 0);
        text.setText("Imagine a fantastic user interface here");*/
		//Text text = new Text(parent,0);
		
                       
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public void getText(String readed, ExecutionEvent event) {			
		
		Text text = new Text(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.NONE);
		text.setText(readed);		
		
	}
}
