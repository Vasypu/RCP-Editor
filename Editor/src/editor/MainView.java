package editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.o7planning.tutorial.rcp.cmd.AboutCommand;

public class MainView extends ViewPart {
	
	public static final String ID = MainView.class.getCanonicalName();

	public MainView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Text text = new Text(parent, SWT.BORDER);
        text.setText("Imagine a fantastic user interface here");
        AboutCommand command = new AboutCommand();
        
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public static void getText(String s) {
		Text text = new Text (null, SWT.BORDER);
		text.setText(s);
	}

}
