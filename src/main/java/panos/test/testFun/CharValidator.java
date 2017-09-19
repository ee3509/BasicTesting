/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test.testFun;

public class CharValidator
{
  public static void main(String[] args) {

    CharValidator charValidator = new CharValidator();

    System.out.println("validateChar('g'); = " + charValidator.validateChar('g'));
    System.out.println("validateChar('G'); = " + charValidator.validateChar('G'));
    System.out.println("validateChar('!'); = " + charValidator.validateChar('!'));
    System.out.println("validateChar('5'); = " + charValidator.validateChar('5'));

  }

  boolean validateChar(Character c) {
    boolean rangeA_Z = ('A' < c && c < 'Z');
    boolean rangea_z = ('a' < c && c < 'z');
    boolean range0_9 = ('0' < c && c < '9');

    return rangeA_Z || rangea_z || range0_9;
  }

}
