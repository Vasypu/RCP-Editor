package org.o7planning.tutorial.rcp.cmd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.dialogs.AboutDialog;

import editor.MainView;

public class AboutCommand extends AbstractHandler implements IHandler {
	
		

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		
		//Display display = new Display ();
		
		
	    //Shell shell = new Shell (Display.getDefault());		    
		
		long handle = 0;
		FileDialog dlg = new FileDialog(Shell.gtk_new(Display.getDefault(), handle), SWT.OPEN);
	    String fname = dlg.open();
	    //System.out.println(HandlerUtil.getActiveShell(event));
	    
	    Text text = new Text(dlg.getParent(), SWT.NONE);
	    text.setText(dlg.getParent().getText().toString());
	    System.out.print(dlg.getParent().getText().toString());
	    
	    if(fname != null) {
	 	   System.out.println(dlg.getText());		    		
	 	}
	    try {
			FileReader file = new FileReader(fname);
			char [] buffer = new char[55];
			
			 int i=-1;
	            while((i=file.read())!=-1){
	              
	                //System.out.print((char)i);
	                MainView.getText((char)i); 
	            } 
	            /*int readed;
				while((readed = file.read(buffer)) != -1) {
										
	} */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*shell.pack ();
	    shell.open ();*/

	    /*while (!shell.isDisposed ()) {
	        if (!display.readAndDispatch ()) 
	            display.sleep ();
	    }
	    display.dispose ();*/
		//System.out.println("Кнопка Open работает");
	    
		return null;
	}

}
