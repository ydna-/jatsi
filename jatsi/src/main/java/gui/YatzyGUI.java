package gui;

import java.awt.*;
import javax.swing.*;

public class YatzyGUI implements Runnable {
    
    private JFrame frame;
    
    public YatzyGUI() {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("jatsi");
        frame.setPreferredSize(new Dimension(800, 450));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        JButton roll = new JButton("Roll!");
        container.add(roll, BorderLayout.SOUTH);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}
