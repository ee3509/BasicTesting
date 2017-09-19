/*
 * Copyright (c) 2014. Panos Pelegris
 */

package panos.gui.test;

import javax.swing.*;

public class MyTestUI
{
  public static void main(String[] args) {
    final JFrame frame = new JFrame("Test");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    frame.setContentPane(panel);

    panel.add(new MySlider("MySlider", 0.0, 1000.0, 100.0));

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run()
      {
        frame.pack();
        frame.setVisible(true);
      }
    });


  }





}
