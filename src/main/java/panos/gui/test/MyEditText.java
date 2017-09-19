/*
 * Copyright (c) 2014. Panos Pelegris
 */

package panos.gui.test;

import javax.swing.*;
import java.awt.*;

public class MyEditText extends JTextField{


  public static void main(String[] args) {
    MyEditText myEditText = new MyEditText();
    JFrame frame = new JFrame("Test");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    myEditText.setText("hello");

    JPanel panel = new JPanel();
    panel.add(myEditText);
    frame.setContentPane(panel);

    frame.pack();
    frame.setVisible(true);

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    //g.drawString("My", this.getWidth()-10, this.getHeight()-10);






  }
}
