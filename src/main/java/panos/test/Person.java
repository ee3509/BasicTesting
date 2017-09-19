/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person
{

  @XmlElement(name = "firstName")
  private String _firstName=null;
  @XmlElement(name = "lastName")
  private String _lastName=null;
  @XmlElement(name = "dob")
  private Integer _dateOfBirth=null;

  public String getFirstName() {
    return _firstName;
  }

  public String getLastName() {
    return _lastName;
  }

  public int getDateOfBirth() {
    return _dateOfBirth;
  }

  public Person() {
  }

  public Person(String firstName, String lastName, int dateOfBirth) {

    _firstName = firstName;
    _lastName = lastName;
    _dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return "Person{" +
        "_firstName='" + _firstName + '\'' +
        ", _lastName='" + _lastName + '\'' +
        ", _dateOfBirth=" + _dateOfBirth +
        '}';
  }
}
