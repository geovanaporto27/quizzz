package main.java.br.edu.ifpb.codigoCompleto;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Questao> questoes = new ArrayList<>();
    private int id;
    private int numeroDeQuestoes;
    private int numeroDeQuestoesRespondidas;
    private int numeroDeQuestoesCorretas;

    public Quiz(int id, int numeroDeQuestoes, ArrayList<Questao> questoes) {
        setId(id);
        setNumeroDeQuestoesCorretas(0);
        setNumeroDeQuestoesRespondidas(0);
        setNumeroDeQuestoes(numeroDeQuestoes);
        setQuestoes(questoes);
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }

    public int getNumeroDeQuestoes() {
        return numeroDeQuestoes;
    }

    public void setNumeroDeQuestoes(int numeroDeQuestoes) {
        this.numeroDeQuestoes = numeroDeQuestoes;
    }

    public int getNumeroDeQuestoesRespondidas() {
        return numeroDeQuestoesRespondidas;
    }

    public void setNumeroDeQuestoesRespondidas(int numeroDeQuestoesRespondidas) {
        this.numeroDeQuestoesRespondidas = numeroDeQuestoesRespondidas;
    }

    public int getNumeroDeQuestoesCorretas() {
        return numeroDeQuestoesCorretas;
    }

    public void setNumeroDeQuestoesCorretas(int numeroDeQuestoesCorretas) {
        this.numeroDeQuestoesCorretas = numeroDeQuestoesCorretas;
    }

    public Questao getQuestao() {
        return questoes.get(numeroDeQuestoesRespondidas);
    }

    public boolean responderQuestao(String resposta) {
        boolean acertou = questoes.get(numeroDeQuestoesRespondidas++).getResposta().trim()
                .equalsIgnoreCase(resposta.trim());
        if (acertou)
            numeroDeQuestoesCorretas++;
        return acertou;
    }
}
