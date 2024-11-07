import java.util.Scanner;

public class SistemaPrincipal {
    public static void main(String[] args) {
        executar();
    }

    public static void menu() {
        System.out.println("1- Adicionar Vaga");
        System.out.println("2- Entrada de veículo");
        System.out.println("3- Saída de veículo");
        System.out.println("4- Relátorio de vagas ocupadas");
        System.out.println("5- Histórico de veículos");
        System.out.println("0- Sair");
    }

    public static void executar() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;

        do {
            menu();
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    Estacionamento.cadastrarVaga();
                    break;
                case 2:
                    Estacionamento.entradaDeVeiculo();
                    break;
                case 3:
                    Estacionamento.saidaDeVeiculo();
                    break;
                case 4:
                    Estacionamento.relatorioVagasOcupadas();
                    break;
                case 5:
                    Estacionamento.historicoVeiculos();
                    break;
                default:
                    break;

            }
        } while (opc != 0);
    }
}
