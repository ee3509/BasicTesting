/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import panos.test.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class JsonTest
{
  public static void main(String[] args) {


    try {

      Type type = new TypeToken<List<JsonElement>>(){}.getType();

      URL resource = System.class.getResource("/JSonPersons.txt");

      List<JsonElement> elements = new Gson().fromJson(new FileReader(resource.getFile()), type);
      List<Person> list = new LinkedList<>();

      elements.forEach((JsonElement jsonElement) -> {
        Class jsonElementType = jsonElement.getType();
        if (jsonElementType.equals(Person.class)) {
          list.addAll(jsonElement.getList());
        }
      });



//      persons.getList().forEach(person -> System.out.println("person = " + person));
//      System.out.println("person = " + person);

      list.forEach(person -> System.out.println("person = " + person));

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }


}
