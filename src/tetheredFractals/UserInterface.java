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
        //JFrame
        JFrame frame = new JFrame();
        frame.setSize(960, 1080);
        frame.setTitle("Tethered Radial Fractal");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        toolkit = getToolkit();

        //Graphics Panel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        frame.add(panel);

        JPanel drawPanel = new GPanel();
        getContentPane().add(drawPanel);
        drawPanel.setLayout(null);
        drawPanel.setVisible(false);
        frame.add(drawPanel);

        //JButtons
        JButton childCount = new JButton("Child Count");
        childCount.setBounds(125, 25, 80, 30);
        childCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo
            }
        });
        panel.add(childCount);

        JButton childToParentRatio = new JButton("Ratio");
        childToParentRatio.setBounds(25, 25, 80, 30);
        childToParentRatio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo
            }
        });
        panel.add(childToParentRatio);

        JButton recursionDepth = new JButton("Recursion Depth");
        recursionDepth.setBounds(225, 25, 80, 30);
        recursionDepth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo
            }
        });
        panel.add(recursionDepth);

        JButton color = new JButton("Color");
        color.setBounds(325, 25, 80, 30);
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo
            }
        });
        panel.add(color);

        JComboBox<String> background = new JComboBox<>(new String[]{"Black", "White"});
        background.setBounds(425, 25, 80, 30);
        background.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                hasBlackBackground = ((String) cb.getSelectedItem()).equals("Black");
            }
        });
        panel.add(background);

        JButton draw = new JButton("Draw");
        draw.setBounds(525, 25, 80, 30);
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setVisible(true);
            }
        });
        panel.add(draw);
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


