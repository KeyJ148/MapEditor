package graphics;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelMain extends JPanel{

	private static final long serialVersionUID = 1L;
	private PanelControl panelControl;
	private PanelTree panelTree;
	private PanelMap panelMap;
	
	public PanelMain(){
		setLayout(new BorderLayout());
		
		panelControl = new PanelControl();
		add(panelControl, BorderLayout.NORTH);
		
		panelTree = new PanelTree();
		add(panelTree, BorderLayout.WEST);
		JScrollPane scrollPane = new JScrollPane(panelTree);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(32);
		add(scrollPane, BorderLayout.WEST);
		
		JPanel panelMapOut = new JPanel();
		panelMapOut.setLayout(new BorderLayout());
		panelMap = new PanelMap();
		panelMapOut.add(panelMap, BorderLayout.CENTER);
		add(panelMapOut, BorderLayout.CENTER);
	}
	
	public PanelControl getPanelControl() {
		return panelControl;
	}
	
	public PanelTree getPanelTree(){
		return panelTree;
	}
	
	public PanelMap getPanelMap() {
		return panelMap;
	}
}
