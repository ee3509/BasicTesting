/*
 * Copyright (c) 2014. Panos Pelegris
 */

package panos.gui.test;

import java.util.LinkedList;

import static panos.gui.test.LeftRightInsert.Direction.LEFT;
import static panos.gui.test.LeftRightInsert.Direction.RIGHT;

public class LeftRightInsert<T>
{

  LinkedList<T> _list = new LinkedList<T>();
  int _idx=0;
  Direction _direction = LEFT;
  enum Direction {LEFT, RIGHT}



  void insert(T object)
  {
    if (_direction == RIGHT) {
      _list.add(_idx, object);
      _direction = LEFT;
    }
    else if (_direction == LEFT) {
      _list.add(0, object);
      _idx = _list.size();
      _direction = RIGHT;
    }
  }

  public LinkedList<T> getList()
  {
    return _list;
  }

  @Override
  public String toString()
  {
    return _list.toString();
  }


  public static void main(String[] args)
  {
    LeftRightInsert<String> myList = new LeftRightInsert<String>();

    myList.insert("first");
    myList.insert("second");
    myList.insert("third");
    myList.insert("fourth");


    System.out.println(myList.toString());


    for (String s : myList.getList())
    {
      System.out.println(s);
    }

  }
}
