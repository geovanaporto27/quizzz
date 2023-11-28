package quizgame.repository;

import java.util.List;

import quizgame.menu.Pergunta;

public interface ArmazenamentoDePerguntas {
    void add(Pergunta p);
    List<Pergunta> getPerguntas();
} 