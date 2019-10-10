package editor;

import org.eclipse.swt.widgets.Button;
import java.awt.Event;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.View;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.FileDialog;


public class TextView extends ViewPart {
	
	public static final String ID = TextView.class.getCanonicalName();	
	private String readed;

	@Override
	public void createPartControl(Composite parent) {
		
		/*Text text = new Text(parent, 0);
        text.setText("Imagine a fantastic user interface here");*/
		//Text text = new Text(parent,0);
		GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);
		Text textfile= new Text(parent, SWT.MULTI |SWT.BORDER);   
		textfile.setLayoutData(new GridData(SWT.FILL,SWT.FILL, true, true));
		textfile.setText(readed + "\n");
		
		Button review= new Button(parent, SWT.PUSH);
		review.setText("Обзор");        
		review.setLayoutData(new GridData(SWT.NONE, SWT.CENTER, false, false));
		review.addSelectionListener(new SelectionAdapter() {

		    public void widgetSelected (SelectionEvent e) {
		    	
		    	//readFile(parent, textfile);		
		    }});                       
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public void getText(String readed, ExecutionEvent event) {	
		this.readed = readed;
		//MessageDialog.openInformation(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), "Info", readed + "\n");
		/*Text text = new Text(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.NONE);
		text.setText(readed);*/			
	}
	
	void readFile(Composite parent, Text textfile) {
		
	FileDialog dlg = new FileDialog(parent.getShell(), SWT.OPEN);
    String fname = dlg.open();
    if(fname != null) {
    try (BufferedReader br = new BufferedReader(new FileReader(fname));) {			    		
			String readed;
			while((readed = br.readLine()) != null) {				              
				
			    	   textfile.setText(readed + "\n");		    		
			    	}				               
	            } catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		          		    			       
    };}
}
