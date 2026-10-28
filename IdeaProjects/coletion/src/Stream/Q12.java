package Stream;


import java.util.*;
import java.util.stream.Collectors;

enum TipoServico {
    ELETRICO,
    HIDRAULICO,
    ALVENARIA
}

class Servico {
    TipoServico tipo;
    double valor;

    public Servico(TipoServico tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
}


class Autonomo {
    String nome;
    String cpf;
    List<Servico> servicos;

    public Autonomo(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.servicos = new ArrayList<>();
    }
}

public class Q12 {

    static Scanner sc = new Scanner(System.in);
    static List<Autonomo> autonomos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE SERVICOS ===");
            System.out.println("1 - Cadastrar autonomo");
            System.out.println("2 - Cadastrar servico");
            System.out.println("3 - Consultar servicos por CPF");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarAutonomo();
                    break;

                case 2:
                    cadastrarServico();
                    break;

                case 3:
                    consultarServicos();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    static void cadastrarAutonomo() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        if (buscarAutonomo(cpf) != null) {
            System.out.println("CPF ja cadastrado!");
            return;
        }

        autonomos.add(new Autonomo(nome, cpf));

        System.out.println("Autonomo cadastrado com sucesso!");
    }

    static void cadastrarServico() {
        System.out.print("CPF do autonomo: ");
        String cpf = sc.nextLine();

        Autonomo autonomo = buscarAutonomo(cpf);

        if (autonomo == null) {
            System.out.println("Autonomo nao encontrado!");
            return;
        }

        System.out.println("Tipos de servico:");
        System.out.println("1 - ELETRICO");
        System.out.println("2 - HIDRAULICO");
        System.out.println("3 - ALVENARIA");
        System.out.print("Escolha o tipo: ");

        int tipoEscolhido = Integer.parseInt(sc.nextLine());

        TipoServico tipo;

        switch (tipoEscolhido) {
            case 1:
                tipo = TipoServico.ELETRICO;
                break;
            case 2:
                tipo = TipoServico.HIDRAULICO;
                break;
            case 3:
                tipo = TipoServico.ALVENARIA;
                break;
            default:
                System.out.println("Tipo invalido!");
                return;
        }

        System.out.print("Valor do servico: R$ ");
        double valor = Double.parseDouble(
                sc.nextLine().replace(",", ".")
        );

        if (valor < 0) {
            System.out.println("O valor nao pode ser negativo!");
            return;
        }

        autonomo.servicos.add(new Servico(tipo, valor));

        System.out.println("Servico cadastrado com sucesso!");
    }

    static void consultarServicos() {
        System.out.print("CPF do autonomo: ");
        String cpf = sc.nextLine();

        Autonomo autonomo = buscarAutonomo(cpf);

        if (autonomo == null) {
            System.out.println("Autonomo nao encontrado!");
            return;
        }

        System.out.println("\n=== DADOS DO AUTONOMO ===");
        System.out.println("Nome: " + autonomo.nome);
        System.out.println("CPF: " + autonomo.cpf);

        if (autonomo.servicos.isEmpty()) {
            System.out.println("Nenhum servico cadastrado.");
            return;
        }

        Map<TipoServico, List<Servico>> grupos =
                autonomo.servicos.stream()
                        .collect(Collectors.groupingBy(s -> s.tipo));

        System.out.println("\n=== SERVICOS POR TIPO ===");

        grupos.forEach((tipo, lista) -> {
            System.out.println("\nTipo: " + tipo);

            lista.forEach(s ->
                    System.out.printf("Valor: R$ %.2f%n", s.valor)
            );

            double subtotal = lista.stream()
                    .mapToDouble(s -> s.valor)
                    .sum();

            System.out.printf("Subtotal: R$ %.2f%n", subtotal);
        });

        double total = autonomo.servicos.stream()
                .mapToDouble(s -> s.valor)
                .sum();

        System.out.printf(
                "\nVALOR TOTAL DOS SERVICOS: R$ %.2f%n",
                total
        );
    }

    static Autonomo buscarAutonomo(String cpf) {
        return autonomos.stream()
                .filter(a -> a.cpf.equals(cpf))
                .findFirst()
                .orElse(null);
    }
}

