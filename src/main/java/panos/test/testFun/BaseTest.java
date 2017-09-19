/*
 * Copyright (c) 2015. Panos Pelegris
 */

package panos.test.testFun;

public class BaseTest
{

  public static void main(String[] args) {
    new Extension().getSomething();
  }
  
  
  static class Extension extends Base.B{

    @Override
    public void getSomething() {
      super.getSomething();
    }
  }
  
  
}
