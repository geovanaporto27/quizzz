package quizgame.menu;

import java.util.List;

import quizgame.repository.PerguntasRepository;

import java.util.ArrayList;

public class Pergunta {
    public String titulo;
    private List<Alternativa> alternativas; 

    // Construtor da classe Pergunta
    public Pergunta(String titulo, String titulo2) {
        this.titulo = titulo;
        this.alternativas = new ArrayList<>(); // Inicializa a lista de alternativas como uma ArrayList
    }
    
    // Métodos getter e setter para a lista de alternativas
    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    // Métodos getter e setter para o título da pergunta
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Método para adicionar uma alternativa à lista de alternativas
    public void adicionarAlternativa(Alternativa alternativa) {
        alternativas.add(alternativa);
    }

    // Método para verificar se a resposta do usuário está correta
    public boolean verificarResposta(String respostaUsuario) {
        for (Alternativa alternativa : alternativas) {
            if (alternativa.getOpcao().equalsIgnoreCase(respostaUsuario) && alternativa.isOpcaoCorreta()) {
                return true;
            }
        }
        return false;
    }

    // Método para obter a resposta correta da pergunta
    public String obterRespostaCorreta() {
        for (Alternativa alternativa : alternativas) {
            if (alternativa.isOpcaoCorreta()) {
                return alternativa.getOpcao() + ". " + alternativa.getAfirmativa();
            }
        }
        return "Resposta não encontrada";
    }
}