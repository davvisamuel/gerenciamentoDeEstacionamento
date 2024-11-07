import java.time.LocalTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private Tipo tipo;
    private LocalTime entrada, saida;
    private Vaga vaga;
    private Double valorPago;

    public Veiculo(String placa, String modelo, Tipo tipo, LocalTime entrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.entrada = entrada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", entrada=" + entrada +
                ", saida=" + saida +
                ", valorPago=" + valorPago +
                '}' + "\n";

    }
}
