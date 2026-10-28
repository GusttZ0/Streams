package Stream;

import java.util.Arrays;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(2, 4, 6, 8, 10);

        numeros.stream()
                .forEach(n -> System.out.println(n * 2));
    }
}
