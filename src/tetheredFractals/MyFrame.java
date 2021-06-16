package tetheredFractals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private Toolkit toolkit;
    public Integer DIAMETER = 100;
    public Integer RADIUS = 50;
    public Integer START_X = 480;
    public Integer START_Y = 540;
    private Integer numberOfChildren = 3;
    private Integer childParentRatio = 40;
    private Integer recursionDepth = 5;
    private Color color = Color.BLACK;
    private Color backgroundColor = Color.WHITE;

    public MyFrame() {
        //JFrame
        this.setSize(960, 540);
        this.setTitle("Tethered Radial Fractal");
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        toolkit = getToolkit();

        //JPanel
        JPanel widgetPanel = new JPanel();
        widgetPanel.setBounds(0, 0, 960, 540);
        widgetPanel.setBackground(Color.gray);
        widgetPanel.setLayout(null);
        this.add(widgetPanel);

        //Number of children
        JComboBox<Integer> numberOfChildrenSelector = new JComboBox<>(new Integer[]
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
        numberOfChildrenSelector.setBounds(60, 120, 300, 60);
        numberOfChildrenSelector.setSelectedIndex(2);
        numberOfChildrenSelector.setToolTipText("Number of children");
        numberOfChildrenSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                numberOfChildren = (Integer) source.getSelectedItem();
            }
        });
        widgetPanel.add(numberOfChildrenSelector);

        //Child to parent ratio
        JComboBox<Integer> childToParentRatioSelector = new JComboBox<>(new Integer[]
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
                        38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53,
                        54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70});
        childToParentRatioSelector.setBounds(60, 267, 300, 60);
        childToParentRatioSelector.setSelectedIndex(20);
        childToParentRatioSelector.setToolTipText("Child to parent ratio");
        childToParentRatioSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                childParentRatio = (Integer) source.getSelectedItem();
            }
        });
        widgetPanel.add(childToParentRatioSelector);

        //Recursion depth
        JComboBox<Integer> recursionDepthSelector = new JComboBox<>(new Integer[]
                {2, 3, 4, 5, 6, 7, 8, 9, 10});
        recursionDepthSelector.setBounds(60, 416, 300, 60);
        recursionDepthSelector.setSelectedIndex(3);
        recursionDepthSelector.setToolTipText("Recursion depth");
        recursionDepthSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                recursionDepth = (Integer) source.getSelectedItem();
            }
        });
        widgetPanel.add(recursionDepthSelector);

        //Color sample for fractal
        JLabel colorSample = new JLabel();
        colorSample.setBounds(520, 120, 60, 60);
        colorSample.setOpaque(true);
        colorSample.setBackground(color);
        widgetPanel.add(colorSample);
        colorSample.setVisible(true);

        JButton colorSelector = new JButton("Fractal Color");
        colorSelector.setBounds(600, 120, 300, 60);
        colorSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialColor = Color.RED;
                Color selectedColor = JColorChooser.showDialog(colorSelector, "Select a color", initialColor);
                colorSample.setBackground(selectedColor);
                color = selectedColor;
            }
        });
        widgetPanel.add(colorSelector);

        //Background color
        JComboBox<String> backgroundSelector = new JComboBox<>(new String[]{"White", "Black"});
        backgroundSelector.setBounds(600, 267, 300, 60);
        backgroundSelector.setToolTipText("Background color");
        backgroundSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                if (source.getSelectedItem().equals("White")) {
                    backgroundColor = Color.WHITE;
                } else {
                    backgroundColor = Color.BLACK;
                }
            }
        });
        widgetPanel.add(backgroundSelector);

        JButton drawSelector = new JButton("Draw");
        drawSelector.setBounds(600, 416, 300, 60);
        drawSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame drawingFrame = new JFrame();
                drawingFrame.setLocation(960, 0);
                drawingFrame.setSize(960, 1080);
                drawingFrame.setTitle("Fractal Generator");
                drawingFrame.setResizable(false);
                drawingFrame.setLayout(null);
                drawingFrame.setVisible(true);
                drawingFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JPanel drawingPanel = new GPanel();
                drawingPanel.setBounds(0, 0, 960, 1080);
                drawingPanel.setBackground(backgroundColor);
                drawingPanel.setVisible(false);
                drawingPanel.setLayout(null);
                drawingFrame.add(drawingPanel);
                drawingPanel.setVisible(true);
            }
        });
        widgetPanel.add(drawSelector);

        //setting visibility at the end removes the bug of buttons randomly appearing
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private class GPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            //patient zero
            g.drawOval(START_X - 50, START_Y - 50, RADIUS * 2, RADIUS * 2);
            paintShape(g, recursionDepth, START_X, START_Y, RADIUS);
        }

        public void paintShape(Graphics g, Integer depth, Integer startX, Integer startY, Integer radius) {
            if (depth > 1) {
                depth--;
                for (int i = 1; i <= numberOfChildren; i++) {
                    if (radius < 2) {
                        break;
                    }
                    double piValue = (i * 2 * Math.PI) / (numberOfChildren);
                    //children
                    g.drawOval((int) (radius * 2 * Math.cos(piValue) + startX - (radius * childParentRatio / 100)),
                            (int) (radius * 2 * Math.sin(piValue) + startY - (radius * childParentRatio / 100)),
                            radius * 2 * childParentRatio / 100,
                            radius * 2 * childParentRatio / 100);
                    paintShape(g, depth,
                            (int) ((radius * 2) * Math.cos(piValue) + startX),
                            (int) ((radius * 2) * Math.sin(piValue) + startY),
                            radius * childParentRatio / 100
                    );

                    //parent to child lines
                    g.drawLine((int) ((radius * 2 - (radius * childParentRatio / 100)) * Math.cos(piValue) + startX),
                            (int) ((radius * 2 - (radius * childParentRatio / 100)) * Math.sin(piValue) + startY),
                            (int) (radius * Math.cos(piValue) + startX),
                            (int) (radius * Math.sin(piValue) + startY));
                }
            }
        }
    }
}

