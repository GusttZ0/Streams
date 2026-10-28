package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Pessoa {
    String nome;
    int idade;

    Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
public class Q8 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Ana", 17),
                new Pessoa("Carlos", 25),
                new Pessoa("Maria", 19),
                new Pessoa("Pedro", 16)
        );

        List<String> nomes = pessoas.stream()
                .filter(p -> p.idade > 18)
                .map(p -> p.nome)
                .collect(Collectors.toList());

        System.out.println(nomes);
    }
}
