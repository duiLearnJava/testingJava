package testingJava;

import testingJava.Consumer;

public class ConsumerTest {
 
 //Test
 
    public static void main(String[] args) {
 
 
		Consumer consumer = ConsumerTest::printNames;
		 
		consumer.accept("Jeremy");
		consumer.accept("Paul");
		consumer.accept("Richard");
 
    } 
 
    private static void printNames(String name) {
        System.out.println(name);
    }
}
