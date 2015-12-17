package graphics;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelMain extends JPanel{

	private static final long serialVersionUID = 1L;
	private PanelTree panelTree;
	
	public PanelMain(){
		setLayout(new BorderLayout());
		
		PanelControl panelControl = new PanelControl();
		add(panelControl, BorderLayout.NORTH);
		
		panelTree = new PanelTree();
		add(panelTree, BorderLayout.WEST);
		JScrollPane scrollPane = new JScrollPane(panelTree);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.WEST);
		
		JPanel panelMap = new JPanel();
		panelMap.setLayout(new BorderLayout());
		panelMap.add(new PanelMap(), BorderLayout.CENTER);
		add(panelMap, BorderLayout.CENTER);
	}
	
	public PanelTree getPanelTree(){
		return panelTree;
	}
}
