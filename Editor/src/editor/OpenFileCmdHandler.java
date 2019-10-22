package editor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
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
			//Shell shell = new Shell();
			int style = SWT.ERROR | SWT.OK | SWT.CANCEL;
			MessageBox messageBox = new MessageBox (HandlerUtil.getActiveShell(event), style);
			messageBox.setText ("Ошибка");
			messageBox.setMessage (e.getMessage());				
		}	    
		return null;
	}
}