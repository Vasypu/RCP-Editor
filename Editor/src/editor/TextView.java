package editor;

import org.eclipse.swt.widgets.Button;
import java.awt.Event;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.View;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.FileDialog;


public class TextView extends ViewPart {
	
	public static final String ID = "Editor.view1";
	
	public Text text;
	Shell parent;
	
	@Override
	public void createPartControl(Composite parent) {
		
		//parent.getShell();
		this.parent = parent.getShell();
		
		/*Text text = new Text(parent, 0);
        text.setText("Imagine a fantastic user interface here");*/		
		GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);
		text = new Text(parent, SWT.MULTI |SWT.BORDER |SWT.WRAP);   
		text.setLayoutData(new GridData(SWT.FILL,SWT.FILL, true, true));		
				
		/*Button review= new Button(parent, SWT.PUSH);
		review.setText("Обзор");        
		review.setLayoutData(new GridData(SWT.NONE, SWT.CENTER, false, false));
		review.addSelectionListener(new SelectionAdapter() {

		    public void widgetSelected (SelectionEvent e) {
		    	
		    	//readFile(parent, textfile);
		    	
		    }});   */           	         	
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}	
	
	public void setTitle(String s)
	{
		setPartName(s);
	}
	
	public void readFile() {
		FileDialog dlg = new FileDialog(parent, SWT.OPEN);	
	    String fname = dlg.open();
	    if(fname != null) {
	    try (BufferedReader br = new BufferedReader(new FileReader(fname));) {			    		
				String readed;
				ArrayList<String> read = new ArrayList<String>();
				while((readed = br.readLine()) != null) {	
					
							read.add(readed + "\n");
				    	   text.setText(read.toString().replaceAll("^\\[|\\]$", "").replace(",", ""));		    	   
				    	}				               
		            } catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		          		    			       
	    };
	}
}
