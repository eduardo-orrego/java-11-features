package org.duna.jep323.varlambda;

import java.util.Arrays;
import java.util.stream.Collectors;

public class VarLambdaDemo01 {
  public static void main(String[] args) {

    var numberList = Arrays.asList(1, 2);

    var numberString = numberList.stream()
      .map(number -> String.valueOf(number * 2))
      .collect(Collectors.joining(","));
    System.out.println(numberString);

    var numberString2 = numberList.stream()
      .map((var number) -> number * 2)
      .map(Object::toString)
      .collect(Collectors.joining(","));

    System.out.println(numberString2);

  }
}
