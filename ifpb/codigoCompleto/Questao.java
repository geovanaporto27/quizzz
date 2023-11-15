package main.java.br.edu.ifpb.codigoCompleto;

public class Questao {
    private int id;
    private String pergunta;
    private String resposta;

    public Questao(String pergunta, String resposta) {
        setPergunta(pergunta);
        setResposta(resposta);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public boolean equals(Questao outra) {
        return getPergunta() == outra.getPergunta();
    }

    @Override
    public String toString() {
        return getPergunta() + getResposta();
    }

}

