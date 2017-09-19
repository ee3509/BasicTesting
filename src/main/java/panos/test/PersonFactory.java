/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test;

public class PersonFactory
{
  public Person createPerson(String encodedPerson) throws PersonImportException {
    String[] split = encodedPerson.split(",");
    if (split.length == 3) {
      return new Person(split[0].trim(),
                        split[1].trim(),
                        Integer.parseInt(split[2].trim()));
    }
    else {
      throw new PersonImportException("Unexpected Length " + split.length);
    }


  }


}
