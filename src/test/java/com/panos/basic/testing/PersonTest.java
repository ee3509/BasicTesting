/*
 * Copyright (c) 2017. Panos Pelegris
 */

package com.panos.basic.testing;

import org.junit.Assert;
import org.junit.Test;
import panos.test.PersonFactory;

import java.net.URL;

import panos.test.Person;
import panos.test.PersonImportException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonTest
{


  @Test
  public void testPerson() throws Exception {

    try {
      PersonFactory personFactory = new PersonFactory();

      URL resource = System.class.getResource("/Persons.txt");

      List<Person> list = Files.lines(Paths.get(resource.toURI())).
          map(encodedPerson -> {
            try {
              return personFactory.createPerson(encodedPerson);
            } catch (PersonImportException e) {
              System.out.println(encodedPerson + " : "+ e.getMsg());
              return null;
            }
          }).
          collect(Collectors.toList());

      list.removeIf(Objects::isNull);
      list.sort(Comparator.comparing(Person::getDateOfBirth));

//      list.forEach(person -> System.out.println("person = " + person));

      Assert.assertEquals(list.size(), 3);

    } catch (IOException e) {
      System.out.println("e = " + e);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

}
