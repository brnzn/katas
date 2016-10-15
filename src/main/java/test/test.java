package test;

import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class test {
    public static void main(String[] args) {
        Optional<String> o = Optional.empty();//of("aaa");

        String len = o.orElseThrow(() -> new RuntimeException("aaaaa"));

        Predicate<String> p = (String s) -> s == "true";
        System.out.println(p.and((String s) -> s.equalsIgnoreCase("True")).test("true"));
//        List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
//
//        collection.stream().map(String :: toUpperCase).collect(toList()).forEach(System.out::println);
//
//        collection.stream().filter(s -> s.length() < 4).collect(toList()).forEach(System.out::println);
//
//        List<List<String>> collection1 = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
//
//        List<String> result = collection1.stream().flatMap(Collection::stream).collect(toList());
//
//        System.out.println(result);

        test t = new test();
        t.getOldestPerson();

        t.sumAllElementsInCollection();

        new File(".").listFiles(File::isHidden);
    }

    public void sumAllElementsInCollection() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    public void getOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = Arrays.asList(sara, eva, viktor);

        System.out.println(collection.stream().max(Person::compareByAge).map(Person::getName).orElse("!!!"));
    }


    private static final class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public static int compareByAge(Person a, Person b) {
            return a.getAge().compareTo(b.getAge());
        }
    }

}


