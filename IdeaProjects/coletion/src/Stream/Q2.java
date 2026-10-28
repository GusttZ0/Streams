package Stream;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList(
                "Pedro", "Ana", "Carlos", "Maria"
        );

        nomes.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
