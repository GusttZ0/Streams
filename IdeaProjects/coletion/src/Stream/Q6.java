package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Q6 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(12, 45, 7, 89, 23);

        int maior = numeros.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();

        System.out.println("Maior número: " + maior);
    }
}
