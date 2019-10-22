package editor;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;


public class TextView extends ViewPart {
	
	public static final String ID = "Editor.view1";	
	public Text text;
	Shell parent;
	
	@Override
	public void createPartControl(Composite parent) {
		
		this.parent = parent.getShell();			
		GridLayout gridLayout = new GridLayout();
		parent.setLayout(gridLayout);		
		text = new Text(parent, SWT.MULTI |SWT.BORDER |SWT.WRAP |SWT.V_SCROLL);   
		text.setLayoutData(new GridData(SWT.FILL,SWT.FILL, true, true));					
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}		
	public void setTitle(String s)
	{
		setPartName(s);
	}	
	public void readFile() {
		FileDialog dlg = new FileDialog(parent, SWT.OPEN);	
	    String fname = dlg.open();
	    if(fname != null) {
	    try (BufferedReader br = new BufferedReader(new FileReader(fname));) {		
	    		StringBuffer stringBuffer = new StringBuffer();	 	    		
				String readed;				
				while((readed = br.readLine()) != null) {						
							
							stringBuffer.append(readed + "\n");
							text.setText(stringBuffer + "\n");
				    	}				               
		            } catch (FileNotFoundException e1) {
		            	//Shell shell = new Shell();
		    			int style = SWT.ERROR | SWT.OK | SWT.CANCEL;
		    			MessageBox messageBox = new MessageBox (parent, style);
		    			messageBox.setText ("Ошибка");
		    			messageBox.setMessage (e1.getMessage());
					} catch (IOException e1) {
						//Shell shell = new Shell();
						int style = SWT.ERROR | SWT.OK | SWT.CANCEL;
						MessageBox messageBox = new MessageBox (parent, style);
						messageBox.setText ("Ошибка");
						messageBox.setMessage (e1.getMessage());
					}		          		    			       
	    };
	}
	
	public void saveFile() {
		
		FileDialog dlg = new FileDialog(parent, SWT.SAVE);		
		String fname = dlg.open();
		if (fname != null) {
			
			String write = text.getText();
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(fname)))
			{
				bw.write(write);
			}
			catch(IOException ex){
            
				System.out.println(ex.getMessage());
			}
		}
	}
}
