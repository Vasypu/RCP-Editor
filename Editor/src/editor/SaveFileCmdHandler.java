package editor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

public class SaveFileCmdHandler extends AbstractHandler implements IHandler {	

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		
		TextView v;
		try {
			v = (TextView) HandlerUtil.getActiveWorkbenchWindow(event).
					getActivePage().showView(TextView.ID);
			v.saveFile();
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
	}
}
