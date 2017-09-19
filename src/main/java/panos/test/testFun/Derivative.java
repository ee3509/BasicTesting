/*
 * Copyright (c) 2015. Panos Pelegris
 */

package panos.test.testFun;

public class Derivative
{
  public static void main(String[] args) {
//    for (int i = 0; i < 1000; i++) {
//      System.out.println("moumoukaki<3 "+i);
//    }


    System.out.println(" der (1) : "+derivative(1));
    System.out.println(" der (2) : "+derivative(2));
    System.out.println(" der (3) : "+derivative(3));
    System.out.println(" der (4) : "+derivative(4));
    System.out.println(" der (5) : "+derivative(5));

  }

  public static int derivative(int num) {
    if (num > 0) {
      return derivative(num -1) * num;
    }
    else
    {
      return 1;
    }
  }

}

