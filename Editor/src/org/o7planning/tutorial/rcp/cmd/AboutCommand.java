package org.o7planning.tutorial.rcp.cmd;

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

public class AboutCommand extends AbstractHandler implements IHandler {
	
		

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		
		//Display display = new Display ();
		
		
	    //Shell shell = new Shell (Display.getDefault());		    
		
		long handle = 0;
		FileDialog dlg = new FileDialog(Shell.gtk_new(Display.getDefault(), handle), SWT.OPEN);
	    String fname = dlg.open();
	    System.out.println(HandlerUtil.getActiveShell(event));
	    
	    Text text = new Text(dlg.getParent(), SWT.NONE);
	    text.setText(dlg.getParent().getText().toString());
	    System.out.print(dlg.getText());
	     
	    if(fname != null) {
	 	   System.out.println();		    		
	 	}
		
		/*shell.pack ();
	    shell.open ();*/

	    /*while (!shell.isDisposed ()) {
	        if (!display.readAndDispatch ()) 
	            display.sleep ();
	    }
	    display.dispose ();*/
		System.out.println("Кнопка Open работает");
	    
		return null;
	}

}
