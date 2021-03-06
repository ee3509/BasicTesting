/*
 * Copyright (c) 2014. Panos Pelegris
 */

package panos.gui.test;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator {

  NumListener numListener = new NumListener();
  EditorListener editorListener = new EditorListener();
  JTextField editorField;

  public static void main(String[] args) {

    final MyCalculator myCalculator = new MyCalculator();

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        myCalculator.createAndShowGUI();
      }
    });
  }

  private void createAndShowGUI() {

    numListener = new NumListener();

    JFrame frame = new JFrame("MyCalculator");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setResizable(false);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout(5,5));

    frame.setContentPane(mainPanel);

    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel calculatorPanel = new JPanel();
    JPanel editorPanel = new JPanel();

    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

    // TextField
    {
      editorField = new JTextField();
      editorField.addActionListener(editorListener);
      editorField.setHorizontalAlignment(SwingConstants.TRAILING);
      editorField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
      editorField.setPreferredSize(new Dimension(160, 30));
      editorPanel.add(editorField);
    }

    // numPad
    {
      String[] buttonString = {
          "7","8","9",
          "4","5","6",
          "1","2","3",
          "0","+/-",".",
          "<-"
      };
      calculatorPanel.setLayout(new GridLayout(5, 3, 4, 4));
      for (String buttonSymbol : buttonString) {
        JButton button = new JButton(buttonSymbol);
        button.setPreferredSize(new Dimension(40, 30));
        button.addActionListener(numListener);
        button.setDisplayedMnemonicIndex(0);
        calculatorPanel.add(button);
      }
    }

    // buttons
    {
      rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
      JButton okButton = new JButton();
      JButton cancelButton = new JButton();

      okButton.setMaximumSize(new Dimension(80, 30));
      okButton.setText("OK");
      okButton.setContentAreaFilled(true);
      cancelButton.setMaximumSize(new Dimension(80, 30));
      cancelButton.setText("Cancel");

      rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
      rightPanel.add(okButton);
      rightPanel.add(cancelButton);
    }


    leftPanel.add(editorPanel);
    leftPanel.add(calculatorPanel);

//    editorPanel.setBackground(Color.RED);
//    calculatorPanel.setBackground(Color.YELLOW);
//    rightPanel.setBackground(Color.BLACK);

    mainPanel.add(leftPanel, BorderLayout.CENTER);
    mainPanel.add(rightPanel, BorderLayout.EAST);


    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }

  private class NumListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      editorField.setText(editorField.getText()+e.getActionCommand());
//      System.out.println(e.getActionCommand());
    }
  }

  private class EditorListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
  }


}
