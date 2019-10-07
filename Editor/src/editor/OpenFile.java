package editor;

import java.io.FileInputStream;
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

public class OpenFile extends AbstractHandler implements IHandler {		

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		FileDialog dlg = new FileDialog(HandlerUtil.getActiveShell(event), SWT.OPEN);
	    String fname = dlg.open();	    
	    
	    if(fname != null) {
	    	try (FileInputStream file = new FileInputStream(fname);) {
	    		
				byte [] buffer = new byte[55];				
				int readed;
				while((readed = file.read(buffer))!=-1){
		              
		                System.out.print(buffer.toString());		                
		            }		            
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}			    
		return null;
	}
}
