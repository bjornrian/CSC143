package tetheredFractals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private Toolkit toolkit;
    private int childCount;
    private int childParentRatio;
    private int recursionDepth;
    private Color color; //todo color variable might change
    private Boolean hasBlackBackground;

    public MyFrame() {
        //JFrame
        this.setSize(960, 1080);
        this.setTitle("Tethered Radial Fractal");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        toolkit = getToolkit();

        //JButtons
        JSlider childToParentRatio = new JSlider(20, 70, 45);
        childToParentRatio.setBounds(25, 25, 80, 30);
        childToParentRatio.setPaintTrack(true);
        childToParentRatio.setPaintTicks(true);
        childToParentRatio.setPaintLabels(true);
        childToParentRatio.setMinorTickSpacing(5);
        this.add(childToParentRatio);

        JComboBox<Integer> childCount = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
        childCount.setBounds(130, 25, 120, 30);
        childCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo
            }
        });
        this.add(childCount);

        JComboBox<Integer> recursionDepth = new JComboBox<>(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10});
        recursionDepth.setBounds(275, 25, 120, 30);
        recursionDepth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo
            }
        });
        this.add(recursionDepth);

        JButton color = new JButton("Color");
        color.setBounds(420, 25, 80, 30);
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo
            }
        });
        this.add(color);

        JComboBox<String> background = new JComboBox<>(new String[]{"Black", "White"});
        background.setBounds(525, 25, 80, 30);
        background.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                hasBlackBackground = ((String) cb.getSelectedItem()).equals("Black");
            }
        });
        this.add(background);

        JButton draw = new JButton("Draw");
        draw.setBounds(630, 25, 80, 30);
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //drawPanel.setVisible(true);
            }
        });
        this.add(draw);
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


