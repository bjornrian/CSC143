package tetheredFractals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private Toolkit toolkit;
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
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        toolkit = getToolkit();

        //JPanel
        JPanel widgetPanel = new JPanel();
        widgetPanel.setBounds(0, 0, 960, 540);
        widgetPanel.setBackground(Color.gray);
        widgetPanel.setLayout(null);
        this.add(widgetPanel);

        //JButtons
        JComboBox<Integer> numberOfChildrenSelector = new JComboBox<>(new Integer[]
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
        numberOfChildrenSelector.setBounds(60, 120, 300, 60 );
        numberOfChildrenSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                numberOfChildren = (Integer) source.getSelectedItem();
                System.out.println("numberOfChildren = " + numberOfChildren);
            }
        });
        widgetPanel.add(numberOfChildrenSelector);

        JComboBox<Integer> childToParentRatioSelector = new JComboBox<>(new Integer[]
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
                        38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53,
                        54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70});
        childToParentRatioSelector.setBounds(60, 267, 300, 60 );
        childToParentRatioSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                childParentRatio = (Integer) source.getSelectedItem();
                System.out.println("numberOfChildren = " + childParentRatio);
            }
        });
        widgetPanel.add(childToParentRatioSelector);

        JComboBox<Integer> recursionDepthSelector = new JComboBox<>(new Integer[]
                {2, 3, 4, 5, 6, 7, 8, 9, 10});
        recursionDepthSelector.setBounds(60, 416, 300, 60 );
        recursionDepthSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                recursionDepth = (Integer) source.getSelectedItem();
                System.out.println("recursionDepth = " + recursionDepth);
            }
        });
        widgetPanel.add(recursionDepthSelector);

        JButton colorSelector = new JButton("Color");
        colorSelector.setBounds(600, 120, 300, 60);
        colorSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame colorFrame = new JFrame();
                colorFrame.setSize(960, 540);
                colorFrame.setTitle("Color Chooser");
                colorFrame.setResizable(false);
                colorFrame.setLayout(null);
                colorFrame.setVisible(true);
                colorFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JPanel colorChooser = new ColorChooserDemo();
                colorFrame.add(colorChooser);
            }
        });
        widgetPanel.add(colorSelector);

        //Color sample for fractal
        JLabel colorSample = new JLabel();
        colorSample.setBounds(520, 120, 60, 60);
        colorSample.setBackground(color);
        colorSample.setVisible(true);
        widgetPanel.add(colorSample);

        JComboBox<String> backgroundSelector = new JComboBox<>(new String[]{"White", "Black"});
        backgroundSelector.setBounds(600, 267, 300, 60);
        backgroundSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox source = (JComboBox) e.getSource();
                if(source.getSelectedItem().equals("White")) {
                    backgroundColor = Color.WHITE;
                }
                else {
                    backgroundColor = Color.BLACK;
                }

                System.out.println("backgroundColor = " + backgroundColor);

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
                System.out.println();


                System.out.println("Child Count: " + numberOfChildren);
                System.out.println("Ratio: " + childParentRatio + "%");
                System.out.println("Recursion Depth: " + recursionDepth);
                System.out.println("Color: " + color);
                System.out.println("Background Color: " + backgroundColor);
            }
        });
        widgetPanel.add(drawSelector);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class GPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(96, 96, 390, 390);
            g.setColor(Color.BLACK);
        }
    }
}


