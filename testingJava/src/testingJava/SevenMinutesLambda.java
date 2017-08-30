package testingJava;

import java.util.*;
import testingJava.Consumer;
 
public class SevenMinutesLambda {
 
   public static void main(String[] args) {
 
      List<String> strings = Arrays.asList("Lambda ", "expressions ", "are ", "cool");
 
      strings.forEach((String s) -> System.out.print(s));
 
   }
}