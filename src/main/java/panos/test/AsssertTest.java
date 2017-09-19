/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class AsssertTest
{

  public static void main(String[] args) {


    System.out.println("enter a num : ");
    Scanner scanner = new Scanner(System.in);

    String value = scanner.next();


    boolean creatable = NumberUtils.isCreatable(value);
    System.out.println("creatable = " + creatable);

    assert creatable : "not a num";


    System.out.println("num = " + value);






    scanner.close();

  }


}
