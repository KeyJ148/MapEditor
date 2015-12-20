package graphics;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Map;

public class DialogCreate extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String NAME = "Create";
	
	private Map map;
	private JLabel lblWidth, lblHeight;
	private JTextField tfWidth, tfHeight;
	private JButton buttonCreate;

	public DialogCreate(JFrame frame, Map map){
		super(frame, NAME, true);
		this.map = map;
		
		setResizable(false);
		
		Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
		int displayWidth = displaySize.width;
		int displayHeight = displaySize.height;
		int frameWidth = 150;
		int frameHeight = 130;
		setBounds(displayWidth/2-frameWidth/2, displayHeight/2-frameHeight/2, frameWidth, frameHeight);
		
		//Добавление компонентов
		Font font = new Font(null, Font.PLAIN, 17);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		lblWidth = new JLabel("Width: ");
		lblWidth.setFont(font);
		lblWidth.setBounds(frameWidth/2-60, frameHeight/10, 100, 25);
		panel.add(lblWidth);
		
		tfWidth = new JTextField();
		tfWidth.setBounds(frameWidth/2, frameHeight/10, 50, 25);
		panel.add(tfWidth);
		
		lblHeight = new JLabel("Height: ");
		lblHeight.setFont(font);
		lblHeight.setBounds(frameWidth/2-60, frameHeight/3, 100, 25);
		panel.add(lblHeight);
		
		tfHeight = new JTextField();
		tfHeight.setBounds(frameWidth/2, frameHeight/3, 50, 25);
		panel.add(tfHeight);
		
		buttonCreate = new JButton();
		buttonCreate.setBounds(frameWidth/4, frameHeight/3+25+5, frameWidth/2, 25);
		buttonCreate.setText("Create");
		buttonCreate.addActionListener(this);
		panel.add(buttonCreate);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonCreate)) actionCreate();
	}
	
	private void actionCreate(){
		map.continuedCreate(Integer.parseInt(tfWidth.getText()), Integer.parseInt(tfHeight.getText()));
		dispose();
	}
	
}
