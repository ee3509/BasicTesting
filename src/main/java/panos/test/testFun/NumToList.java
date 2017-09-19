/*
 * Copyright (c) 2016. Panos Pelegris
 */

package panos.test.testFun;


import java.util.ArrayList;

public class NumToList
{

  public static void main(String[] args) {


    int num = 137;

    String string = Integer.toString(num);

    char[] chars = string.toCharArray();

    ArrayList<Character> characters = new ArrayList<Character>();
    for (char aChar : chars) {
      characters.add(aChar);
    }


    System.out.println("characters = " + characters);





  }


}
