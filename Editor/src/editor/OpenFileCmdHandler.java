package editor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenFileCmdHandler extends AbstractHandler implements IHandler {		

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {	
		HandlerUtil.getActiveShell(event);
		
		TextView v;
		try {
			v = (TextView) HandlerUtil.getActiveWorkbenchWindow(event).
					getActivePage().showView(TextView.ID);
			v.readFile();
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    		
	    
		return null;
	}
}
