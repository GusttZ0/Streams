package Stream;

import java.util.Arrays;
import java.util.List;

public class Q9 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 10, 20, 30);

        boolean positivos = numeros.stream()
                .allMatch(n -> n > 0);

        System.out.println("Todos são positivos? " + positivos);
    }
}
