package Stream;

import java.util.Arrays;
import java.util.List;

public class Q7 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList(
                "Java", "Programacao", "Stream", "Casa", "Computador"
        );

        long quantidade = palavras.stream()
                .filter(p -> p.length() > 5)
                .count();

        System.out.println("Quantidade: " + quantidade);
    }
}