import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String apiKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // Substitua pela sua chave de API
        String moedaBase = "";
        String moedaDesejada = "";

        ConversorMoeda conversor = new ConversorMoeda(apiKey);
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolha a moeda base (ex: BRL, USD, EUR, GBP, ARS, CLP, ...):");
        moedaBase = scanner.nextLine();

        while (true) {
            System.out.println("\nEscolha a moeda para conversão:");
            System.out.println("1 - BRL (Real Brasileiro)");
            System.out.println("2 - USD (Dolar Americano)");
            System.out.println("3 - EUR (Euro)");
            System.out.println("4 - GBP (Libra Esterlina)");
            System.out.println("5 - ARS (Peso Argentino)");
            System.out.println("6 - CLP (Peso Chileno)");
            System.out.println("7 - Sair");
            System.out.print("Digite sua opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    moedaDesejada = "BRL";
                    break;
                case "2":
                    moedaDesejada = "USD";
                    break;
                case "3":
                    moedaDesejada = "EUR";
                    break;
                case "4":
                    moedaDesejada = "GBP";
                    break;
                case "5":
                    moedaDesejada = "ARS";
                    break;
                case "6":
                    moedaDesejada = "CLP";
                    break;
                case "7":
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            try {
                JsonObject jsonResultado = conversor.obterJsonDaApi(moedaBase);

                if (jsonResultado != null) {
                    Double taxaDesejada = conversor.obterTaxaEspecifica(jsonResultado, moedaDesejada);

                    if (taxaDesejada != null) {
                        System.out.println("A taxa de câmbio de " + moedaBase + " para " + moedaDesejada + " é: " + taxaDesejada);
                    }
                }

            } catch (IOException | InterruptedException e) {
                System.err.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }
}