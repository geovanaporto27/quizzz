package main.java.br.edu.ifpb.repository;
import java.util.List;

import br.edu.ifpb.Quiz;
import main.java.br.edu.ifpb.codigoCompleto.Questao;

public interface DataService {
    void add(Questao q);
    Questao get(int indice);
    int getTamanho();
}
