package gui.menu;

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

import gui.FrameMain;
import gui.map.Grid;

public class DialogGrid extends JDialog implements ActionListener {

    private static final String NAME = "Grid";

    private JLabel lblWidth, lblHeight, lblIndentWidth, lblIndentHeight;
    private JTextField tfWidth, tfHeight, tfIndentWidth, tfIndentHeight;
    private JButton buttonSave;

    public DialogGrid(JFrame frame){
        super(frame, NAME, true);

        setResizable(false);

        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        int displayWidth = displaySize.width;
        int displayHeight = displaySize.height;
        int frameWidth = 220;
        int frameHeight = 220;
        setBounds(displayWidth/2-frameWidth/2, displayHeight/2-frameHeight/2, frameWidth, frameHeight);

        //Добавление компонентов
        Grid grid = FrameMain.getInstance().getPanelMain().getPanelMap().getGrid();
        Font font = new Font(null, Font.PLAIN, 17);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        //Размер сетки
        lblWidth = new JLabel("Width: ");
        lblWidth.setFont(font);
        lblWidth.setBounds(frameWidth/2-100, 25, 200, 25);
        panel.add(lblWidth);

        tfWidth = new JTextField();
        tfWidth.setText(String.valueOf(grid.getWidth()));
        tfWidth.setBounds(frameWidth/2+30, 25, 50, 25);
        panel.add(tfWidth);

        lblHeight = new JLabel("Height: ");
        lblHeight.setFont(font);
        lblHeight.setBounds(frameWidth/2-100, 25*2+5, 200, 25);
        panel.add(lblHeight);

        tfHeight = new JTextField();
        tfHeight.setText(String.valueOf(grid.getHeight()));
        tfHeight.setBounds(frameWidth/2+30, 25*2+5, 50, 25);
        panel.add(tfHeight);

        //Размер отступа

        lblIndentWidth = new JLabel("Indent Width: ");
        lblIndentWidth.setFont(font);
        lblIndentWidth.setBounds(frameWidth/2-100, 25*3+5*2, 200, 25);
        panel.add(lblIndentWidth);

        tfIndentWidth = new JTextField();
        tfIndentWidth.setText(String.valueOf(grid.getIndentWidth()));
        tfIndentWidth.setBounds(frameWidth/2+30, 25*3+5*2, 50, 25);
        panel.add(tfIndentWidth);

        lblIndentHeight = new JLabel("Indent Height: ");
        lblIndentHeight.setFont(font);
        lblIndentHeight.setBounds(frameWidth/2-100, 25*4+5*3, 200, 25);
        panel.add(lblIndentHeight);

        tfIndentHeight = new JTextField();
        tfIndentHeight.setText(String.valueOf(grid.getIndentHeight()));
        tfIndentHeight.setBounds(frameWidth/2+30, 25*4+5*3, 50, 25);
        panel.add(tfIndentHeight);

        //Сохранение
        buttonSave = new JButton();
        buttonSave.setBounds(frameWidth/4, 25*5+5*4, frameWidth/2, 25);
        buttonSave.setText("Save");
        buttonSave.addActionListener(this);
        panel.add(buttonSave);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(buttonSave)) actionSave();
    }

    private void actionSave(){
        Grid grid = FrameMain.getInstance().getPanelMain().getPanelMap().getGrid();
        int width, height, indentWidth, indentHeight;

        try{
            width = Integer.parseInt(tfWidth.getText());
            height = Integer.parseInt(tfHeight.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
            width = 40;
            height = 40;
        }

        try{
            indentWidth = Integer.parseInt(tfIndentWidth.getText());
            indentHeight = Integer.parseInt(tfIndentHeight.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
            indentWidth = 0;
            indentHeight = 0;
        }

        grid.setSize(width, height);
        grid.setIndent(indentWidth, indentHeight);
        dispose();
    }

}
