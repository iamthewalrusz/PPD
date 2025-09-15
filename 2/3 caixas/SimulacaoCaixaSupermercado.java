public class SimulacaoCaixaSupermercado {

    private int numeroCaixas;
    private int mediaAtendimentos;
    private double mediaTempoAtendimentoPorCliente;
    private double desvioPadraoTempoAtendimentoPorCliente;

    private static final double TEMPO_MINIMO_ATENDIMENTO = 0.1;

    private final java.util.Random rng = new java.util.Random(42);

    public void setNumeroCaixas(int n) { this.numeroCaixas = n; }
    public void setMediaAtendimentos(int n) { this.mediaAtendimentos = n; }
    public void setMediaTempoAtendimentoPorCliente(double mu) {
        this.mediaTempoAtendimentoPorCliente = mu;
    }
    public void setDesvioPadraoTempoAtendimentoPorCliente(double sigma) {
        this.desvioPadraoTempoAtendimentoPorCliente = sigma;
    }

    private double tempoAtendimentoNormalTruncado() {
        double z = rng.nextGaussian();
        double s = mediaTempoAtendimentoPorCliente +
            desvioPadraoTempoAtendimentoPorCliente * z;
        return (s < TEMPO_MINIMO_ATENDIMENTO) ? TEMPO_MINIMO_ATENDIMENTO : s;
    }

    public double simular() {
        double[] caixas = new double[numeroCaixas];

        for (int i = 0; i < mediaAtendimentos; i++) {
            double tempoCliente = tempoAtendimentoNormalTruncado();

            int caixaLivre = 0;
            for (int j = 1; j < numeroCaixas; j++) {
                if (caixas[j] < caixas[caixaLivre]) {
                    caixaLivre = j;
                }
            }

            caixas[caixaLivre] += tempoCliente;
        }

        double tempoTotal = 0.0;
        for (double t : caixas) {
            if (t > tempoTotal) tempoTotal = t;
        }

        return tempoTotal / mediaAtendimentos;
    }
}