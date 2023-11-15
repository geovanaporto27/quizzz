package main.java.br.edu.ifpb.codigoCompleto;

import java.util.ArrayList;
import java.util.Random;

public class Gerenciador {
    private Random geradorAleatorio = new Random();
    private Armazenador armazenador = new Armazenador();

    public void criarQuestaoAberta(String pergunta, String resposta) {
        armazenador.adicionar(new Questao(pergunta, resposta));
    }

    public void criarQuestaoFechada(String pergunta, String resposta, ArrayList<String> alternativas) {
        armazenador.adicionar(new QuestaoFechada(pergunta, resposta, alternativas));
    }

    public void criarQuestaoVerdadeiroFalso(String pergunta, String resposta) {
        ArrayList<String> alternativas = new ArrayList<>();
        alternativas.add("V - Verdadeiro");
        alternativas.add("F - Falso");
        armazenador.adicionar(new QuestaoFechada(pergunta, resposta, alternativas));
    }

    public Quiz getQuiz() {
        return Armazenador.getQuizes().get(Armazenador.getQuizes().size() - 1);
    }

    public void criarQuiz() {
        ArrayList<Questao> questoesDoQuiz = new ArrayList<>();
        Questao tmp;
        int id = Armazenador.getQuizes().size();
        int numeroDeQuestoes = Math.max(geradorAleatorio.nextInt(armazenador.getTamanho()), 1);
        for (int i = 1; i < numeroDeQuestoes; i++) {
            do
                tmp = getQuestaoAleatoria();
            while (!questoesDoQuiz.contains(tmp));
            questoesDoQuiz.add(tmp);
        }
        Armazenador.getQuizes().add(new Quiz(id, numeroDeQuestoes, questoesDoQuiz));
    }

    public Questao getQuestaoAleatoria() {
        return armazenador.get(geradorAleatorio.nextInt(armazenador.getTamanho()));
    }
}