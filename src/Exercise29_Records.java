import java.util.List;
import java.util.stream.Collectors;

public class Exercise29_Records {
    
    // Define a record for Person
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 30);
        Person p4 = new Person("David", 15);
        
        System.out.println("Person 1: " + p1);
        System.out.println("Person 1's name: " + p1.name());
        
        List<Person> people = List.of(p1, p2, p3, p4);
        
        System.out.println("\nAll people: " + people);
        
        // Use Streams to filter people who are adults (age >= 18)
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());
                                    
        System.out.println("Adults: " + adults);
    }
}
