import java.util.ArrayList;

public class QuestaoFechada extends Questao {
    private ArrayList<String> alternativas = new ArrayList<>();

    public QuestaoFechada(String pergunta, String resposta, ArrayList<String> alternativas) {
        super(pergunta, resposta);
        setAlternativas(alternativas);
    }

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPergunta() + "\n");
        for (int i = 0; i < alternativas.size(); i++)
            stringBuilder
                    .append(alternativas.get(i) + "\n");
        return stringBuilder.toString();
    }
}