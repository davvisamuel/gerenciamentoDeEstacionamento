public class Vaga {
    private int numVaga;
    private boolean disponivel;
    private Tipo tipo;

    public Vaga(Tipo tipo, int numVaga) {
        this.tipo = tipo;
        this.numVaga = numVaga;
        this.disponivel = true;
    }

    public int getNumVaga() {
        return numVaga;
    }

    public void setNumVaga(int numVaga) {
        this.numVaga = numVaga;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "numVaga=" + numVaga +
                ", disponivel=" + disponivel +
                ", tipo=" + tipo +
                '}' + "\n";
    }
}
