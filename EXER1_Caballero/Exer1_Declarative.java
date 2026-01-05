import java.util.List;
import java.util.stream.Collectors;

public class Exer1_Declarative {
    public static void main(String[] args) {
        List<String> names = List.of("Aldryan", "Robert", "Alice", "Bob", "Charlie", "David", "Eve", "Frank");
        List<String> filteredNames = names.stream()
             .filter(name -> name.charAt(0) >= 'A' && name.charAt(0) <= 'F')
             .collect(Collectors.toList());

        filteredNames.forEach(System.out::println);
    }
}
