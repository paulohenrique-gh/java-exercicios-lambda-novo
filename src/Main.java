import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(43, 28, 99, 187, 91, 12, 12, 99);
        List<String> strings = Arrays.asList("music", "small", "king", "manage", "computer");
        List<Person> people = new ArrayList<>();
        people.add(new Person("João", 24));
        people.add(new Person("Maria", 24));
        people.add(new Person("Peter", 31));

        System.out.println("Original numbers: " + numbers);
        System.out.println("Original strings: " + strings);

        // Exercício 1
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Even numbers: " + evenNumbers);

        // Exercício 2
        List<Integer> doubledNumbers = numbers.stream().map(n -> n * 2).toList();
        System.out.println("doubledNumbers: " + doubledNumbers);

        // Exercício 3
        boolean allAboveTen = numbers.stream().allMatch(n -> n > 10);
        System.out.println("All greater than 10? " + allAboveTen);

        // Exercício 4
        int greatest = numbers.stream().max((n1, n2) -> Integer.compare(n1, n2)).get();
        System.out.println("Greatest: " + greatest);

        // Exercício 5
        List<String> uppercaseStrings = strings.stream().map(s -> s.toUpperCase()).toList();
        System.out.println("Uppercase strings: " + uppercaseStrings);

        // Exercício 6
        List<String> stringsSortedByLength = strings
                .stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .toList();
        System.out.println("Strings sorted by length: " + stringsSortedByLength);

        // Exercício 7
        Map<Integer, List<Person>> peopleGroupedByAge = people.stream().collect(Collectors.groupingBy(person -> person.getAge()));
        System.out.println("People grouped by age: " + peopleGroupedByAge);

        // Exercício 8
        double average = numbers.stream().collect(Collectors.averagingDouble(n -> n));
        System.out.println("Average: " + average);

        // Exercício 9
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        System.out.println("Distinct numbers: " + distinctNumbers);

        // Exercício 10
        List<String> newStrings = Arrays.asList("dunder", "mifflin", "michael", "scott", "paper");
        List<String> mergedList = IntStream
                .range(0, Math.max(strings.size(), newStrings.size()))
                .mapToObj(i -> Stream.of(strings.get(i), newStrings.get(i)).toList())
                .flatMap(s -> s.stream())
                .toList();
        System.out.println("Merged list: " + mergedList);
    }
}