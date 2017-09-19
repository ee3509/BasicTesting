/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test;

import java.util.BitSet;

public class BitShifttest
{

  public static void main(String[] args) {

//    System.out.println(1 << 8);
//    System.out.println(1 << 16);
//    System.out.println(1l << 32);
//    System.out.println(1l << 64);

    BitSet bitSet = new BitSet(8);
    bitSet.set(0, 0);

    System.out.println("bitSet = " + bitSet);
    System.out.println("bitSet = " + bitSet.isEmpty());


  }
}
