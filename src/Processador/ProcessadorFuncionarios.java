package src.Processador;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import src.Funcionario.Funcionario;

public class ProcessadorFuncionarios {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("Marlon", 32, 10000.0),
                new Funcionario("Lorrany", 23, 7500.0),
                new Funcionario("João André", 40, 15200.0),
                new Funcionario("Emanuel", 29, 3100.0),
                new Funcionario("Iago", 25, 2000.0)
        );

        gerarRelatorio(funcionarios);
    }

    public static void gerarRelatorio(List<Funcionario> funcionarios) {
        System.out.println("Funcionários com idade maior que 30 anos:");
        funcionarios.stream()
                .filter(f -> f.getIdade() > 30)
                .forEach(System.out::println);

        System.out.println("\nLista de nomes dos funcionários:");
        List<String> nomes = funcionarios.stream()
                .map(Funcionario::getNome)
                .collect(Collectors.toList());
        nomes.forEach(System.out::println);

        System.out.println("\nSoma total dos salários:");
        double somaSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(0.0, Double::sum);
        System.out.println("R$ " + somaSalarios);
    }
}
