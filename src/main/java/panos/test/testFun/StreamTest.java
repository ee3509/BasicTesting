/*
 * Copyright (c) 2017. Panos Pelegris
 */

package panos.test.testFun;

import java.util.stream.Stream;

public class StreamTest
{
  public static void main(String[] args) {

    Stream<Integer> stream = Stream.of(1, 2, 3, 4);

//    Integer collect = stream.collect(Collectors.summingInt(value -> value));
//    System.out.println("collect = " + collect);

//    Optional<Integer> max = stream.max(Comparator.comparing(Function.identity()));
//    System.out.println("max = " + max);


    Integer reduce = stream.reduce(0, (a, b) -> a + b);

    System.out.println("stream = " + reduce);

  }


}
