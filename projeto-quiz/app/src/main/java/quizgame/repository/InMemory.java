package quizgame.repository;

import java.util.ArrayList;
import java.util.List;

import quizgame.menu.Pergunta;

public class InMemory implements ArmazenamentoDePerguntas{
    protected List<Pergunta> perguntas = new ArrayList<>();

    @Override
    public void add(Pergunta p) {
        perguntas.add(p);
    }

    @Override
    public List<Pergunta> getPerguntas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPerguntas'");
    }
}