/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Persons
{
  @XmlElement
  private final List<Person> _list = null;

  public Persons( ) {
  }

}
