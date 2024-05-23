package org.duna.jdk8193155.newcollectionmethod;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class CollectionMethodDemo01 {
  public static void main(String[] args){
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    IntFunction<Integer[]> arrayGenerator = size -> {
      Integer[] array = new Integer[size];
      Arrays.fill(array, 10);
      return array;
    };

    Integer[] resultArray = numbers.toArray(arrayGenerator);
    System.out.println(Arrays.toString(resultArray));
  }
}
