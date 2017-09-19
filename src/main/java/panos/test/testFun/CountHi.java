/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test.testFun;

public class CountHi
{

  static int res =0;

  public int count(String string) {

    if (string.length() >= 2) {
      if (string.substring(0, 2).equals("hi")) {
        res++;
        count(string.substring(2, string.length()));
      }
      else count(string.substring(1, string.length()));
    }
    else if (string.length() < 2) {
      return res;
    }
    return res;
  }


  public static void main(String[] args) {
    CountHi countHi = new CountHi();

    System.out.println("countHi = " + countHi.count("hi12hihisadasdhi"));

  }

}
