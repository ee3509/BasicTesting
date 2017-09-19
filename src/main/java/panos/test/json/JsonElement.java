/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test.json;

import java.util.List;

public class JsonElement
{
  private final String _typeName;
  private List _list;

  public JsonElement(String typeName) {
    _typeName = typeName;
  }


  Class getType(){
    try {
      return Class.forName("panos.test." +_typeName);
    } catch (ClassNotFoundException e) {
      System.out.println("e = " + e);
    }
    return null;
  }

  public List getList() {
    return _list;
  }
}
