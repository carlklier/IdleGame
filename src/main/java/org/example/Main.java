package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int clickCounter = 0;

    public static void main(String[] args) {
        JFrame application = new JFrame();
        application.setSize(640, 400);
        application.setTitle("IdleGame");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem highScoreTable = new JMenuItem("High Scores");
        highScoreTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked High Scores");
                new HighScoresTable(application);
            }
        });
        fileMenu.add(highScoreTable);
        menuBar.add(fileMenu);

        application.setJMenuBar(menuBar);

        application.setLayout(new GridLayout(6,2));

        JLabel buttonLabel = new JLabel("clicks: " + clickCounter);
        application.add(buttonLabel);

        JButton button = new JButton("Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCounter++;
                buttonLabel.setText("clicks: " + clickCounter);
            }
        });
        application.add(button);

        JLabel textFieldLabel = new JLabel("TextFieldLabel");
        application.add(textFieldLabel);

        JTextField textField = new JTextField("Default TextField");
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldLabel.setText("text field:" + textField.getText());
            }
        });
        application.add(textField);

        JLabel checkBoxLabel = new JLabel("checkBox: false");
        application.add(checkBoxLabel);

        JCheckBox checkBox = new JCheckBox("CheckBox");
        checkBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkBoxLabel.setText("checkBox:" + checkBox.isSelected());
            }
        });
        application.add(checkBox);

        JLabel sliderLabel = new JLabel("slider value: 100");
        application.add(sliderLabel);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setSnapToTicks(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderLabel.setText("slider value:" + slider.getValue());
            }
        });
        application.add(slider);

        // Radio Buttons
        JLabel radioLabel = new JLabel("RadioLabel");
        application.add(radioLabel);

        JRadioButton radio1 = new JRadioButton("Radio1");
        radio1.setName("radio1");
        JRadioButton radio2 = new JRadioButton("Radio2");
        radio2.setName("radio2");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);

        ActionListener radioActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ( ((JRadioButton) e.getSource()).getName() ){
                    case "radio1":
                        radioLabel.setText("radio1 selected");
                        break;
                    case "radio2":
                        radioLabel.setText("radio2 selected");
                        break;

                }
            }
        };
        radio1.addActionListener(radioActionListener);
        radio2.addActionListener(radioActionListener);

        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.add(radio1);
        radioButtonPanel.add(radio2);
        application.add(radioButtonPanel);


        application.setVisible(true);
    }
}