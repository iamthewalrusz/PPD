import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {

        final int NUMERO_SIMULACOES = 1000;
        final int MEDIA_ATENDIMENTOS = 100;
        final double MEDIA_TEMPO = 5.00;

        double[] sigmas = {0.25, 1.0, 2.0};

        for (double sigma : sigmas) {
            List<Double> mediasAtendimento = new ArrayList<>();
            SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();

            for (int i = 0; i < NUMERO_SIMULACOES; i++) {
                simulador.setNumeroCaixas(1);
                simulador.setMediaAtendimentos(MEDIA_ATENDIMENTOS);
                simulador.setMediaTempoAtendimentoPorCliente(MEDIA_TEMPO);
                simulador.setDesvioPadraoTempoAtendimentoPorCliente(sigma);

                double mediaAtendimento = simulador.simular();
                mediasAtendimento.add(mediaAtendimento);
            }

            double media = media(mediasAtendimento);
            double dp = desvioPadrao(mediasAtendimento, media);

            System.out.printf("sigma = %.2f -> Media (%.0f sim): %.4f min; Desvio-padrao das medias: %.4f min%n",
                    sigma, (double) NUMERO_SIMULACOES, media, dp);
        }
    }

    private static double media(List<Double> xs) {
        double s = 0.0;
        for (double x : xs) s += x;
        return s / xs.size();
    }

    private static double desvioPadrao(List<Double> xs, double m) {
        double s2 = 0.0;
        for (double x : xs) {
            double d = x - m;
            s2 += d * d;
        }
        return Math.sqrt(s2 / (xs.size() - 1));
    }
}
