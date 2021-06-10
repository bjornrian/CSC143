package tetheredFractals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {
    private Toolkit toolkit;
    private int childCount;
    private int childParentRatio;
    private int recursionDepth;
    private Color color; //todo color variable might change
    private Boolean hasBlackBackground;

    public UserInterface() {
        setSize(960, 1080);
        setTitle("Tethered Radial Fractal");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        toolkit = getToolkit();

        //JPanel Stuff
        JPanel panel = new GPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        //JButton Stuff
        JButton beep = new JButton("Beep");
        beep.setBounds(150, 60, 80, 30);
        JButton close = new JButton("Close");
        close.setBounds(50, 60, 80, 30);

        beep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolkit.beep();
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(beep);
        panel.add(close);
    }

    private class GPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(10, 10, 190, 190);
            g.setColor(Color.BLACK);
            g.fillOval(50, 50, 100, 100);
        }
    }
}


