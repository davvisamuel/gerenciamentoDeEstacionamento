import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estacionamento {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    static List<Vaga> vagas = new ArrayList<>();
    static List<Veiculo> veiculos = new ArrayList<>();

    public static void cadastrarVaga() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número do vaga");
        int numVaga = sc.nextInt();
        System.out.println("Digite o tipo da vaga: (Pequeno, Medio, Grande)");
        Tipo tipo = Tipo.valueOf(sc.next().toUpperCase());

        Vaga vaga = new Vaga(tipo, numVaga);
        vagas.add(vaga);
        System.out.println("Vaga adicionada com sucesso!\n");
    }

    public static void entradaDeVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a placa do veiculo");
        String placa = sc.nextLine();
        System.out.println("Digite o modelo do veiculo");
        String modelo = sc.nextLine();
        System.out.println("Digite o tipo do veiculo: (Pequeno, Medio, Grande)");
        Tipo tipo = Tipo.valueOf(sc.next().toUpperCase());

        System.out.println("Hórario de entrada (Horas:Minutos)");
        String entradaString = sc.next();

        LocalTime entrada = LocalTime.parse(entradaString, formatter);

        if (!vagas.isEmpty()) {
            for (Vaga v : vagas) {
                if (v.getTipo().equals(tipo) && v.isDisponivel()) {
                    Veiculo veiculo = new Veiculo(placa, modelo, tipo, entrada);
                    veiculo.setVaga(v);
                    v.setDisponivel(false);
                    veiculos.add(veiculo);
                    System.out.println("Vaga " + v.getNumVaga() + " reservada para " + veiculo.getModelo() + "\n");
                } else {
                    System.out.println("Sem vagas disponiveis");
                    break;
                }
            }
        }
    }

    public static void saidaDeVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a placa do veiculo");
        String placa = sc.nextLine();

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                System.out.println("Hórario de saída (Horas:Minutos)");
                String saidaString = sc.next();

                LocalTime saida = LocalTime.parse(saidaString, formatter);
                veiculo.setSaida(saida);

                Duration duracao = Duration.between(veiculo.getEntrada(), saida);
                System.out.println("Tempo de permanência: " + duracao.toMinutes() + " minutos");
                System.out.println("Valor a ser pago: R$" + calcularValor(duracao) + "\n");
                veiculo.setValorPago(calcularValor(duracao));

                veiculo.getVaga().setDisponivel(true);
                veiculo.setVaga(null);
            }
        }
    }

    public static double calcularValor(Duration duracao) {
        if (duracao.toHours() <= 1) {
            return 5.0;
        } else if (duracao.toHours() <= 3) {
            return 10.0;
        } else {
            return 15.0;
        }
    }

    public static void relatorioVagasOcupadas() {
        if (!vagas.isEmpty()) {
            for (Vaga v : vagas) {
                if (!v.isDisponivel()) {
                    System.out.println(v);
                }
            }
        }
    }


    public static void historicoVeiculos() {
        if (!veiculos.isEmpty()) {
            System.out.println("Histórico de veículos: ");
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo);
            }
        }else{
            System.out.println("Histórico limpo!\n");
        }
    }
}
