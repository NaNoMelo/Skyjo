package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class pop_up extends JFrame {
    // show a pop up window with a message
    public void indication(String message){
        JFrame frame = new JFrame("Skyjjo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel label = new JLabel(message);
        JButton button = new JButton("OK");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }

}
