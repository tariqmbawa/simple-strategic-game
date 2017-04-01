import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	
	
	private DetailsPanel detailsPanel;
	
	public MainFrame(String title) {
		super(title);
		
		// set layout manager
		
		setLayout (new BorderLayout());
		
		//Create Swing Components
		
		final JTextArea mainOutputTextArea = new JTextArea();
		JButton helloButton = new JButton("Click Me");
		helloButton.setBackground(Color.BLACK);
	    helloButton.setForeground(Color.GRAY);
		
		detailsPanel = new DetailsPanel();
		
		detailsPanel.addDetailListener(new DetailListener(){
			
			public void detailEventOccured(DetailEvent event) {
				
				String text = event.getText();
				
				mainOutputTextArea.append(text);
				
			}
		}); 
		
		//Add Swing Components to content pane
		
		Container c = getContentPane();
		
		c.add(mainOutputTextArea, BorderLayout.CENTER);
		c.add(helloButton, BorderLayout.SOUTH);
		c.add(detailsPanel, BorderLayout.WEST);
		
		
		
		//Add Behaviour	
		helloButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainOutputTextArea.append("Hello\n");
				
			}
			
		});
	}
}
