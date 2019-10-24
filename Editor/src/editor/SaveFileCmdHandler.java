package editor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.handlers.HandlerUtil;

public class SaveFileCmdHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub

		TextView v;
		v = (TextView) HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getActivePart();
		if (v == null) {
			int style = SWT.ERROR | SWT.OK | SWT.CANCEL;
			MessageBox messageBox = new MessageBox(HandlerUtil.getActiveShell(event), style);			
			messageBox.setText("Ошибка");
			messageBox.setMessage("Нет файла для сохранения!");
			messageBox.open();
		}
		else {
			v.saveFile();
		}
		return null;
	}
}