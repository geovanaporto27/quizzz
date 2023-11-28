package quizgame.repository;

import quizgame.menu.Pergunta;

public interface DataService {
    void add(Pergunta q);
    Pergunta get(int indice);
    int getTamanho();
}