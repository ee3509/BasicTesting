/*
 * Copyright (c) 2015. Panos Pelegris
 */

package panos.test.recursion;

public class ParentBit
{
  public static void main(String[] args) {

    String s = parenBit("xyz(abc)123");
    System.out.println("s = " + s);
    System.out.println(s.equals("(abc)"));
    System.out.println(parenBit("x(hello)").equals("(hello)"));
    System.out.println(parenBit("(xy)1").equals("(xy)"));


  }

  static public String parenBit(String str) {

    int startIdx = str.indexOf("(");
    int stopIdx = str.indexOf(")");
    if (startIdx < stopIdx) {
      return parenBit(str.substring(startIdx+1, stopIdx));
    }
    else return "("+str+")";
  }

}
