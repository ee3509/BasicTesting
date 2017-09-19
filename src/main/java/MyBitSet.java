import java.util.BitSet;

/*
 * Copyright (c) 2014. Panos Pelegris
 */
public class MyBitSet
{

  public static void main(String[] args)
  {
    BitSet bitSetA = new BitSet(64);
    BitSet bitSetB = new BitSet(64);

    String bitStringA = "10010001";
    String bitStringB = "00000010";

    for (int i = 0; i < bitStringA.length(); i++)
    {
      boolean value = bitStringA.charAt(i) == '1';
      bitSetA.set(i, value);
    }

    for (int i = 0; i < bitStringB.length(); i++)
    {
      boolean value = bitStringB.charAt(i) == '1';
      bitSetB.set(i, value);
    }


    System.out.println(bitSetA);
    System.out.println(bitSetB);

    bitSetA.or(bitSetB);

    System.out.println(bitSetA);



  }

}
