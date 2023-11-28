package quizgame.menu;

import java.util.List;

public class HistoricoDeJogadas {

    // Método para exibir o histórico de pontuações do jogador
    public static void exibirHistorico(String nomeJogador, List<Integer> historicoPontuacoes) {
        System.out.println();
        System.out.println("Nome do jogador(a) " + nomeJogador + ":");

        // Verifica se o histórico de pontuações está vazio
        if (historicoPontuacoes.isEmpty()) {
            System.out.println();
            System.out.println("Você ainda não jogou nenhuma vez.");
        } else {
            // Exibe as pontuações de cada quiz no histórico
            for (int i = 0; i < historicoPontuacoes.size(); i++) {
                // Calcula a pontuação do quiz atual ou a diferença em relação ao quiz anterior
                int pontuacaoQuiz = i == 0 ? historicoPontuacoes.get(i) : historicoPontuacoes.get(i) - historicoPontuacoes.get(i - 1);
                System.out.println("Quiz " + (i + 1) + ": " + pontuacaoQuiz + " ponto(s)");
            }
        }
    }

    // Método para adicionar a pontuação do último quiz ao histórico
    public static void adicionarPontuacao(List<Integer> historicoPontuacoes, int placar) {
        historicoPontuacoes.add(placar);
    }

    // Método para exibir a pontuação final do jogador
    public static void exibirPontuacaoFinal(String nomeJogador, int placar) {
        System.out.println("Pontuação total de " + nomeJogador + ": " + placar + " ponto(s)");
    }
}