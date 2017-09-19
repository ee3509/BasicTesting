/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test.jaxb;

import panos.test.Person;
import panos.test.Persons;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;

public class JaxbTest
{
  public static void main(String[] args) {

    try {
      JAXBContext context = JAXBContext.newInstance(Persons.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();

      URL resource = System.class.getResource("/XmlPersons.xml");

      Person person = (Person) unmarshaller.unmarshal(new File(resource.getFile()));

      System.out.println("person = " + person);

    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }

}
