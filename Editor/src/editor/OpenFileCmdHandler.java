package editor;

import java.io.BufferedReader;
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

public class OpenFileCmdHandler extends AbstractHandler implements IHandler {		

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		FileDialog dlg = new FileDialog(HandlerUtil.getActiveShell(event), SWT.OPEN);
	    String fname = dlg.open();	    
	    
	    if(fname != null) {
	    	try (BufferedReader br = new BufferedReader(new FileReader(fname));) {
	    		TextView view = new TextView();
				String readed;
				while((readed = br.readLine())!=null){
		              
		                System.out.print(readed + "\n");		                
		                view.getText(readed ,event);
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
