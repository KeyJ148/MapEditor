package gui.menu;

import gui.FrameMain;
import gui.map.Grid;
import gui.map.ObjectHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDirectionStep extends JDialog implements ActionListener {

    private static final String NAME = "Rotation angel step";

    private JLabel lblDir;
    private JTextField tfDir;
    private JButton buttonSave;

    public DialogDirectionStep(JFrame frame){
        super(frame, NAME, true);

        setResizable(false);

        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        int displayWidth = displaySize.width;
        int displayHeight = displaySize.height;
        int frameWidth = 220;
        int frameHeight = 120;
        setBounds(displayWidth/2-frameWidth/2, displayHeight/2-frameHeight/2, frameWidth, frameHeight);

        //Добавление компонентов
        Font font = new Font(null, Font.PLAIN, 17);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        //Размер сетки
        lblDir = new JLabel("Rotate step: ");
        lblDir.setFont(font);
        lblDir.setBounds(frameWidth/2-100, 25, 200, 25);
        panel.add(lblDir);

        tfDir = new JTextField();
        tfDir.setText(String.valueOf(ObjectHandler.DIRECTION_UP));
        tfDir.setBounds(frameWidth/2+30, 25, 50, 25);
        panel.add(tfDir);

        //Сохранение
        buttonSave = new JButton();
        buttonSave.setBounds(frameWidth/4, 25+25+5, frameWidth/2, 25);
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
        try{
            ObjectHandler.DIRECTION_UP = Double.parseDouble(tfDir.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }

        dispose();
    }

}
