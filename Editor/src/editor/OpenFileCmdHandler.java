package editor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
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
